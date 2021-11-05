package ru.storage.project.service;


import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.storage.project.model.Author;
import ru.storage.project.model.Book;
import ru.storage.project.model.Sheet;
import ru.storage.project.repository.AuthorRepository;
import ru.storage.project.repository.BookRepository;
import ru.storage.project.repository.SheetRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceBookTest {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private SheetRepository sheetRepository;


    @Before
    public void init() {
        Author author = new Author();
        author.setName("Пушкин А.С.");
        authorRepository.save(author);

        Book book = Book.builder()
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


        Book book2 =  Book.builder()
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

        Book book3 =  Book.builder()
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

        Book book4 =  Book.builder()
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
    }

    @Test
    @DisplayName("Поиск")
    public void test() {
        System.out.println("Nnnsdf");
    }

}