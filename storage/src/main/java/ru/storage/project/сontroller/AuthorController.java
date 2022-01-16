package ru.storage.project.сontroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.storage.project.model.Author;
import ru.storage.project.repository.AuthorRepository;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/all")
    @Operation(summary = "Список авторов", description = "Информация по авторам")
    List<Author> getList() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение данных автора", description = "Информация по автору")
    Author getAuthor(@PathVariable @Min(1) @Parameter(description = "Идентификатор автора")Long id) {
        return authorRepository.getAuthorById(id);
    }
}
