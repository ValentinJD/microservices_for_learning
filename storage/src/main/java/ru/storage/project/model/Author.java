package ru.storage.project.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@Table(name = "author")
@ApiModel(value = "Информация об авторе")
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(value = "Ф.И.О. автора", example = "Пушкин А.С.")
    private String name;

    @ApiModelProperty(value = "Список книг")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> book;
}
