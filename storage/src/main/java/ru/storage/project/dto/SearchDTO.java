package ru.storage.project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchDTO {

    private String nameBook;

    private String authorName;

    private boolean asc;

    private int page;

    private int size;
}
