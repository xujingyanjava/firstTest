package com.first.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    private static final Logger log = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("/login")
    public String login(ModelMap map){
        map.addAttribute("hello","hello world");
        log.info("跳转登录页面");
        return "/login/login";
    }
}
