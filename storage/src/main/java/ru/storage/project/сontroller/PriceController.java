package ru.storage.project.сontroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.storage.project.model.Price;
import ru.storage.project.repository.PriceRepository;

@RestController
@RequestMapping(value = "/price")
public class PriceController {

    @Autowired
    PriceRepository priceRepository;

    @GetMapping("/{bookId}")
    @Operation(summary = "Получение цены", description = "Позволяет получить цену книги")
    Price getPrice(@PathVariable
                   @Parameter(description = "Идентификатор книги") Long bookId) {
        return priceRepository.getByBookId(bookId).get(0);
    }

}
