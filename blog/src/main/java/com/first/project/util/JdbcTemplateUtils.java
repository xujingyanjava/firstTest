package com.first.project.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateUtils {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public JdbcTemplateUtils(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
