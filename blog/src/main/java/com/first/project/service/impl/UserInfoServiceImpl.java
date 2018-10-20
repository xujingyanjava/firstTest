package com.first.project.service.impl;

import com.first.project.domain.common.AjaxJson;
import com.first.project.config.LoginInfo;
import com.first.project.enums.ResponseEnums;
import com.first.project.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private LoginInfo loginInfo;

    @Override
    public AjaxJson login(String userName, String password) {
        AjaxJson ajaxJson = new AjaxJson();
        if(!userName.equals(loginInfo.getUserName()) || !password.equals(loginInfo.getPassword())){
            ajaxJson.setMsg(ResponseEnums.USER_ACCOUNT_ERROR.getMsg());
            ajaxJson.setSuccess(false);
            return ajaxJson;
        }
        ajaxJson.setMsg(ResponseEnums.SUCCESS.getMsg());
        return ajaxJson;
    }
}
