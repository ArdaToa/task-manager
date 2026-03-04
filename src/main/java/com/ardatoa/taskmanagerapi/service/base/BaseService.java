package com.ardatoa.taskmanagerapi.service.base;

import java.util.List;

public interface BaseService<E, R, C, U>{

    R save(C createDto);

    R update(Long id, U updateDto);

    R findById(Long id);

    List<R> findAll();

    void deleteById(Long id);

}
