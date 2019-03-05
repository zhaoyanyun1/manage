package com.cch.manage;

import com.alibaba.fastjson.JSON;
import com.cch.NumberToCN;
import com.cch.accont.service.*;
import com.cch.base.AjaxReturn;
import com.cch.entity.Company;
import com.cch.entity.Repertory;
import com.cch.entity.StockRemoval;
import com.cch.entity.StockRemovalDetails;
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
    @Resource
    private StockRemovalDetailService stockRemovalDetailService;



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
        Repertory repertory1 = repertoryService.getByNTSS(repertory.getGoodsName(),repertory.getGoodsType(),repertory.getSupplier(),repertory.getSpecification());
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
        StockRemovalDetails stockRemovalDetails = JSON.parseObject(out, StockRemovalDetails.class);
        System.out.println(out);
        Repertory repertory1 = repertoryService.getByNTSS(repertory.getGoodsName(),repertory.getGoodsType(),repertory.getSupplier(),repertory.getSpecification());
        String orderNum = stockRemoval.getOrderNum();


        if (repertory1 != null) {
            repertory1.setGoodsNum(repertory1.getGoodsNum() - repertory.getGoodsNum());
            repertoryService.update(repertory1);

            if(orderNum==null || orderNum.equals("")){
                orderNum = getOrderIdByTime();
                stockRemoval.setOrderNum(orderNum);
                stockRemoval.setId(null);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = formatter.format(new Date());
                stockRemoval.setDate(date);
                stockRemoval.setState("1");
                stockRemovalService.save(stockRemoval);
            }else{
                StockRemoval stockRemoval1 = stockRemovalService.stockremovalByOrderNum(orderNum);
                stockRemoval1.setMoney(new BigDecimal(stockRemoval.getMoney()).add(new BigDecimal(stockRemoval1.getMoney())).toString());
                stockRemovalService.update(stockRemoval1);
            }
            stockRemovalDetails.setState("1");
            stockRemovalDetails.setId(null);
            stockRemovalDetails.setOrderNum(orderNum);
            stockRemovalDetailService.save(stockRemovalDetails);

        }else{
            return new AjaxReturn(1, "出库失败，未找到库存");
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
        StockRemoval stockRemoval = stockRemovalService.stockremovalByOrderNum(orderNum);
        List<StockRemovalDetails> stockRemovalDetails = stockRemovalDetailService.listByOrderNum(orderNum);

        BigDecimal totalMoney = new BigDecimal(stockRemoval.getMoney());
        BigDecimal totalNum = new BigDecimal(0);
        for (StockRemovalDetails stockRemovalDetail : stockRemovalDetails) {
            totalNum = totalNum.add(new BigDecimal(stockRemovalDetail.getGoodsNum()));
        }
        NumberToCN number = new NumberToCN();
        String daxie = number.number2CNMontrayUnit(totalMoney);

        Company company = companyService.findAll().get(0);

        model.addAttribute("company",company);
        model.addAttribute("daxie",daxie);
        model.addAttribute("totalMoney",totalMoney);
        model.addAttribute("totalNum",totalNum);
        model.addAttribute("stockRemoval",stockRemoval);
        model.addAttribute("stockRemovalDetails",stockRemovalDetails);
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
