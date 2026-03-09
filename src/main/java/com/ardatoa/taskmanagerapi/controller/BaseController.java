package com.ardatoa.taskmanagerapi.controller;

import com.ardatoa.taskmanagerapi.common.response.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface BaseController<E, R, C, U> {

    ApiResponse<R> save(@RequestBody C createDto);

    ApiResponse<List<R>> findAll();

    ApiResponse<R> findById(@PathVariable Long id);

    ApiResponse<R> update(@PathVariable Long id, @RequestBody U updateDto);

    ApiResponse<Void> deleteById(@PathVariable Long id);

    ApiResponse<Page<R>> findAllPaged(@PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable);
}