package ru.storage.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO {

    private String nameBook;

    private String authorName;

    @Builder.Default
    private boolean asc = true;

    @Builder.Default
    private int page = 0;

    @Builder.Default
    private int size = 10;
}
