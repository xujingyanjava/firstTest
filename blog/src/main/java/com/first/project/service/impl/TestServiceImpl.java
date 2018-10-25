package com.first.project.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.first.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TestServiceImpl implements TestService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String testConnecr() {
//        int count = jdbcTemplate.queryForObject("select count(1) from test01", Integer.class);
        List<Map<String,Object>> selectList = jdbcTemplate.queryForList("select * from test01");
//        int count = jdbcTemplate.queryForObject("select count(1) from test01", Integer.class);
//        System.out.println(count);
        System.out.println(JSONArray.toJSONString(selectList));
        return "success";
    }
}
