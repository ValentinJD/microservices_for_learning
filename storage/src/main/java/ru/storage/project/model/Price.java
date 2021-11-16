package ru.storage.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Price {

    @Id
    @GeneratedValue
    int id;

    Integer price;

    @OneToOne
    Book book;
}
