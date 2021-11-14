package ru.storage.project.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.storage.project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book>,
        QuerydslPredicateExecutor<Book> {


    @Query("SELECT b FROM Book b")
    List<Book> findAll(Sort sort);
}
