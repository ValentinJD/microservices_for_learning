package ru.storage.project.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.JpaSort;
import ru.storage.project.model.Book;
import ru.storage.project.util.InitializerData;

import java.util.List;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    InitializerData initializerData;

    @BeforeEach
    void initData() {
        initializerData.init();
    }

    @AfterEach
    void clearData() {
        initializerData.clearData();
    }

    @Test
    @DisplayName("Получить все книги с сортировкой с агрегиующей функцией")
    void test() {
        List<Book> list = bookRepository.findAll(JpaSort.unsafe("CAST (substring(human_readable_id, 9) AS int)"));
        Assertions.assertEquals(6, list.size());
        Assertions.assertEquals(initializerData.getBook().getNameBook(),list.get(0).getNameBook());
        Assertions.assertEquals(initializerData.getBook6().getNameBook(),list.get(5).getNameBook());
    }
}
