package ru.shop.book.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.shop.book.model.Price;
import ru.shop.book.repository.PriceRepository;


@Component
public class AuthorListener {

    @KafkaListener(topics = "author") //, groupId = "1")
    public void msgListener(String message){
        if (init) {
            init();
            init = false;
        }
        System.out.println("Received Message in group 1: " + message);
    }

    boolean init = true;

    @Autowired
    PriceRepository priceRepository;

    private void init() {
        Price price = new Price();
        price.setBookId(5);
        price.setPrice(100);

        Price price2 = new Price();
        price2.setBookId(6);
        price2.setPrice(200);

        priceRepository.save(price);
        priceRepository.save(price2);
    }
}
