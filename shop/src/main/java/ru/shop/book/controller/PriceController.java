package ru.shop.book.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;
import ru.shop.book.model.Price;
import ru.shop.book.producer.PriceSender;
import ru.shop.book.repository.PriceRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.List;

@RestController
public class PriceController extends DispatcherServlet {

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    PriceSender priceSender;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initData();
    }

    private void initData() {
        Price price = Price.builder().price(100).bookId(5).build();
        Price price2 = Price.builder().price(100).bookId(6).build();
        Price price3 = Price.builder().price(100).bookId(12).build();
        Price price4 = Price.builder().price(100).bookId(13).build();

        List<Price> list = Arrays.asList(price, price2, price3, price4);

        priceRepository.saveAll(list);
    }

    @PostMapping("add")
    void addPrice(@RequestBody Price price) throws JsonProcessingException {
        priceRepository.save(price);
        priceSender.sendOrder(price.getBookId().toString(), price);
    }
}
