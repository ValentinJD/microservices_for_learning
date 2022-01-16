package ru.storage.project.messages.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.storage.project.dto.PriceDTO;
import ru.storage.project.model.Book;
import ru.storage.project.model.Price;
import ru.storage.project.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PriceListener {

    @Autowired
    PriceRepository repository;

    @Autowired
    ObjectMapper mapper;

    @KafkaListener(topics = "price", groupId = "1")
    void addPrice(String priceDto) throws JsonProcessingException {

        PriceDTO price1 = mapper.readValue(priceDto, PriceDTO.class);
        Price price = Price.builder()
                .price(price1.getPrice())
                .book(Book.builder()
                        .id(price1.getBookId())
                        .build()).build();

        repository.save(price);
    }


}
