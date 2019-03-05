package com.cch.accont;

import com.cch.accont.service.UserService;
import com.cch.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Login {
    @Resource
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(HttpServletRequest request){
        String name = request.getParameter("log_username");
        String passWd = request.getParameter("log_password");
        User user = userService.getByuserName(name);
        System.out.println(user);
        if(user==null){
            request.setAttribute("error","用户名错误！");
            return "login";
        }
        if(!passWd.equals(user.getPassWd())){
            request.setAttribute("error","密码错误！");
            return "login";
        }
        request.setAttribute("name",name);
        return "main";
    }

    @GetMapping(value = "/loginOut")
    public String loginout(HttpSession session) {
        return "redirect:/";
    }
}
