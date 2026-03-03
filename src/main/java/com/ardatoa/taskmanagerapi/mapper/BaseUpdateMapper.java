package com.ardatoa.taskmanagerapi.mapper;

import org.mapstruct.MappingTarget;

public interface BaseUpdateMapper<E,R,C,U> extends BaseCreateMapper<E, R, C> {

    void updateEntity(@MappingTarget E entity, U updateDto);

}
