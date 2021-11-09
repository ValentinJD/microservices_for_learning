package ru.storage.project.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.storage.project.model.Author;
import ru.storage.project.model.QAuthor;
import ru.storage.project.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ServiceAuthorTest {

    @Autowired
    InitializerData initializer;

    @Autowired
    ServiceAuthor serviceAuthor;
    @Autowired
    AuthorRepository authorRepository;

    @BeforeEach
    private void init() {
        initializer.init();
    }

    @AfterEach
    private void clear() {
        initializer.clearData();
    }

    @Test

    @DisplayName("Найти автора по имени")
    public void test() {
        QAuthor qAuthor = ExpressionUtil.getQAuthor();
        BooleanExpression hasNameExpression = ExpressionUtil.likeName(qAuthor, "Пушкин");

        List<Author> author = (List<Author>) serviceAuthor.getAuthor(hasNameExpression);
        Assertions.assertEquals(1, author.size());
    }

    @Test
    @DisplayName("Найти автора по имени c книгами и контентом")
    public void test2() {

     Optional<Author> author = serviceAuthor.getAuthorWithBook();

        Assertions.assertTrue(author.get() !=null);
        Assertions.assertEquals(2, author.get().getBook().size());
        Assertions.assertEquals(2, author.get().getBook().get(0).getSheets().size());
    }

}
