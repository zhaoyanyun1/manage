package com.cch.manage;


import com.cch.accont.service.CompanyService;
import com.cch.base.AjaxReturn;
import com.cch.base.Table;
import com.cch.entity.Company;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/company")
public class CompanyManage {

    @Resource
    private CompanyService companyService;

    @GetMapping
    public String company(Model model){

        return "manage/company/company";
    }


    /**
     * 公司信息
     *
     * @param page
     * @param limit
     * @return
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public Table companyList(@RequestParam int page, @RequestParam int limit) {
        PageHelper.startPage(page, limit);
        Table table = new Table();
        List<Company> list = companyService.listAll();
        table.setData(list);
        table.setCount(list.size());

        return table;
    }
    /**
     * 跳转修改公司信息页面
     *
     * @return
     */
    @GetMapping(value = "/toUpdate")
    public String updateCompany(@RequestParam String company,Model model) {

//        System.out.println(company.getCompanyName());
        System.out.println(company);
        Company company1 = companyService.getByCompanyName(company);
        model.addAttribute("company",company1);
        return "manage/company/update";
    }

    /**
     * 修改公司信息
     *
     * @param company
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public AjaxReturn addSupplier(@RequestBody Company company) {
        companyService.update(company);
        return new AjaxReturn(0, "修改成功");
    }

}
