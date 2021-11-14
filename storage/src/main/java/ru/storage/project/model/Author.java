package ru.storage.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> book;

/*    @Override
    public int compareTo(Object o) {
        return name.compareTo(((Author)o).getName());
    }*/
}
