package com.first.project.service.impl;

import com.first.project.domain.Topic;
import com.first.project.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopicServiceImpl implements TopicService {

    private static final Logger log = LoggerFactory.getLogger(TopicServiceImpl.class);



    @Override
    public List<Topic> getTopicList() {
//        List<Topic> topicList = commonDao.findAll();
        return null;
    }
}
