package ru.storage.project.messages.bindings;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;


@EnableBinding
public class BookSource implements Source {

    @Override
    public MessageChannel output() {
        return new DirectChannel();
    }
}
