package com.cch.accont;

import com.cch.accont.service.UserService;
import com.cch.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class Login {
    @Resource
    private UserService userService;

    @PostMapping(value = "/login")
    public String login(HttpServletRequest request){
        String name = request.getParameter("log_username");
        User user = userService.getByuserName(name);
        System.out.println(user);
        if(user==null){
            return "/login";
        }
        request.setAttribute("name",name);
//        UsernamePasswordToken token = new UsernamePasswordToken (user.getUserName (),user.Sal(),rememberMe);
//        Subject subject = SecurityUtils.getSubject();
//        model.addAttribute(user);
//        try {
//            subject.login (token);
//        } catch (UnknownAccountException e) {
//            model.addAttribute("tig","账号或密码错误");
//            e.printStackTrace();
//            logger.info ("账号或密码错误");
//        } catch (Exception e){
//            model.addAttribute("tig","账号或密码错误");
//            e.printStackTrace();
//            logger.info ("账号或密码错误");
//        }
//        if (subject.isAuthenticated()) {
//            subject.getSession ().setAttribute ("user",userService.getByuserName (user.getUserName ()));
//            subject.getSession().setAttribute("staff",(staffService.findOne(user.getUserName())==null)?new  Staff():staffService.findOne(user.getUserName()));
//            return "redirect:/";
//        } else {
//
//            return "/login";
//        }
        return "/main";
    }
}
