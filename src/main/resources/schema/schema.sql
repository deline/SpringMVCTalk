CREATE TABLE Player(
id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
firstName VARCHAR(255) NOT NULL,
lastName VARCHAR(255) NOT NULL
);