package ru.storage.project.messages.producer;

import org.apache.kafka.common.header.Header;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import ru.storage.project.messages.bindings.BookSource;

@Component
public class ProducerBinding  {

    private final BookSource bookSource;


    public ProducerBinding(BookSource bookSource) {
        this.bookSource = bookSource;
    }

    public void op(String payload) {

        Message<String> msg = new Message<String>() {
            @Override
            public String getPayload() {
                return payload;
            }

            @Override
            public MessageHeaders getHeaders() {
                return null;
            }
        };

        bookSource.output().send(msg);
    }
}
