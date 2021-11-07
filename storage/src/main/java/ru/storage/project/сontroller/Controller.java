package ru.storage.project.сontroller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;
import ru.storage.project.dto.SearchDTO;
import ru.storage.project.model.Author;
import ru.storage.project.model.Book;
import ru.storage.project.model.Price;
import ru.storage.project.model.Sheet;
import ru.storage.project.repository.AuthorRepository;
import ru.storage.project.repository.BookRepository;
import ru.storage.project.repository.PriceRepository;
import ru.storage.project.repository.SheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import ru.storage.project.service.ServiceBook;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller extends DispatcherServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initData();
    }

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    SheetRepository sheetRepository;
    @Autowired
    PriceRepository repository;

    @Autowired
    ServiceBook serviceBook;

    @GetMapping("getPrice/{bookId}")
    Price getPrice(@PathVariable Integer bookId) {

        return repository.getByBookId(bookId);
    }

    @GetMapping("list")
    List<Author> getList() {

        return authorRepository.findAll();
    }

    @GetMapping("author/{id}")
    Author getAuthor(@PathVariable Long id) {

        return authorRepository.getAuthorById(id);
    }

    @GetMapping("book/all")
    List<Book> getBook() {

        return bookRepository.findAll();
    }

    @GetMapping("sheet/all")
    List<Sheet> getSheet() {

        return sheetRepository.findAll();
    }

    @PostMapping
    Page<Book> searchBook(@RequestBody SearchDTO searchDTO) {
        return serviceBook.searchAndSort(searchDTO);
    }

    void initData() {

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
}
