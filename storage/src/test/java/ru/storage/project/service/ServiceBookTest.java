package ru.storage.project.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import ru.storage.project.dto.SearchDTO;
import ru.storage.project.model.Book;
import ru.storage.project.util.InitializerData;

import java.util.List;

@SpringBootTest
public class ServiceBookTest  {

    @Autowired
    InitializerData initializerData;

    @Autowired
    private ServiceBook serviceBook;

    @BeforeEach
    public void init() {
        initializerData.init();
    }

    @AfterEach
    public void clear() {
        initializerData.clearData();
    }



    @Test
    @DisplayName("Поиск по имени книги")
    public void test() {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setNameBook("ВОЙНА");
        List<Book> search = serviceBook.searchAndSort(searchDTO).getContent();
        Assertions.assertEquals(1, search.size());
    }

    @Test
    @DisplayName("Поиск по автору книги с сортировкой по ИД книги Asc")
    public void test2() {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setAuthorName("Пушкин");

        List<Book> search = serviceBook.searchAndSort(searchDTO).getContent();

        Assertions.assertEquals(2, search.size());
        Assertions.assertEquals(initializerData.getBook().getId(), search.get(0).getId());
    }

    @Test
    @DisplayName("Поиск по автору книги с сортировкой Desc")
    public void test3() {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setAuthorName("Пушкин");

        List<Book> search = serviceBook.searchAndSort(searchDTO).getContent();

        Assertions.assertEquals(2, search.size());
        Assertions.assertEquals(initializerData.getBook().getId(), search.get(0).getId());
    }

    @Test
    @DisplayName("Поиск без параметров")
    public void test4() {
        SearchDTO searchDTO = new SearchDTO();

        List<Book> search = serviceBook.searchAndSort(searchDTO).getContent();

        Assertions.assertEquals(6, search.size());
    }

    @Test
    @DisplayName("Поиск книг по автору с сортировкой Asc по автору")
    public void test5() {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setAuthorName("Пушкин А.С.");
        searchDTO.setAsc(true);

        Page<Book> search = serviceBook.searchAndSort(searchDTO);
        List<Book> content = search.getContent();
        Assertions.assertEquals(2, content.size());
        Assertions.assertEquals(initializerData.getBook().getNameBook(), content.get(0).getNameBook());
//        Assertions.assertEquals(initializerData.book.getAuthor().getName(), content.get(0).getAuthor().getName());
    }

    @Test
    @DisplayName("Поиск книг по автору с сортировкой Asc по автору QDSL")
    public void test6() {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setAuthorName("Пушкин А.С.");
        searchDTO.setAsc(true);

        Page<Book> search = serviceBook.searchAndSortQDSL(searchDTO);
        List<Book> content = search.getContent();
        Assertions.assertEquals(2, content.size());
        Assertions.assertEquals(initializerData.getBook().getNameBook(), content.get(0).getNameBook());
//        Assertions.assertEquals(initializerData.book.getAuthor().getName(), content.get(0).getAuthor().getName());
    }
}