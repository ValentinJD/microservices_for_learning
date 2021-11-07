package ru.storage.project.service;

import org.springframework.data.domain.Sort;
import ru.storage.project.model.Author;
import ru.storage.project.model.Book;
import ru.storage.project.model.Book_;

public class SortingUtil {

    public static Sort getSortByBookId() {
        Sort sort = Sort.sort(Book.class).by(Book::getId);
        return sort;
    }

    public static Sort sortDescending(boolean asc, Sort sort) {
        return asc ? sort.ascending() : sort.descending();
    }

    public static Sort getSortByAuthorName() {
       return Sort.by("author.name");
    }

}
