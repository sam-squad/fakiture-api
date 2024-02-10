package com.samsquad.fakitureapi.entity;

public class Client {
    private int clientNumber;
    private String companyNameClient;
    private String clientAddress;
    private String clientPostalCode;
    private String clientCountry;

    public Client(int clientNumber, String companyNameClient, String clientAddress, String clientPostalCode, String clientCountry) {
        this.clientNumber = clientNumber;
        this.companyNameClient = companyNameClient;
        this.clientAddress = clientAddress;
        this.clientPostalCode = clientPostalCode;
        this.clientCountry = clientCountry;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getCompanyNameClient() {
        return companyNameClient;
    }

    public void setCompanyNameClient(String companyNameClient) {
        this.companyNameClient = companyNameClient;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientPostalCode() {
        return clientPostalCode;
    }

    public void setClientPostalCode(String clientPostalCode) {
        this.clientPostalCode = clientPostalCode;
    }

    public String getClientCountry() {
        return clientCountry;
    }

    public void setClientCountry(String clientCountry) {
        this.clientCountry = clientCountry;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientNumber=" + clientNumber +
                ", companyNameClient='" + companyNameClient + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientPostalCode='" + clientPostalCode + '\'' +
                ", clientCountry='" + clientCountry + '\'' +
                '}';
    }
}
