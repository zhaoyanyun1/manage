package com.cch.manage;

import com.cch.accont.service.SupplierService;
import com.cch.base.AjaxReturn;
import com.cch.base.Table;
import com.cch.entity.Supplier;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/supplier")
public class SupplierManage {


    @Resource
    private SupplierService supplierService;



    /**
     * 供货商管理
     *
     * @return
     */
    @GetMapping
    public String managein() {

        System.out.println("进入供货商管理页面");
        return "manage/supplier/supplierList";
    }


    /**
     * 供货商列表
     *
     * @param page
     * @param limit
     * @return
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public Table list(@RequestParam int page, @RequestParam int limit) {
        PageHelper.startPage(page, limit);
        Table table = new Table();
        List<Supplier> list = supplierService.listAll();
        table.setData(list);
        table.setCount(list.size());

        return table;
    }

    /**
     * 到添加供货商页面
     * @return
     */
    @GetMapping(value = "/add")
    public String toSupplierAdd() {

        return "manage/supplier/add";
    }

    /**
     * 添加供货商
     *
     * @param supplier
     * @return
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public AjaxReturn addSupplier(@RequestBody Supplier supplier) {
        supplierService.save(supplier);
        return new AjaxReturn(0, "添加成功");
    }


    /**
     * 删除供货商
     *
     * @param supplierName
     * @return
     */
    @PostMapping(value = "/del")
    @ResponseBody
    public AjaxReturn delSupplier(@RequestParam String supplierName) {

        System.out.println("supplierName:"+supplierName);

        try{
            supplierService.delete(supplierName);
        } catch (Exception e){
            e.printStackTrace();
            return new AjaxReturn(1, "删除失败！！");
        }
        return new AjaxReturn(0, "删除成功！！");

//        try {
//            supplierService.delete(supplierName);
//            return new AjaxReturn(0, "删除成功！！");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new AjaxReturn(1, "删除失败！！");
//        }
    }
}
