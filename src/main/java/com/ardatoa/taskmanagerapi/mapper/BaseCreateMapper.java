package com.ardatoa.taskmanagerapi.mapper;

public interface BaseCreateMapper<E, R, C> extends BaseMapper<E, R>{

    E toEntity(C createDto);

}
