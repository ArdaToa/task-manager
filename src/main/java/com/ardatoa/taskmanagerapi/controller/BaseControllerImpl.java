package com.ardatoa.taskmanagerapi.controller;

import com.ardatoa.taskmanagerapi.common.response.ApiResponse;
import com.ardatoa.taskmanagerapi.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseControllerImpl<E, R, C, U> implements BaseController<E, R, C, U> {

    private final BaseService<E, R, C,U > baseService;

    @Override
    @PostMapping
    public ApiResponse<R> save(@RequestBody C createDto) {
        R data = baseService.save(createDto);
        return ApiResponse.success(data, "Kayıt başarıyla oluşturuldu.");
    }

    @Override
    @GetMapping
    public ApiResponse<List<R>> findAll() {
        List<R> data = baseService.findAll();
        return ApiResponse.success(data, "Kayıt getirildi.");
    }

    @Override
    @GetMapping("/{id}")
    public ApiResponse<R> findById(@PathVariable Long id) {
        R data = baseService.findById(id);
        return ApiResponse.success(data, "Kayıt başarıyla getirildi.");
    }

    @Override
    @PutMapping("/{id}")
    public ApiResponse<R> update(@PathVariable Long id, @RequestBody U updateDto) {
        R data = baseService.update(id, updateDto);
        return ApiResponse.success(data, "Veri başarıyla güncellendi.");
    }

    @Override
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteById(@PathVariable Long id) {
        baseService.deleteById(id);
        return ApiResponse.success(null, "Kayıt başarıyla silindi.");
    }
}