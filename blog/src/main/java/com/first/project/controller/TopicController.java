package com.first.project.controller;

import com.first.project.common.BizConstants;
import com.first.project.dao.TopicDao;
import com.first.project.domain.Topic;
import com.first.project.domain.common.AjaxJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class TopicController {

    private static final Logger log = LoggerFactory.getLogger(TopicController.class);


    @Autowired
    private TopicDao topicDao;

    @RequestMapping(value = "getTopicList",method = RequestMethod.GET)
    public String getTopicList(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size) {
        try {

            Pageable pageable=PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));

            Page<Topic> topicListPage =  topicDao.findAll(pageable);
            List<Topic> topics = topicListPage.getContent();
            List<Topic> recommendList = new ArrayList<>();
            List<Topic> topicList = new ArrayList<>();
            for(Topic topic:topics){
                if(topic.getIsExcellent() == BizConstants.YES){
                    recommendList.add(topic);
                }else {
                    topicList.add(topic);
                }
            }
            model.addAttribute("recommendList",recommendList);
            model.addAttribute("topicList", topicList);
            model.addAttribute("hashNext",topicListPage.hasNext());
            model.addAttribute("number",topicListPage.getNumber());
            model.addAttribute("size",topicListPage.getSize());
            model.addAttribute("isFirst",topicListPage.isFirst());

            String aboutStr = "愿你历尽千帆，归来仍是少年。";
            model.addAttribute("aboutStr",aboutStr);

        } catch (Exception e) {
            e.printStackTrace();
            log.warn("获取列表失败");
        }
        return "blog/index";
    }

    @RequestMapping(value = "getTopicDetail",method = RequestMethod.GET)
    public String getTopicDetail(@RequestParam(required = true) String topicId, ModelMap modelMap){
        AjaxJson ajaxJson = new AjaxJson();
        try{
            Optional<Topic> topic = topicDao.findById(Long.parseLong(topicId));
            modelMap.put("topic",topic.get());

        }catch (Exception e){
            e.printStackTrace();
            log.warn("查询详情失败");
        }
        return "blog/topicDetail";

    }

}
