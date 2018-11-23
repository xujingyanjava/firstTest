package com.first.project.controller;

import com.first.project.dao.TopicDao;
import com.first.project.domain.Topic;
import com.first.project.service.IndexService;
import com.first.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private TopicDao topicDao;


    @RequestMapping("index")
    public String index(ModelMap modelMap){

        PageRequest pageRequest = new PageRequest(0,17);
        Page<Topic> topicList =  topicDao.findAll(pageRequest);

//        modelMap.put("topicList",topicList);
        modelMap.put("topicList",topicList.getContent());

        return "index";
    }
}
