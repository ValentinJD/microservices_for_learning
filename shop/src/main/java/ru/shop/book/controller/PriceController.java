package ru.shop.book.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.book.model.Price;
import ru.shop.book.producer.PriceSender;
import ru.shop.book.repository.PriceRepo;

@RestController
public class PriceController {

    @Autowired
    PriceRepo repo;

    @Autowired
    PriceSender priceSender;

    @PostMapping("add")
    void addPrice(@RequestBody Price price) throws JsonProcessingException {
        repo.save(price);
        priceSender.sendOrder(price.getBookId().toString(), price);
    }
}
