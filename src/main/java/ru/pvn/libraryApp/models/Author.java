package ru.pvn.libraryApp.models;


import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {

    private long id;

    private String fio;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                '}';
    }

    public Author(String fio) {
        this.fio = fio;
    }

}
