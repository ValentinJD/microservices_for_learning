package ru.storage.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Параметры", description = "Параметры запроса")
public class SearchDTO {

    @Schema(description = "Имя книги")
    private String nameBook;
    @Schema(description = "Ф.И.О. автора книги")
    private String authorName;

    @Schema(description = "Направление сортировки")
    @Builder.Default
    private boolean asc = true;

    @Schema(description = "Номер страницы")
    @Builder.Default
    private int page = 0;

    @Schema(description = "Количество строк")
    @Builder.Default
    private int size = 10;
}
