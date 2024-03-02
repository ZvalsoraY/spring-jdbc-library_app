package ru.pvn.libraryApp.models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    //private List<LiteraryProduction> literaryProductions;

    private long id;

    private String name;

    //private String isbn;
    private Author author;
    private Genre genre;

/*    public Book(long id, String name*//*, String isbn*//*, Author author, Genre genre*//*, List<LiteraryProduction> literaryProductions*//*) {
        this.id = id;
        this.name = name;
        //this.isbn = isbn;
       // this.literaryProductions = literaryProductions;
        this.author = author;
        this.genre = genre;
    }*/


    @Override
    public String toString() {
        return "Book{" +
                "  id=" + id +
                ", name='" + name + '\'' +
                //", isbn='" + isbn + '\'' +
                //", literaryProductions=" + literaryProductions +
                ", author=" + author + '\'' +
                ", genre=" + genre +
                '}';
    }
}
