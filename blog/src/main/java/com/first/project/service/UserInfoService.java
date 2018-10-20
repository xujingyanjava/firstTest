package com.first.project.service;

import com.first.project.domain.common.AjaxJson;

public interface UserInfoService {

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    AjaxJson login(String userName,String password);
}
