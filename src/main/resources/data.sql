INSERT INTO authors(FIO) VALUES ('Александр Сергеевич Пушкин');
INSERT INTO authors(FIO) VALUES ('Сергей Александрович Есенин');
INSERT INTO authors(FIO) VALUES ('Михаил Федорович Булгаков');
INSERT INTO authors(FIO) VALUES ('Лев Николаевич Толстой');
INSERT INTO authors(FIO) VALUES ('Михаил Юрьевич Лермонтов');

INSERT INTO genres(name) VALUES ('Сказка');
INSERT INTO genres(name) VALUES ('Роман');
INSERT INTO genres(name) VALUES ('Поэма');
INSERT INTO genres(name) VALUES ('Баллада');
INSERT INTO genres(name) VALUES ('Басня');
INSERT INTO genres(name) VALUES ('Былины');
INSERT INTO genres(name) VALUES ('Детектив');

INSERT INTO books(AUTHOR_ID, GENRE_ID, name) VALUES (1, 1, 'Сказка о попе и его работнике Балде');
INSERT INTO books(AUTHOR_ID, GENRE_ID, name) VALUES (4, 2, 'Война и мир');
INSERT INTO books(AUTHOR_ID, GENRE_ID, name) VALUES (1, 3, 'Евгений Онегин');
INSERT INTO books(AUTHOR_ID, GENRE_ID, name) VALUES (4, 2, 'Анна Каренина');