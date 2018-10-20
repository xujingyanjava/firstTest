package com.first.project.controller;

import com.first.project.domain.common.AjaxJson;
import com.first.project.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/goLogin")
    public AjaxJson goLogin(String userName,String password){
        AjaxJson ajaxJson = new AjaxJson();
        try{
            log.info("登录用户名：userName:{},password:{}",userName,password);
            ajaxJson = userInfoService.login(userName,password);
        }catch (Exception e){
            e.printStackTrace();
            log.info("登录失败");
        }
        return ajaxJson;
    }
}
