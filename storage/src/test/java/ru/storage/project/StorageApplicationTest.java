package ru.storage.project;

import ru.storage.project.model.Author;
import ru.storage.project.model.Book;
import ru.storage.project.model.Sheet;
import ru.storage.project.repository.AuthorRepository;
import ru.storage.project.repository.BookRepository;
import ru.storage.project.repository.SheetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class StorageApplicationTest {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    SheetRepository sheetRepository;



    @Test
//    @Transactional
    void test() {
      /*  int id = 1;
        EntityGraph entityGraph = entityManager.getEntityGraph("post-entity-graph-with-comment-users");
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);
        criteriaQuery.where(criteriaBuilder.equal(root.<Long>get("id"), id));
        TypedQuery<Author> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setHint("javax.persistence.loadgraph", entityGraph);
        Author post = typedQuery.getSingleResult();*/

        Author author = new Author();
        author.setName("Author");


        authorRepository.save(author);

        Sheet sheet = new Sheet();
        sheet.setContent("content1");

        Sheet sheet2 = new Sheet();
        sheet2.setContent("content2");

        Sheet sheet3 = new Sheet();
        sheet3.setContent("content3");

        Sheet sheet4 = new Sheet();
        sheet4.setContent("content4");

        sheetRepository.save(sheet);
        sheetRepository.save(sheet2);
        sheetRepository.save(sheet3);
        sheetRepository.save(sheet4);

        Book book = new Book();
        book.setNameBook("Книга1");

        Book book2 = new Book();
        book2.setNameBook("Книга2");

        bookRepository.save(book);

        bookRepository.save(book2);



//        book.setAuthor(author);


//        book2.setAuthor(author);

//        book.setSheet(Arrays.asList(sheet, sheet2));

//        book2.setSheet(Arrays.asList(sheet3, sheet4));

        bookRepository.save(book);

        bookRepository.save(book2);

        author.setBook(Arrays.asList(book, book2));

        authorRepository.save(author);

//        Author author1 = authorRepository.getAuthorById(7l);

//        Author authorWithBook = authorRepository.AuthorWithBook(7l);

//        Author authorWithBookAndSheets = authorRepository.getAuthorWithBookAndSheets(7l);

        System.out.println(author);
    }

}