package com.first.project.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface CustomRepository <T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

}
