CREATE TABLE client (
    clientNumber SERIAL PRIMARY KEY,
    companyNameClient VARCHAR(255) NOT NULL,
    clientAddress VARCHAR(255) NOT NULL,
    clientPostalCode VARCHAR(10) NOT NULL,
    clientCountry VARCHAR(255) NOT NULL
);