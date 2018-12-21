package com.cch.manage;

import com.cch.accont.service.RepertoryService;
import com.cch.accont.service.SupplierService;
import com.cch.base.AjaxReturn;
import com.cch.base.Table;
import com.cch.entity.Repertory;
import com.cch.entity.Supplier;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/repertory")
public class RepertoryManage {

    @Resource
    private SupplierService supplierService;
    @Resource
    private RepertoryService repertoryService;

    /**
     * 库存
     *
     * @return
     */
    @GetMapping
    public String repertory() {

        return "manage/repertory/repertory";
    }


    /**
     * 库存列表
     *
     * @param page
     * @param limit
     * @return
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public Table repertorylist(@RequestParam int page, @RequestParam int limit) {
        PageHelper.startPage(page, limit);
        Table table = new Table();
        List<Repertory> list = repertoryService.listAll();
        table.setData(list);
        table.setCount(list.size());

        return table;
    }


    /**
     * 添加库存
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/add")
    public String toRepertoryAdd(Model model) {
        //查询所有供货商
        model.addAttribute("suppliers", supplierService.findAll());
        return "manage/repertory/add";
    }

    /**
     * 出库
     *
     * @param
     * @return
     */
    @GetMapping(value = "/out")
    public String toRepertoryOut(Model model) {
//        Repertory repertory = repertoryService.getByid(id);
        List<Supplier> suppliers = supplierService.findAll();
        List<Repertory> repertorys = repertoryService.findAll();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("repertorys", repertorys);
//        model.addAttribute("repertory",repertory);
        return "out";
    }






    /**
     * 删除库存
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/del")
    @ResponseBody
    public AjaxReturn delRepertory(@RequestParam String id) {

        System.out.println("id"+id);

        try{

            repertoryService.delete(id);
        } catch (Exception e){
            return new AjaxReturn(1, "删除失败！！");
        }
        return new AjaxReturn(0, "删除成功！！");
    }

}
