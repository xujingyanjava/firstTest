package com.first.project;

import com.first.project.config.CommonRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.first.project.dao",repositoryFactoryBeanClass = CommonRepositoryFactoryBean.class)
@SpringBootApplication
//不启用数据源自动配置
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
