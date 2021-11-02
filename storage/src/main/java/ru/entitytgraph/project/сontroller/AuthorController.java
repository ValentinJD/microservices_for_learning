package ru.entitytgraph.project.сontroller;

import ru.entitytgraph.project.model.Author;
import ru.entitytgraph.project.model.Book;
import ru.entitytgraph.project.model.Price;
import ru.entitytgraph.project.model.Sheet;
import ru.entitytgraph.project.repository.AuthorRepository;
import ru.entitytgraph.project.repository.BookRepository;
import ru.entitytgraph.project.repository.PriceRepository;
import ru.entitytgraph.project.repository.SheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    SheetRepository sheetRepository;

    @Autowired
    PriceRepository repository;

    boolean init = true;

    @GetMapping("getPrice/{bookId}")
    Price getPrice(@PathVariable Integer bookId) {
        if (init) {
            init();
            init = false;
        }
        return repository.getByBookId(bookId);
    }

    @GetMapping("list")
    List<Author> getList() {
        if (init) {
            init();
            init = false;
        }
        return authorRepository.findAll();
    }

    @GetMapping("author/{id}")
    Author getAuthor(@PathVariable Long id) {
        if (init) {
            init();
            init = false;
        }
        return authorRepository.getAuthorById(id);
    }

    @GetMapping("book/all")
    List<Book> getBook() {
        if (init) {
            init();
            init = false;
        }
        return bookRepository.findAll();
    }

    @GetMapping("sheet/all")
    List<Sheet> getSheet() {
        if (init) {
            init();
            init = false;
        }
        return sheetRepository.findAll();
    }

    void init() {
        Sheet sheet = new Sheet();
        sheet.setContent("content1");

        Sheet sheet2 = new Sheet();
        sheet2.setContent("content2");

        Sheet sheet3 = new Sheet();
        sheet3.setContent("content3");

        Sheet sheet4 = new Sheet();
        sheet4.setContent("content4");

        sheetRepository.save(sheet);
        sheetRepository.save(sheet2);
        sheetRepository.save(sheet3);
        sheetRepository.save(sheet4);

        Book book = new Book();
        book.setNameBook("Книга1");
        book.setSheet(Arrays.asList(sheet, sheet2));

        bookRepository.save(book);
//        sheet.setBook(book);
//        sheetRepository.save(sheet);
//        sheet2.setBook(book);
//        sheetRepository.save(sheet2);

        Book book2 = new Book();
        book2.setNameBook("Книга2");
        book2.setSheet(Arrays.asList(sheet3, sheet4));
        bookRepository.save(book2);

        Author author = new Author();
        author.setName("Author");

        author.setBook(Arrays.asList(book, book2));



//        book.setAuthor(author);

//        book2.setAuthor(author);

//        bookRepository.saveAll(Arrays.asList(book, book2));

        authorRepository.save(author);

        Sheet sheet5 = new Sheet();
        sheet5.setContent("content1");

        Sheet sheet6 = new Sheet();
        sheet6.setContent("content2");

        Sheet sheet7 = new Sheet();
        sheet7.setContent("content3");

        Sheet sheet8 = new Sheet();
        sheet8.setContent("content4");

        sheetRepository.save(sheet5);
        sheetRepository.save(sheet6);
        sheetRepository.save(sheet7);
        sheetRepository.save(sheet8);

        Book book3 = new Book();
        book3.setNameBook("Книга1");
        book3.setSheet(Arrays.asList(sheet5, sheet6));

        bookRepository.save(book3);
//        sheet.setBook(book);
//        sheetRepository.save(sheet);
//        sheet2.setBook(book);
//        sheetRepository.save(sheet2);

        Book book4 = new Book();
        book4.setNameBook("Книга2");
        book4.setSheet(Arrays.asList(sheet7, sheet8));
        bookRepository.save(book4);

        Author author2 = new Author();
        author2.setName("Author");

        author2.setBook(Arrays.asList(book3, book4));



//        book.setAuthor(author);

//        book2.setAuthor(author);

//        bookRepository.saveAll(Arrays.asList(book, book2));

        authorRepository.save(author2);
    }
}
