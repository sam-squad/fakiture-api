package com.samsquad.fakitureapi.service;

import com.samsquad.fakitureapi.entity.Company;
import com.samsquad.fakitureapi.repository.CompanyCrudOperations;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CompanyServices {
    private final CompanyCrudOperations companyCrudOperations;

    public CompanyServices(CompanyCrudOperations companyCrudOperations) {
        this.companyCrudOperations = companyCrudOperations;
    }

    public List<Company> getAllCompanies() throws SQLException {
        return companyCrudOperations.findAll();
    }
    public Company saveCompany(Company company) throws SQLException {
        return companyCrudOperations.save(company);
    }
    public List<Company> saveAllCompanies(List<Company> companies) throws SQLException {
        return companyCrudOperations.saveAll(companies);
    }
    public boolean updateCompany(int companyNumber, Company company) throws SQLException {
        return companyCrudOperations.update(company);
    }
}

