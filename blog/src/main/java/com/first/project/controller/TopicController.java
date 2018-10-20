package com.first.project.controller;

import com.first.project.domain.common.AjaxJson;
import com.first.project.domain.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TopicController {

    private static final Logger log = LoggerFactory.getLogger(TopicController.class);

    @GetMapping("/topic/getTopicList")
    public AjaxJson getTopicList(){
        AjaxJson ajaxJson = new AjaxJson();
        try{
            List<Topic> topicList = new ArrayList<>(10);
            Topic topic = new Topic();
            topic.setAuthor("张三");
            topic.setContent("123456");
            Date today = new Date();
            topic.setCreateDate(today);
            topic.setUpdateDate(today);
            topic.setClickTime(0);
            topicList.add(topic);
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("topicList",topicList);
            ajaxJson.setObj(resultMap);
        }catch (Exception e){
            e.printStackTrace();
            log.warn("获取列表失败");
        }
        return ajaxJson;
    }
}
