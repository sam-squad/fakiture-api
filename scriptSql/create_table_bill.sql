CREATE TABLE bill (
      billNumber SERIAL PRIMARY KEY,
      billType  VARCHAR(30) NOT NULL,
      billDate TIMESTAMP NOT NULL,
      saleServiceDateBill TIMESTAMP NOT NULL,
      paymentDate TIMESTAMP NOT NULL,
      paymentModalityDaysBill VARCHAR(100) NOT NULL,
      paymentMethod VARCHAR(255) NOT NULL,
      paymentIssuedBy VARCHAR(255) NOT NULL,
      totalTtcFixed DOUBLE PRECISION NOT NULL,
      userNumber SERIAL NOT NULL,
      clientNumber SERIAL NOT NULL,
      companyNumber SERIAL NOT NULL,
      FOREIGN KEY (userNumber) REFERENCES "user"(userNumber),
      FOREIGN KEY (clientNumber) REFERENCES client(clientNumber),
      FOREIGN KEY (companyNumber) REFERENCES company(companyNumber)
);