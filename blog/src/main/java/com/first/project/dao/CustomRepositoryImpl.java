package com.first.project.dao;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class CustomRepositoryImpl <T, ID extends Serializable> extends SimpleJpaRepository<T,ID>
        implements CustomRepository<T,ID>{


    private final EntityManager entityManager;


    public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }
}
