package com.first.project.service.impl;

import com.first.project.service.IndexService;
import org.springframework.stereotype.Component;


@Component
public class IndexServiceImpl implements IndexService {
    @Override
    public boolean login(String userName, String pwd) {
        if(userName.equals("zhangsan")&&pwd.equals("123456")){
            return true;
        }
        return false;
    }
}
