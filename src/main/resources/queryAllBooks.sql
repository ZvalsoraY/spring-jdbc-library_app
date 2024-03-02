SELECT bks.id book_id,
            bks.name book_name,
            gnrs.id genre_id,
            gnrs.name genre_name,
            aut.id author_id,
            aut.fio author_fio,
            FROM BOOKS bks
            JOIN AUTHORS aut ON aut.id = bks.author_id
            JOIN GENRES gnrs ON gnrs.id = bks.genre_id;

DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS(
    ID BIGSERIAL NOT NULL PRIMARY KEY,
    FIO VARCHAR(255)
);

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES (
  ID BIGSERIAL NOT NULL PRIMARY KEY,
  NAME VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS(
     ID BIGSERIAL NOT NULL PRIMARY KEY,
	 AUTHOR_ID BIGINT,
     GENRE_ID BIGINT,
     NAME VARCHAR(255)
     );