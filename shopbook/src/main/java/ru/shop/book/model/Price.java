package ru.shop.book.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Price {

    @Id
    @GeneratedValue
    private Long id;

    private int price;


    private Integer bookId;

}
