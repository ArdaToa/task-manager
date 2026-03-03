package com.ardatoa.taskmanagerapi.mapper;

import java.util.List;

public interface BaseMapper<E, R> {
    R toResponseDto(E entity);

    List<R> toResponseDtoList(List<E> entityList);

}
