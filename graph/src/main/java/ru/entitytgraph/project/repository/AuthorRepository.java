package ru.entitytgraph.project.repository;


import ru.entitytgraph.project.model.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

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
