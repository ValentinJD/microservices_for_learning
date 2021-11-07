package ru.storage.project.service;

import org.springframework.data.jpa.domain.Specification;
import ru.storage.project.model.*;

import javax.persistence.criteria.*;

public class SpecificationUtil {

    public static Specification<Book> findByFieldName(String value, String field) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get(field), "%" + value + "%"));
    }

    public static Specification<Book> addSearchByAuthorName(String authorName, Specification<Book> spec) {
        return spec.and(  (root, query, cb) -> {
            Join<Book, Author> join = root.join(Book_.author);
            return cb.like(join.get(Author_.name), "%" + authorName + "%");
        }) ;
    }
/*
Step 1: Create an inner join to the specified attribute.
Join<Object, Object> joinParent = root.join("hobbies");
Step 2: Create a path corresponding to the referenced attribute.
Path expression = joinParent.get("hobby");
Step 3: Add the criteria to the predicates. Below predicate check for the hobby "Cricket".
predicates.add(criterailBuilder.equal(expression, "Cricket"));
 */


}
