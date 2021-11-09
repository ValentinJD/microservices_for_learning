package ru.storage.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.storage.project.model.Author;
import ru.storage.project.model.Book;
import ru.storage.project.model.Sheet;
import ru.storage.project.repository.AuthorRepository;
import ru.storage.project.repository.BookRepository;
import ru.storage.project.repository.SheetRepository;

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

    @Override
    public void clearData() {
        sheetRepository.deleteAll();
        bookRepository.deleteAll();
        authorRepository.deleteAll();
    }


}
