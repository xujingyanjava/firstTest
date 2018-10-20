package com.first.project.controller;

import com.first.project.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/helloTest")
    public String index(){
        String userName = "zhangsan";
        String pwd = "123456";
        System.out.println(indexService.login(userName,pwd));
        return "/hello";
    }
}
