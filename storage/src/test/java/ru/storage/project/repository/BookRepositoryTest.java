package ru.storage.project.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.domain.Specification;
import ru.storage.project.model.Book;
import ru.storage.project.service.SpecificationUtil;
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
    @DisplayName("Получить все книги с сортировкой с агрегирующей функцией")
    void test() {
        Specification specification = SpecificationUtil.findByFieldName("", "nameBook");
        Sort sort = Sort.by("forSortingByHumanReadableId");

        List<Book> list = bookRepository.findAll(specification, sort);

        Assertions.assertEquals(6, list.size());
        Assertions.assertEquals(initializerData.getBook().getNameBook(),list.get(0).getNameBook());
        Assertions.assertEquals(initializerData.getBook6().getNameBook(),list.get(5).getNameBook());
    }
}
