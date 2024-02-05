CREATE TABLE company (
     companyNumber Serial PRIMARY KEY,
     companyName VARCHAR(255),
     companyAddress VARCHAR(255),
     companyPostalCode VARCHAR(10),
     companyContact VARCHAR(255)
);