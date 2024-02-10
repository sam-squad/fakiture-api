package com.samsquad.fakitureapi.entity;

public class Company {
    private int companyNumber;
    private String companyName;
    private String companyAddresse;
    private String companyCodePostal;
    private String companyContact;

    public Company(int companyNumber, String companyName, String companyAddresse, String companyCodePostal, String companyContact) {
        this.companyNumber = companyNumber;
        this.companyName = companyName;
        this.companyAddresse = companyAddresse;
        this.companyCodePostal = companyCodePostal;
        this.companyContact = companyContact;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddresse() {
        return companyAddresse;
    }

    public void setCompanyAddresse(String companyAddresse) {
        this.companyAddresse = companyAddresse;
    }

    public String getCompanyCodePostal() {
        return companyCodePostal;
    }

    public void setCompanyCodePostal(String companyCodePostal) {
        this.companyCodePostal = companyCodePostal;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyNumber=" + companyNumber +
                ", companyName='" + companyName + '\'' +
                ", companyAddresse='" + companyAddresse + '\'' +
                ", companyCodePostal='" + companyCodePostal + '\'' +
                ", companyContact='" + companyContact + '\'' +
                '}';
    }
}
