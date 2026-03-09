package com.ardatoa.taskmanagerapi.service.task.dto;

import com.ardatoa.taskmanagerapi.common.filter.BaseFilter;
import com.ardatoa.taskmanagerapi.service.task.entity.Task;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

@Data
@EqualsAndHashCode(callSuper = true)
public class TaskFilter extends BaseFilter implements Specification<Task> {

    private String title;
    private String description;

    @Override
    public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        List<Predicate> predicates = new ArrayList<>();

        if (title != null && !title.trim().isEmpty()){
            predicates.add(cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
        }

        if (description != null && !description.trim().isEmpty()) {
            predicates.add(cb.like(cb.lower(root.get("description")), "%" + description.toLowerCase() + "%"));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}