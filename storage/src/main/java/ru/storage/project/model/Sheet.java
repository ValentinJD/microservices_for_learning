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
@Table(name = "sheet")
public class Sheet {

    @Id
    @GeneratedValue
    Integer id;


    String content;

    @ManyToOne
    Book book;
}
