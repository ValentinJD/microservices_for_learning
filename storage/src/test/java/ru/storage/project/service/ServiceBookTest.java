package ru.storage.project.service;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import ru.storage.project.dto.SearchDTO;
import ru.storage.project.model.Author;
import ru.storage.project.model.Book;
import ru.storage.project.model.Sheet;
import ru.storage.project.repository.AuthorRepository;
import ru.storage.project.repository.BookRepository;
import ru.storage.project.repository.SheetRepository;

import java.util.List;

@SpringBootTest
public class ServiceBookTest {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private SheetRepository sheetRepository;
    @Autowired
    ServiceBook serviceBook;

    private Book book;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Book book6;


/*    @BeforeEach
    public void clear() {

    }*/

    @BeforeEach
    public void init() {
        Author author = new Author();
        author.setName("Пушкин А.С.");
        authorRepository.save(author);

        book = Book.builder()
                .nameBook("Евгений Онегин")
                .author(author)
                .build();
        bookRepository.save(book);

        Sheet sheet1 = Sheet.builder()
                .content("Страница №1")
                .book(book)
                .build();

        sheetRepository.save(sheet1);

        Sheet sheet2 = Sheet.builder()
                .content("Страница №2")
                .book(book)
                .build();
        sheetRepository.save(sheet2);


        book2 = Book.builder()
                .nameBook("Барышня-Крестьянка")
                .author(author)
                .build();
        bookRepository.save(book2);


        Sheet sheet3 = Sheet.builder()
                .content("Страница №3")
                .book(book2)
                .build();
        sheetRepository.save(sheet3);

        Sheet sheet4 = Sheet.builder()
                .content("Страница №4")
                .book(book2)
                .build();
        sheetRepository.save(sheet4);

        Author author2 = Author.builder()
                .name("Толстой Л.Н.")
                .build();

        authorRepository.save(author2);

        book3 = Book.builder()
                .nameBook("АННА КАРЕНИНА")
                .author(author2)
                .build();
        bookRepository.save(book3);

        Sheet sheet5 = Sheet.builder()
                .content("Страница №5")
                .book(book3)
                .build();
        sheetRepository.save(sheet5);

        Sheet sheet6 = Sheet.builder()
                .content("Страница №6")
                .book(book3)
                .build();
        sheetRepository.save(sheet6);

        book4 = Book.builder()
                .nameBook("ВОЙНА И МИР. ТОМ 1")
                .author(author2)
                .build();
        bookRepository.save(book4);

        Sheet sheet7 = Sheet.builder()
                .content("Страница №7")
                .book(book4)
                .build();
        sheetRepository.save(sheet7);

        Sheet sheet8 = Sheet.builder()
                .content("Страница №8")
                .book(book4)
                .build();
        sheetRepository.save(sheet8);

        Author author3 = Author.builder()
                .name("Есенин С.А.")
                .build();
        authorRepository.save(author3);

        book5 = Book.builder()
                .nameBook("Белая черемуха под моим окном")
                .author(author3)
                .build();
        bookRepository.save(book5);

        Author author4 = Author.builder()
                .name("Лермонтов М.Ю.")
                .build();

        authorRepository.save(author4);

        book6 = Book.builder()
                .nameBook("Герой нашего времени")
                .author(author4)
                .build();
        bookRepository.save(book6);
    }

    @Test
    @DisplayName("Поиск по имени книги")
    @Transactional
    public void test() {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setNameBook("ВОЙНА");
        List<Book> search = serviceBook.searchAndSort(searchDTO).getContent();
        Assertions.assertEquals(1, search.size());
    }

    @Test
    @DisplayName("Поиск по автору книги с сортировкой по ИД книги Asc")
    @Transactional
    public void test2() {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setAuthorName("Пушкин");

        List<Book> search = serviceBook.searchAndSort(searchDTO).getContent();

        Assertions.assertEquals(2, search.size());
        Assertions.assertEquals(book.getId(), search.get(0).getId());
    }

    @Test
    @DisplayName("Поиск по автору книги с сортировкой Desc")
    @Transactional
    public void test3() {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setAuthorName("Пушкин");

        List<Book> search = serviceBook.searchAndSort(searchDTO).getContent();

        Assertions.assertEquals(2, search.size());
        Assertions.assertEquals(book.getId(), search.get(0).getId());
    }

    @Test
    @DisplayName("Поиск без параметров")
    @Transactional
    public void test4() {
        SearchDTO searchDTO = new SearchDTO();

        List<Book> search = serviceBook.searchAndSort(searchDTO).getContent();

        Assertions.assertEquals(6, search.size());
    }

    @Test
    @DisplayName("Поиск книг по автору с сортировкой Asc по автору")
    @Transactional
    public void test5() {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setAuthorName("Пушкин А.С.");
        searchDTO.setAsc(true);

        Page<Book> search = serviceBook.searchAndSort(searchDTO);
        List<Book> content = search.getContent();
        Assertions.assertEquals(2, content.size());
        Assertions.assertEquals(book.getNameBook(), content.get(0).getNameBook());
        Assertions.assertEquals(book.getAuthor().getName(), content.get(0).getAuthor().getName());
    }
}