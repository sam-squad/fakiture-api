package com.samsquad.fakitureapi.entity;

public class BillLine {
    private int billLineNumber;
    private String productServiceDesignation;
    private int quantity;
    private String unit;
    private Double unitPrice;
    private String percentageVatLine;
    private Double VatCalculatedLine;
    private Double totalTtcCalculatedLine;
    private int billNumber;

    public BillLine(int billLineNumber, String productServiceDesignation, int quantity, String unit, Double unitPrice, String percentageVatLine, Double vatCalculatedLine, Double totalTtcCalculatedLine, int billNumber) {
        this.billLineNumber = billLineNumber;
        this.productServiceDesignation = productServiceDesignation;
        this.quantity = quantity;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.percentageVatLine = percentageVatLine;
        VatCalculatedLine = vatCalculatedLine;
        this.totalTtcCalculatedLine = totalTtcCalculatedLine;
        this.billNumber = billNumber;
    }

    public int getBillLineNumber() {
        return billLineNumber;
    }

    public void setBillLineNumber(int billLineNumber) {
        this.billLineNumber = billLineNumber;
    }

    public String getProductServiceDesignation() {
        return productServiceDesignation;
    }

    public void setProductServiceDesignation(String productServiceDesignation) {
        this.productServiceDesignation = productServiceDesignation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPercentageVatLine() {
        return percentageVatLine;
    }

    public void setPercentageVatLine(String percentageVatLine) {
        this.percentageVatLine = percentageVatLine;
    }

    public Double getVatCalculatedLine() {
        return VatCalculatedLine;
    }

    public void setVatCalculatedLine(Double vatCalculatedLine) {
        VatCalculatedLine = vatCalculatedLine;
    }

    public Double getTotalTtcCalculatedLine() {
        return totalTtcCalculatedLine;
    }

    public void setTotalTtcCalculatedLine(Double totalTtcCalculatedLine) {
        this.totalTtcCalculatedLine = totalTtcCalculatedLine;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    @Override
    public String toString() {
        return "BillLine{" +
                "billLineNumber=" + billLineNumber +
                ", productServiceDesignation='" + productServiceDesignation + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", unitPrice=" + unitPrice +
                ", percentageVatLine='" + percentageVatLine + '\'' +
                ", VatCalculatedLine=" + VatCalculatedLine +
                ", totalTtcCalculatedLine=" + totalTtcCalculatedLine +
                ", billNumber=" + billNumber +
                '}';
    }
}
