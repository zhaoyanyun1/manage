package com.cch.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "customer")
public class CustomerManage {

    @GetMapping
    public String customer(){

        return "manage/customer/list";
    }
}
