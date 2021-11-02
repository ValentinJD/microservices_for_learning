package ru.entitytgraph.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String nameBook;

    @ManyToOne
    private Author author;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    List<Sheet> sheet;
}
