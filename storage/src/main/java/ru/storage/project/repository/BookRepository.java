package ru.storage.project.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.storage.project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book>,
        QuerydslPredicateExecutor<Book> {
}
