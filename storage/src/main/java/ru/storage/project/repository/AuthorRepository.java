package ru.storage.project.repository;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.storage.project.model.Author;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.storage.project.model.Book;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author>
, QuerydslPredicateExecutor<Author> {

//    @Transactional
    @EntityGraph(attributePaths = {"book"})
//    @EntityGraph(value = "with-books-and-sheets")
//    @Query("SELECT a FROM Author a where a.id=:id")
//    @BatchSize(size = 100)
    Author getAuthorById(Long id);

/*    @Query("SELECT a FROM Author a " +
            "left join fetch a.book b " +
            "where a.id =:id"
           )
    Author AuthorWithBook(@Param("id") Long id);*/

    //    @EntityGraph("Author.books")
    @Query("SELECT a FROM Author a where a.id=:id")
    Optional<Author> find(Long id);


}
