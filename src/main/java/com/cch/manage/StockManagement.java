package com.cch.manage;

import com.alibaba.fastjson.JSON;
import com.cch.NumberToCN;
import com.cch.accont.service.CompanyService;
import com.cch.accont.service.RepertoryService;
import com.cch.accont.service.StockRemovalService;
import com.cch.accont.service.SupplierService;
import com.cch.base.AjaxReturn;
import com.cch.base.Table;
import com.cch.entity.Company;
import com.cch.entity.Repertory;
import com.cch.entity.StockRemoval;
import com.cch.entity.Supplier;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 入库管理
 */
@Controller
@RequestMapping(value = "/stockManage")
public class StockManagement {


    @Resource
    private StockRemovalService stockRemovalService;

    @Resource
    private SupplierService supplierService;
    @Resource
    private RepertoryService repertoryService;

    @Resource
    private CompanyService companyService;



    /**
     * 入库管理
     *
     * @return
     */
    @GetMapping(value = "/stockManage")
    public String stockManage() {

        return "manage/stockManage/stockManage";
    }





    /**
     * 入库
     *
     * @param repertory
     * @return
     */
    @PostMapping(value = "/stockManage/add")
    @ResponseBody
    public AjaxReturn in(@RequestBody Repertory repertory) {
        Repertory repertory1 = repertoryService.getBygoodsName(repertory.getGoodsName(), repertory.getSupplier());
        if (repertory1 != null) {
            repertory1.setGoodsNum(repertory1.getGoodsNum() + repertory.getGoodsNum());
            repertoryService.update(repertory1);
        } else {
            repertoryService.save(repertory);
        }
        return new AjaxReturn(0, "入库成功");
    }

    /**
     * 出库
     *
     * @param out
     * @return
     */
    @PostMapping(value = "/stockManage/out")
    @ResponseBody
    public AjaxReturn out(@RequestBody String out) {
        System.out.println(out);
        Repertory repertory = JSON.parseObject(out, Repertory.class);
        StockRemoval stockRemoval = JSON.parseObject(out, StockRemoval.class);
        System.out.println(out);
        Repertory repertory1 = repertoryService.getBygoodsName(repertory.getGoodsName(),repertory.getSupplier());
        String orderNum = stockRemoval.getOrderNum();
        if (repertory1 != null) {
            repertory1.setGoodsNum(repertory1.getGoodsNum() - repertory.getGoodsNum());
            repertoryService.update(repertory1);

//            StockRemoval stockRemoval = new StockRemoval();
            if(orderNum==null || orderNum.equals("")){
                orderNum = getOrderIdByTime();
            }
            stockRemoval.setOrderNum(orderNum);
            stockRemoval.setId(null);
            stockRemoval.setGoodsName(repertory.getGoodsName());
            stockRemoval.setGoodsNum(repertory.getGoodsNum());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss");
            String date = formatter.format(new Date());
            stockRemoval.setDate(date);
            stockRemoval.setState("1");
            stockRemovalService.save(stockRemoval);
        }

        return new AjaxReturn(0, orderNum);
    }



    /**
     * 打印出库单
     *
     * @param
     * @return
     */
    @GetMapping(value = "/print")
    public String print(@RequestParam String orderNum,Model model) {
        List<StockRemoval> stockRemovals = stockRemovalService.listByOrderNum(orderNum);

        BigDecimal totalMoney = new BigDecimal(0);
        BigDecimal totalNum = new BigDecimal(0);
        for (StockRemoval stockRemoval : stockRemovals) {
            BigDecimal money = new BigDecimal(stockRemoval.getMoney());
            BigDecimal num = new BigDecimal(stockRemoval.getGoodsNum());
            totalMoney = totalMoney.add(money);
            totalNum = totalNum.add(num);
        }
        NumberToCN number = new NumberToCN();
        String daxie = number.number2CNMontrayUnit(totalMoney);

        Company company = companyService.findAll().get(0);

        model.addAttribute("company",company);
        model.addAttribute("daxie",daxie);
        model.addAttribute("totalMoney",totalMoney);
        model.addAttribute("totalNum",totalNum);
        model.addAttribute("stockRemovals",stockRemovals);
        return "manage/repertory/print";
    }

    /**
     * 生成随机订单号
     */
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return newDate+result;
    }

}
