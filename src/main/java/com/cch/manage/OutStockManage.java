package com.cch.manage;

import com.cch.accont.service.StockRemovalService;
import com.cch.accont.service.SupplierService;
import com.cch.base.AjaxReturn;
import com.cch.base.Table;
import com.cch.entity.Repertory;
import com.cch.entity.StockRemoval;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/outStockManage")
public class OutStockManage {

    @Resource
    private StockRemovalService stockRemovalService;

    /**
     * 出库纪录
     * @return
     */
    @GetMapping(value = "/toOutlist")
    public String toOutList(){

        return "manage/out/outlist";
    }


    /**
     * 出库纪录列表
     * @param page
     * @param limit
     * @return
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public Table repertorylist(@RequestParam int page , @RequestParam int limit){
        PageHelper.startPage(page,limit);
        Page<StockRemoval> stockRemovals= (Page<StockRemoval>) stockRemovalService.listAll();

        return new Table((int) stockRemovals.getTotal(), stockRemovals);
    }


    /**
     * 删除出库纪录
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/del")
    @ResponseBody
    public AjaxReturn delRepertory(@RequestParam String id) {

        System.out.println("id"+id);

        try{

            stockRemovalService.delete(id);
        } catch (Exception e){
            return new AjaxReturn(1, "删除失败！！");
        }
        return new AjaxReturn(0, "删除成功！！");
    }
}
