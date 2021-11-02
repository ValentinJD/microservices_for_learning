package ru.entitytgraph.project.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "sheet")
public class Sheet {

    @Id
    @GeneratedValue
    Integer id;


    String content;

    @ManyToOne
    Book book;
}
