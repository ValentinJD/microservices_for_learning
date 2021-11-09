package ru.storage.project.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.storage.project.model.*;
import ru.storage.project.repository.AuthorRepository;

import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import java.util.Optional;

@Service
public class ServiceAuthor {

    @Autowired
    AuthorRepository authorRepository;


    public Iterable<Author> getAuthor(BooleanExpression hasName) {
        return authorRepository.findAll(hasName);
    }

    public Optional<Author> getAuthorWithBook() {
        Specification<Author> byFieldName = findByFieldName("Пушкин", "name");
        return authorRepository.findOne(byFieldName);
    }

    public Specification<Author> findByFieldName(String value, String field) {
        return (root, query, criteriaBuilder) -> {
            root.fetch("book", JoinType.LEFT);

            return criteriaBuilder.like(root.get(field), "%" + value + "%");
        };

    }
}
