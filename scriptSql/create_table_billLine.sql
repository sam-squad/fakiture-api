CREATE TABLE billLine (
      billLineNumber SERIAL PRIMARY KEY,
      productServiceDesignation VARCHAR(255) NOT NULL,
      quantity INT NOT NULL,
      unit VARCHAR(20) NOT NULL,
      unitPrice DOUBLE PRECISION NOT NULL,
      percentageVatLine VARCHAR(100) NOT NULL,
      VatCalculatedLine DOUBLE PRECISION NOT NULL,
      totalTtcCalculatedLine DOUBLE PRECISION NOT NULL,
      billNumber SERIAL NOT NULL,
      FOREIGN KEY (billNumber) REFERENCES bill(billNumber)
);