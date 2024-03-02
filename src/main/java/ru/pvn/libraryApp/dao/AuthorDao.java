package ru.pvn.libraryApp.dao;

import ru.pvn.libraryApp.models.Author;

public interface AuthorDao {
    Author getById(long id);
    Author getByFio(String name);
    void create(Author author);
}
