package ru.storage.project.service;

import org.springframework.data.jpa.domain.Specification;
import ru.storage.project.model.Book;

public class SpecificationUtil {

    public static Specification<Book> findByFieldName(String value, String field) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get(field), "%" + value + "%")
                );
    }

}
