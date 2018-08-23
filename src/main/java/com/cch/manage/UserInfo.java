package com.cch.manage;

import com.cch.accont.service.UserService;
import com.cch.base.AjaxReturn;
import com.cch.base.Table;
import com.cch.entity.User;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping(value = "/manage/userinfo")
public class UserInfo {

    @Resource
    private UserService userService;

    @PostMapping(value = "/list")
    @ResponseBody
    public Table list(@RequestParam int page , @RequestParam int limit){
        PageHelper.startPage(page,limit);
        Table table = new Table();
        List<User> list=userService.listAll();
        table.setData(list);
        table.setCount(list.size());

        return table;
    }


    @PostMapping(value = "/add")
    @ResponseBody
    public AjaxReturn list(@RequestBody User userinfo){
        userService.save(userinfo);
        return new AjaxReturn(0,"添加成功");
    }

}
