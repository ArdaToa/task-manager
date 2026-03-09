package com.ardatoa.taskmanagerapi.service.base;

import com.ardatoa.taskmanagerapi.domain.BaseDomain;
import com.ardatoa.taskmanagerapi.mapper.BaseUpdateMapper;
import com.ardatoa.taskmanagerapi.repository.BaseRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;


public abstract class BaseServiceImpl<E extends BaseDomain, R, C, U> implements BaseService<E, R, C, U> {

    protected final BaseRepo<E> repository;
    protected final BaseUpdateMapper<E, R, C, U> mapper;

    public BaseServiceImpl(BaseRepo<E> repository, BaseUpdateMapper<E, R, C, U> mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public R save(C createDto) {
        E entity = mapper.toEntity(createDto);
        E savedEntity = repository.save(entity);
        return mapper.toResponseDto(savedEntity);
    }

    @Override
    public R update(Long id, U updateDto){
        E entity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Kayıt Bulunamadı! ID: " + id)
        );
        mapper.updateEntity(entity, updateDto);
        E updatedEntity = repository.save(entity);
        return mapper.toResponseDto(updatedEntity);
    }

    @Override
    public R findById(Long id){
        E entity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Kayıt Bulunamadı! ID: " + id)
        );
        return mapper.toResponseDto(entity);
    }

    @Override
    public List<R> findAll(){
        List<E> entities = repository.findAll();
        return mapper.toResponseDtoList(entities);
    }

    @Override
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Override
    public Page<R> findAll(Pageable pageable) {
        Page<E> entities = repository.findAll(pageable);
        return entities.map(entity -> mapper.toResponseDto(entity));
    }

    @Override
    public Page<R> findAll(Specification<E> spec, Pageable pageable) {
        Page<E> entities = repository.findAll(spec, pageable);

        return entities.map(entity -> mapper.toResponseDto(entity));
    }
}