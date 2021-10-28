package com.example.demo.Controller;

import com.example.demo.utils.IpUtil;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class helloController {
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/hello")
    public ModelAndView gethellopage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("key", 12345);
        //System.out.println("test");
        System.out.println(IpUtil.getIpAddr(request));
        return modelAndView;
    }

    @RequestMapping("/hello2/{id}")
    public String topage(Map<String,Object> map,String id){
        map.put("key","2326520660");
        map.put("id",id);
        return "redirect:aa.html";
    }
    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id){
        return "views/level1/"+id;
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id){
        return "views/level2/"+id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id){
        return "views/level3/"+id;
    }

}
