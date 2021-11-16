package ru.storage.project.util;

import ru.storage.project.model.Book;

public class Generator {

    public static String get() {
        return String.format("%s%s%s", "AA-", String.format("%04d-", orgId), add());
    }

    static int add() {
        id = id+19;
        return id;
    }
    static int id = 10;
    static int orgId = 0;
}
