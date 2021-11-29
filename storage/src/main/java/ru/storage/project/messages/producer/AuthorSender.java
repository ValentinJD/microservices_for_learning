package ru.storage.project.messages.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.storage.project.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper mapper;

    @PostMapping("author/{msgId}")
    public void sendOrder(@PathVariable String msgId, @RequestBody Author author) throws JsonProcessingException {
        kafkaTemplate.send("author", msgId, mapper.writeValueAsString(author));
    }

    @Autowired
    ProducerBinding producerBinding;

    @GetMapping("/test")
    public void send() {
        producerBinding.op("Hello");
    }


}
