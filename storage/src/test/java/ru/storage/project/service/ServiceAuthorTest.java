package ru.storage.project.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.storage.project.model.Author;
import ru.storage.project.model.QAuthor;

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

    @Test
    @Transactional
    @DisplayName("Найти автора по имени")
    public void test() {
        QAuthor qAuthor = ExpressionUtil.getQAuthor();
        BooleanExpression hasNameExpression = ExpressionUtil.likeName(qAuthor, "Пушкин");

        List<Author> author = (List<Author>) serviceAuthor.getAuthor(hasNameExpression);
        Assertions.assertEquals(1, author.size());
    }

}
