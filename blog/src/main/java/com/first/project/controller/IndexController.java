package com.first.project.controller;

import com.first.project.service.IndexService;
import com.first.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Resource
    private TestService testService;

    @RequestMapping("/helloTest")
    public String index(){
        String userName = "zhangsan";
        String pwd = "123456";
        System.out.println(indexService.login(userName,pwd));

        testService.testConnecr();

        return "/hello";
    }
}
