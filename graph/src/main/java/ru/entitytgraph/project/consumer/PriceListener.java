package ru.entitytgraph.project.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.entitytgraph.project.model.Price;
import ru.entitytgraph.project.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PriceListener {

    @Autowired
    PriceRepository repository;

    @Autowired
    ObjectMapper mapper;

    @KafkaListener(topics = "price",groupId = "1")
    void addPrice(String price) throws JsonProcessingException {
        Price price1 = mapper.readValue(price, Price.class);
        repository.save(price1);
    }


}
