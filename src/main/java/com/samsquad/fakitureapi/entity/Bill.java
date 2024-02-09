package com.samsquad.fakitureapi.entity;

import java.sql.Timestamp;

public class Bill {
    private int billNumber;
    private String billType;
    private Timestamp billDate;
    private Timestamp saleServiceDateBill;
    private Timestamp paymentDate;
    private String paymentModalityDaysBill;
    private String paymentMethod;
    private String paymentIssuedBy;
    private Double totalTtcFixed;
    private int userNumber;
    private int clientNumber;
    private int companyNumber;

    public Bill(int billNumber, String billType, Timestamp billDate, Timestamp saleServiceDateBill, Timestamp paymentDate, String paymentModalityDaysBill, String paymentMethod, String paymentIssuedBy, Double totalTtcFixed, int userNumber, int clientNumber, int companyNumber) {
        this.billNumber = billNumber;
        this.billType = billType;
        this.billDate = billDate;
        this.saleServiceDateBill = saleServiceDateBill;
        this.paymentDate = paymentDate;
        this.paymentModalityDaysBill = paymentModalityDaysBill;
        this.paymentMethod = paymentMethod;
        this.paymentIssuedBy = paymentIssuedBy;
        this.totalTtcFixed = totalTtcFixed;
        this.userNumber = userNumber;
        this.clientNumber = clientNumber;
        this.companyNumber = companyNumber;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public Timestamp getBillDate() {
        return billDate;
    }

    public void setBillDate(Timestamp billDate) {
        this.billDate = billDate;
    }

    public Timestamp getSaleServiceDateBill() {
        return saleServiceDateBill;
    }

    public void setSaleServiceDateBill(Timestamp saleServiceDateBill) {
        this.saleServiceDateBill = saleServiceDateBill;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentModalityDaysBill() {
        return paymentModalityDaysBill;
    }

    public void setPaymentModalityDaysBill(String paymentModalityDaysBill) {
        this.paymentModalityDaysBill = paymentModalityDaysBill;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentIssuedBy() {
        return paymentIssuedBy;
    }

    public void setPaymentIssuedBy(String paymentIssuedBy) {
        this.paymentIssuedBy = paymentIssuedBy;
    }

    public Double getTotalTtcFixed() {
        return totalTtcFixed;
    }

    public void setTotalTtcFixed(Double totalTtcFixed) {
        this.totalTtcFixed = totalTtcFixed;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billNumber=" + billNumber +
                ", billType='" + billType + '\'' +
                ", billDate=" + billDate +
                ", saleServiceDateBill=" + saleServiceDateBill +
                ", paymentDate=" + paymentDate +
                ", paymentModalityDaysBill=" + paymentModalityDaysBill +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentIssuedBy='" + paymentIssuedBy + '\'' +
                ", totalTtcFixed=" + totalTtcFixed +
                ", userNumber=" + userNumber +
                ", clientNumber=" + clientNumber +
                ", companyNumber=" + companyNumber +
                '}';
    }
}
