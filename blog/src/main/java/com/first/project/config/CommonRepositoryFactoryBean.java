package com.first.project.config;

import com.first.project.dao.CustomRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class CommonRepositoryFactoryBean <T extends JpaRepository<S, ID>, S, ID extends Serializable> extends JpaRepositoryFactoryBean<T, S, ID>{


    /**
     * Creates a new {@link JpaRepositoryFactoryBean} for the given repository interface.
     *
     * @param repositoryInterface must not be {@literal null}.
     */
    public CommonRepositoryFactoryBean(Class repositoryInterface) {
        super(repositoryInterface);
    }


    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new CommonRepositoryFactory(entityManager);
    }

    private static class CommonRepositoryFactory <T, ID extends Serializable> extends JpaRepositoryFactory {


        public CommonRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
        }

        @Override
        protected SimpleJpaRepository<T,ID> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
            return new CustomRepositoryImpl<T,ID>((Class<T>)information.getDomainType(), entityManager);
        }

        //重写getRepositoryBaseClas方法并且获得当前自定义的Repository的实现类型
        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata){
            return CustomRepositoryImpl.class;
        }

    }

}
