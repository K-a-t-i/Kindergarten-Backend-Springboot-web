CREATE TABLE IF NOT EXISTS customer
(
    course_id           SERIAL PRIMARY KEY,
    course_name         VARCHAR(255),
    course_description  TEXT
    );