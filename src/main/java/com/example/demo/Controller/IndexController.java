package com.example.demo.Controller;
import com.example.demo.Service.UserService;
import com.example.demo.bean.User;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    UserService userService;
    /**
     * 跳转到登陆页面
     *
     * @return
     */
    @GetMapping(value = {"/login"})
    public String loginPage(Map<String,Object> map) {
        //跳转到登录页 login.html
//        return "redirect:aa.html";
        map.put("msg","123");
        return "login";
    }


}