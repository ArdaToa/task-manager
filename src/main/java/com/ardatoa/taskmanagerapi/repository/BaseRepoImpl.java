package com.ardatoa.taskmanagerapi.repository;

import com.ardatoa.taskmanagerapi.domain.BaseDomain;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepoImpl<T extends BaseDomain> extends SimpleJpaRepository<T, Long> implements BaseRepo<T>{

    private final EntityManager entityManager;

    public BaseRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void delete(T entity) {
        entity.setDeleted(true);
        super.delete(entity);
    }

    public void deleteById(Long id){
        findById(id).ifPresent(this::delete);
    }

}
