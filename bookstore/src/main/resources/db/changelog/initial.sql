CREATE TABLE IF NOT EXISTS customer
(
    id              SERIAL PRIMARY KEY,
    first_name      VARCHAR(50),
    last_name       VARCHAR(50),
    email           VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS book (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    isbn_13 VARCHAR(13) NOT NULL,
    language_id INT NOT NULL,
    number_pages INT NOT NULL,
    publication_date DATE NOT NULL,
    publisher_id INT NOT NULL
    );
