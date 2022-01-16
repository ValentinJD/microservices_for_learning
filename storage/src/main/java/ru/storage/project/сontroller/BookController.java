package ru.storage.project.сontroller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.storage.project.dto.SearchDTO;
import ru.storage.project.model.Book;
import ru.storage.project.repository.BookRepository;
import ru.storage.project.service.ServiceBook;

import java.util.List;

@Api
@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ServiceBook serviceBook;

    @GetMapping("/all")
    @Operation(summary = "Список книг", description = "Информация по книгам")
    List<Book> getBook() {
        return bookRepository.findAll();
    }

    @PostMapping("/search")
    @Operation(summary = "Поиск", description = "Поиск по книгам с пагинацией")
    Page<Book> searchBook(@RequestBody SearchDTO searchDTO) {
        return serviceBook.searchAndSort(searchDTO);
    }
}
