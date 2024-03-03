package ru.pvn.libraryApp.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import ru.pvn.libraryApp.models.Author;
import ru.pvn.libraryApp.models.Book;
import ru.pvn.libraryApp.models.Genre;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbc;


    private final String  selectBooks = "SELECT bks.id book_id,\n" +
            "                       bks.name book_name, \n" +
            "                       gnrs.id genre_id, \n" +
            "                       gnrs.name genre_name,\n" +
            "                       aut.id author_id,\n" +
            "                       aut.fio author_fio,\n" +
            "        FROM BOOKS bks\n" +
            "        JOIN AUTHORS aut ON aut.id = bks.author_id\n" +
            "        JOIN GENRES gnrs ON gnrs.id = bks.genre_id\n";

    public BookDaoJdbc(NamedParameterJdbcOperations jdbc, GenreDaoJdbc genreJdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Book getById(long id) {
        final Map<String,Object> params = new HashMap<>(1);
        params.put("id", id);
        return jdbc.query( selectBooks +
                        "WHERE bks.id = :id",
                Map.of("id", id),
                new BookExtractor());
    }

    @Override
    public void create(Book book) {
        jdbc.update("insert into books (" +
                        " NAME,\n" +
                        " AUTHOR_ID,\n" +
                        " GENRE_ID\n" +
                        ")" +
                        "   values ( " +
                        " :name,\n" +
                        " :authorId,\n" +
                        " :genreId\n" +
                        ")",
                Map.of( "name", book.getName(),
                        "authorId", book.getAuthor().getId(),
                        "genreId", book.getGenre().getId()));
    }

    @Override
    public void update(Book book) {
            jdbc.update("update books  SET" +
                            " NAME = :name,\n" +
                            " AUTHOR_ID = :authorId,\n" +
                            " GENRE_ID = :genreId\n" +
                            " WHERE ID = :id",
                    Map.of("id", book.getId(),
                            "name", book.getName(),
                            "authorId", book.getAuthor().getId(),
                            "genreId", book.getGenre().getId() ));
        }



    @Override
    public void deleteById(long id) {
        jdbc.update("DELETE FROM books WHERE id = :id", Map.of("id", id));
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query(selectBooks+
                " ORDER BY book_id", new BooksExtractor());
    }


    private class BookExtractor implements ResultSetExtractor<Book> {
        @Override
        public Book extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<Book> books = new BooksExtractor().extractData(resultSet);
            if (books.isEmpty()) return null;
                else return books.iterator().next();
        }
    }

    private class BooksExtractor implements ResultSetExtractor<List<Book>> {
        @Override
        public List<Book> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            Map<Long, Book> books = new HashMap<>();
            while (resultSet.next()) {
                Book book = books.get(resultSet.getLong("id"));
                if (book == null) {
                    book = new Book(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            new Author(resultSet.getLong("author_id"), resultSet.getString("author_fio")),
                            new Genre(resultSet.getLong("genre_id"), resultSet.getString("genre_name"))
                            );
                    books.put(resultSet.getLong("id"), book);
                }

            }
            return new ArrayList<>(books.values());
        }
    }
}

