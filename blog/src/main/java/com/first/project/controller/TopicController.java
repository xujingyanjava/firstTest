package com.first.project.controller;

import com.first.project.dao.TopicDao;
import com.first.project.domain.Topic;
import com.first.project.domain.common.AjaxJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TopicController {

    private static final Logger log = LoggerFactory.getLogger(TopicController.class);


    @Autowired
    private TopicDao topicDao;

    @GetMapping("/topic/getTopicList")
    public AjaxJson getTopicList() {
        AjaxJson ajaxJson = new AjaxJson();
        try {
            Topic topic = new Topic();
            topic.setAuthor("张三");
            topic.setContent("123456");
            Date today = new Date();
            topic.setCreateDate(today);
            topic.setUpdateDate(today);
            topic.setClickTime(0);
            topicDao.save(topic);

            List<Topic> topicList = (List<Topic>) topicDao.findAll();

            Map<String, Object> resultMap = new HashMap<>(topicList.size());
            resultMap.put("topicList", topicList);
            ajaxJson.setObj(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("获取列表失败");
        }
        return ajaxJson;
    }

}
