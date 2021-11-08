package ru.storage.project.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import ru.storage.project.model.QAuthor;

public class ExpressionUtil {

    public static QAuthor getQAuthor() {
        return QAuthor.author;
    }

    public static BooleanExpression likeName(QAuthor author, String avtorName) {
        String pattern = String.format("%s%%",avtorName);
        return author.name.like(pattern);
    }
}
