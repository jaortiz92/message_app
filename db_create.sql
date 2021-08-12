CREATE DATABASE message_app;

\c message_app;

CREATE TABLE messages (
    id_message SERIAL PRIMARY KEY,
    text_message VARCHAR(280),
    author_message VARCHAR(50),
    date_message DATE    
);

ALTER TABLE messages RENAME COLUMN autor_message TO author_message;


INSERT INTO messages (text_message, author_message, date_message) VALUES (?, ?, ?);