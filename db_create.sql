CREATE DATABASE message_app;

\c message_app;


CREATE TABLE users (
    id_user SERIAL PRIMARY KEY,
    email VARCHAR(50) NOT NULL UNIQUE,
    password_user VARCHAR(32) NOT NULL,
    name_user VARCHAR(50) NOT NULL
);

CREATE TABLE messages (
    id_message SERIAL PRIMARY KEY,
    text_message VARCHAR(280),
    id_user INTEGER,
    date_message DATE    
);

ALTER TABLE messages RENAME COLUMN autor_message TO author_message;


INSERT INTO messages (text_message, author_message, date_message) VALUES (?, ?, ?);

INSERT INTO messages (text_message, author_message, date_message) 
VALUES ('This is my first message from java, whit other user', 'Pepe Parra', '2020/02/08');


CREATE USER usermessageapp WITH PASSWORD 'messagePlatzi';
ALTER ROLE usermessageapp LOGIN;
ALTER ROLE usermessageapp CREATEROLE;

ALTER TABLE public.messages
    OWNER TO usermessageapp;
    

GRANT all privileges ON DATABASE message_app TO usermessageapp;
REVOKE all privileges ON DATABASE message_app FROM usermessageapp;

ALTER TABLE public.messages
    ADD CONSTRAINT users_messages_id_user FOREIGN KEY (id_user)
    REFERENCES public.users (id_user) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE CASCADE
    NOT VALID;

