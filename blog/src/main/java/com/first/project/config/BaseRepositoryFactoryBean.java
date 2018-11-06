package com.first.project.config;

import com.first.project.dao.BaseInternalRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class BaseRepositoryFactoryBean <R extends JpaRepository<T, I>, T,
        I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I> {
    /**
     * Creates a new {@link JpaRepositoryFactoryBean} for the given repository interface.
     *
     * @param repositoryInterface must not be {@literal null}.
     */
    public BaseRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
        super(repositoryInterface);
    }

    protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
        return new BaseRepositoryFactory(em);
    }
    private static class BaseRepositoryFactory<T, I extends Serializable>
            extends JpaRepositoryFactory {
        public BaseRepositoryFactory(EntityManager em) {
            super(em);
        }
        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            // 使用自定义的实现类
            return BaseInternalRepositoryImpl.class;
        }
    }

}
