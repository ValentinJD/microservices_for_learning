package ru.storage.project.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Price {

    @Id
    int id;

    Integer price;

    private Integer bookId;
}
