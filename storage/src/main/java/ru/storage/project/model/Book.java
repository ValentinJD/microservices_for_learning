package ru.storage.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

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

    // Поле для корректной сортировки по humanReadableId
    @Formula(value = "substring(human_readable_id from '[A-ZА-Я]{2,20}-[0-9]{4,199}-') || " +
            " to_char(cast(substring(human_readable_id from '-[0-9]{1,199}$') as int4), 'fm000000000000')")
    private String forSortingByHumanReadableId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Sheet> sheets;

    @OneToOne(cascade = CascadeType.ALL)
    Price price;
}
