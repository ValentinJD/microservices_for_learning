package ru.shop.book.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.shop.book.model.Price;

@Component
public class PriceSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper mapper;

    @PostMapping("price/{bookId}")
    public void sendOrder(@PathVariable String bookId, @RequestBody Price price) throws JsonProcessingException {
        kafkaTemplate.send("price", bookId, mapper.writeValueAsString(price));
    }

}
