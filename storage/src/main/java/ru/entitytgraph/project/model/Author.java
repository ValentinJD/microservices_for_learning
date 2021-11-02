package ru.entitytgraph.project.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/*
@NamedEntityGraph(name = "with-books-and-sheets",
        attributeNodes = {
                @NamedAttributeNode(value = "book")
        }*//*,
        subgraphs = {
                @NamedSubgraph(name = "graph.sheet",
                        attributeNodes = {
                                @NamedAttributeNode("sheet")
                        }
                )
        }*//*

)*/

/*@NamedEntityGraph(name = "Author.books",
        attributeNodes = {
                @NamedAttributeNode(value = "book")
        })*/


@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @OneToMany(fetch = FetchType.EAGER)
    private List<Book> book;
}
