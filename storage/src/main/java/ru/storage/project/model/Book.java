package ru.storage.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String nameBook;

    private String humanReadableId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Sheet> sheets;
}
