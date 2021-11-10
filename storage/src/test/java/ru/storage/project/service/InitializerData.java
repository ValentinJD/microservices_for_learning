package ru.storage.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.storage.project.model.Author;
import ru.storage.project.model.Book;
import ru.storage.project.model.Sheet;
import ru.storage.project.repository.AuthorRepository;
import ru.storage.project.repository.BookRepository;
import ru.storage.project.repository.SheetRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InitializerData implements Initializer{

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private SheetRepository sheetRepository;
    @Autowired
    private ServiceBook serviceBook;

    public AuthorRepository getAuthorRepository() {
        return authorRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public SheetRepository getSheetRepository() {
        return sheetRepository;
    }

    public ServiceBook getServiceBook() {
        return serviceBook;
    }

    public Book getBook() {
        return book;
    }

    public Book getBook2() {
        return book2;
    }

    public Book getBook3() {
        return book3;
    }

    public Book getBook4() {
        return book4;
    }

    public Book getBook5() {
        return book5;
    }

    public Book getBook6() {
        return book6;
    }

    Book book;
    Book book2;
    Book book3;
    Book book4;
    Book book5;
    Book book6;

    @Override
    public void init() {
        Author author = new Author();
        author.setName("Пушкин А.С.");

        book = Book.builder()
                .nameBook("Евгений Онегин")
                .author(author)
                .build();

        Sheet sheet1 = Sheet.builder()
                .content("Страница №1")
                .book(book)
                .build();

        Sheet sheet2 = Sheet.builder()
                .content("Страница №2")
                .book(book)
                .build();

        List<Sheet> list = new ArrayList<>();
        list.add(sheet1);
        list.add(sheet2);
        book.setSheets(list);

        book2 = Book.builder()
                .nameBook("Барышня-Крестьянка")
                .author(author)
                .build();

        Sheet sheet3 = Sheet.builder()
                .content("Страница №3")
                .book(book2)
                .build();

        Sheet sheet4 = Sheet.builder()
                .content("Страница №4")
                .book(book2)
                .build();

        List<Sheet> list2 = new ArrayList<>();
        list2.add(sheet3);
        list2.add(sheet4);
        book2.setSheets(list2);

        List<Book> listBook = new ArrayList<>();
        listBook.add(book);
        listBook.add(book2);
        author.setBook(listBook);

        authorRepository.save(author);

        Author author2 = Author.builder()
                .name("Толстой Л.Н.")
                .build();

        book3 = Book.builder()
                .nameBook("АННА КАРЕНИНА")
                .author(author2)
                .build();

        Sheet sheet5 = Sheet.builder()
                .content("Страница №5")
                .book(book3)
                .build();

        Sheet sheet6 = Sheet.builder()
                .content("Страница №6")
                .book(book3)
                .build();

        List<Sheet> list3 = new ArrayList<>();
        list3.add(sheet5);
        list3.add(sheet6);
        book3.setSheets(list3);

        book4 = Book.builder()
                .nameBook("ВОЙНА И МИР. ТОМ 1")
                .author(author2)
                .build();

        Sheet sheet7 = Sheet.builder()
                .content("Страница №7")
                .book(book4)
                .build();

        Sheet sheet8 = Sheet.builder()
                .content("Страница №8")
                .book(book4)
                .build();

        List<Sheet> list4 = new ArrayList<>();
        list4.add(sheet7);
        list4.add(sheet8);
        book4.setSheets(list4);

        List<Book> listBook3 = new ArrayList<>();
        listBook3.add(book3);
        listBook3.add(book4);
        author2.setBook(listBook3);

        authorRepository.save(author2);

        Author author3 = Author.builder()
                .name("Есенин С.А.")
                .build();

        book5 = Book.builder()
                .nameBook("Белая черемуха под моим окном")
                .author(author3)
                .build();

        Sheet sheet9 = Sheet.builder()
                .content("Страница №9")
                .book(book5)
                .build();

        List<Sheet> list5 = new ArrayList<>();
        list5.add(sheet9);

        book5.setSheets(list5);

        List<Book> listbook4 = new ArrayList<>();
        listbook4.add(book5);
        author3.setBook(listbook4);

        authorRepository.save(author3);

        Author author4 = Author.builder()
                .name("Лермонтов М.Ю.")
                .build();

        book6 = Book.builder()
                .nameBook("Герой нашего времени")
                .author(author4)
                .build();

        Sheet sheet10 = Sheet.builder()
                .content("Страница №10")
                .book(book6)
                .build();

        List<Sheet> sheets = new ArrayList<>();
        sheets.add(sheet10);
        book6.setSheets(sheets);

        List<Book> listbook5 = new ArrayList<>();
        listbook5.add(book6);
        author4.setBook(listbook5);
        authorRepository.save(author4);
    }

    @Override
    public void clearData() {
        authorRepository.deleteAll();
    }


}
