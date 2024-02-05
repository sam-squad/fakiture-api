CREATE TABLE bill (
      billNumber Serial PRIMARY KEY,
      billType  VARCHAR(30) NOT NULL,
      billDate Timestamp,
      saleServiceDateBill Timestamp,
      paymentDate Timestamp,
      paymentModalityDaysBill VARCHAR(100),
      paymentMethod VARCHAR(255),
      paymentIssuedBy VARCHAR(255),
      totalTtcFixed DOUBLE PRECISION,
      userNumber SERIAL,
      clientNumber SERIAL,
      companyNumber SERIAL,
      FOREIGN KEY (userNumber) REFERENCES "user"(userNumber),
      FOREIGN KEY (clientNumber) REFERENCES client(clientNumber),
      FOREIGN KEY (companyNumber) REFERENCES company(companyNumber)
);