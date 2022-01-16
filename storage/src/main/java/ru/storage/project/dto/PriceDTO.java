package ru.storage.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Schema(description = "Информация о цене")
@Data
public class PriceDTO {
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(value = "Цена в рублях")
    private int price;

    private Long bookId;
}
