CREATE TABLE client (
    clientNumber Serial PRIMARY KEY,
    companyNameClient VARCHAR(255),
    clientAddress VARCHAR(255),
    clientPostalCode VARCHAR(10),
    clientCountry VARCHAR(255)
);