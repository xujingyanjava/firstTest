package com.first.project.controller;

import com.first.project.domain.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class PageController {

    private static final Logger log = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("/login")
    public String login(ModelMap map){
        map.addAttribute("hello","hello world");
        log.info("跳转登录页面");
        return "/login/login";
    }

    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        List<Topic> topicList = new ArrayList<>(10);
        Topic topic = new Topic();
        topic.setAuthor("张三");
        topic.setContent("123456");
        Date today = new Date();
        topic.setCreateDate(today);
        topic.setUpdateDate(today);
        topic.setClickTime(0);
        topic.setTitle("标题1");
        topicList.add(topic);

        Topic topic1 = new Topic();
        topic1.setTitle("标题2");
        topic1.setContent("内容2.。。。");
        topicList.add(topic1);
        modelMap.put("topicList",topicList);
        return "/index";
    }
}
