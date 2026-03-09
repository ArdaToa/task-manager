package com.ardatoa.taskmanagerapi.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;

public interface BaseService<E, R, C, U>{

    R save(C createDto);

    R update(Long id, U updateDto);

    R findById(Long id);

    List<R> findAll();

    void deleteById(Long id);

    Page<R> findAll(Pageable pageable);

    Page<R> findAll(Specification<E> spec, Pageable pageable);
}