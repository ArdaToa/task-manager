package com.ardatoa.taskmanagerapi.common.filter;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

@Data
public class BaseFilter {

    private int page = 0;

    private int size = 10;

    private String sortBy = "id";

    private String sortDirection = "ASC";

    public Pageable toPageable() {
        Sort.Direction direction = sortDirection.equalsIgnoreCase("DESC")
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;
        String sortProperty = (sortBy == null || sortBy.trim().isEmpty()) ? "id" : sortBy;

        return PageRequest.of(page, size, Sort.by(direction, sortProperty));
    }
}