package com.cch.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/manage")
public class Manage {


    @PostMapping(value = "/in")
    public String managein(){


       return "in";
    }


    @GetMapping(value = "/client")
    public String client() {

        return "/manage/in";
    }

    @GetMapping(value = "/userManage")
    public String userManage(){


        return "/manage/usermanage";
    }
}
