package com.example.demo.Controller;


import com.example.demo.bean.User;

import com.example.demo.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Slf4j
@Controller
public class LoginController {
    @Resource
    UserService userService;

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/user/login")
    public String doLogin(User user, Map<String, Object> map, HttpSession session,HttpServletResponse response) {
        //从数据库中查询用户信息
        User loginUser = userService.getByUserNameAndPassword(user);
        if (loginUser != null) {
            session.setAttribute("loginUser", user);
            log.info("登陆成功，用户名：" + user.getLogin());
            if("y".equals(request.getParameter("isLogin"))){
                Cookie nameCookie = new Cookie("username", "admin" );
                // 设置cookies的有效期为三天
                nameCookie.setMaxAge(60 * 60 * 24 * 3);
                Cookie pwdCookie = new Cookie("password", "123456");
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }
            //防止重复提交使用重定向
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或密码错误");
            log.error("登陆失败");
            return "login";
        }
    }
/*
    @RequestMapping("/main.html")
    public String mainPage(){
        return "main";
    }*/
}