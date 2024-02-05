CREATE TABLE billLine (
      billLineNumber Serial PRIMARY KEY,
      productServiceDesignation VARCHAR(255),
      quantity INT,
      unit VARCHAR(20),
      unitPrice DOUBLE PRECISION,
      percentageVatLine VARCHAR(100),
      VatCalculatedLine DOUBLE PRECISION,
      totalTtcCalculatedLine DOUBLE PRECISION,
      billNumber SERIAL,
      FOREIGN KEY (billNumber) REFERENCES bill(billNumber)
);