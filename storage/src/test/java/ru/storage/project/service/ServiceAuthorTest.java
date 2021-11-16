package ru.storage.project.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.storage.project.model.Author;
import ru.storage.project.model.QAuthor;
import ru.storage.project.util.InitializerData;

import java.util.List;

@SpringBootTest
public class ServiceAuthorTest {

    @Autowired
    InitializerData initializer;

    @Autowired
    ServiceAuthor serviceAuthor;

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
    @DisplayName("Найти автора по имени")
    public void test2() {

     List<Author> author = serviceAuthor.getAuthorWithBook();

        Assertions.assertTrue(author.get(0) !=null);
        Assertions.assertEquals(2, author.get(0).getBook().size());
    }

}
