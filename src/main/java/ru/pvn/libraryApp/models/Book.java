package ru.pvn.libraryApp.models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    private long id;

    private String name;

    private Author author;
    private Genre genre;

    @Override
    public String toString() {
        return "Book{" +
                "  id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author + '\'' +
                ", genre=" + genre +
                '}';
    }
}
