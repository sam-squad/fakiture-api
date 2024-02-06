CREATE TABLE "user" (
    userNumber SERIAL PRIMARY KEY,
    userName VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);