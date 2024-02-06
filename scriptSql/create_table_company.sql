CREATE TABLE company (
     companyNumber SERIAL PRIMARY KEY,
     companyName VARCHAR(255) NOT NULL,
     companyAddress VARCHAR(255) NOT NULL,
     companyPostalCode VARCHAR(10) NOT NULL,
     companyContact VARCHAR(255) NOT NULL
);