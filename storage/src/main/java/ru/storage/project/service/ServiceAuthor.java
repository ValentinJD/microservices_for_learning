package ru.storage.project.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.storage.project.model.Author;
import ru.storage.project.model.QAuthor;
import ru.storage.project.repository.AuthorRepository;

import java.util.List;

@Service
public class ServiceAuthor {

    @Autowired
    AuthorRepository authorRepository;



    public Iterable<Author> getAuthor(BooleanExpression hasName) {
        return authorRepository.findAll(hasName);
    }
}
