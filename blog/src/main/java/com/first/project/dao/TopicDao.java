package com.first.project.dao;

import com.first.project.domain.Topic;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicDao extends CustomRepository<Topic,Long>{

}
