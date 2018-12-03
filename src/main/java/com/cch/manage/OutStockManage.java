package com.cch.manage;

import com.cch.accont.service.StockRemovalService;
import com.cch.accont.service.SupplierService;
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
     * 供货商管理
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
        List<StockRemoval> list= stockRemovalService.listAll();
        Page<StockRemoval> lists = (Page<StockRemoval>) list;

        return new Table((int) lists.getTotal(), lists);
    }
}
