package ru.storage.project.сontroller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.storage.project.model.Sheet;
import ru.storage.project.repository.SheetRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/sheet")
public class SheetController {

    @Autowired
    SheetRepository sheetRepository;


    @GetMapping("/all")
    @Operation(summary = "Получение страниц", description = "Позволяет получить все страницы")
    List<Sheet> getSheet() {
        return sheetRepository.findAll();
    }
}
