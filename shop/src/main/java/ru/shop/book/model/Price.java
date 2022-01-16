package ru.shop.book.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ApiModel(description = "Информация о книге")
public class Price {

    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(value = "Цена в рублях")
    private int price;

    private Integer bookId;

}
