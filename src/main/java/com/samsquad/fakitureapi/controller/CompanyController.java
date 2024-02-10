package com.samsquad.fakitureapi.controller;


import com.samsquad.fakitureapi.entity.Client;
import com.samsquad.fakitureapi.entity.Company;
import com.samsquad.fakitureapi.service.CompanyServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {
    private CompanyServices companyServices;

    public CompanyController(CompanyServices companyServices) {
        this.companyServices = companyServices;
    }

    @GetMapping("/companies")
    public List<Company> getAllCompanies() throws SQLException {
        return companyServices.getAllCompanies();
    }
    @GetMapping("/company/{companyNumber}")
    public ResponseEntity<Company> getCompanyByNumber(@PathVariable int companyNumber) throws SQLException {
        Company company = companyServices.getCompanyByNumber(companyNumber);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/company")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) throws SQLException {
        Company savedCompany = companyServices.saveCompany(company);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }
    @PutMapping("/company/{companyNumber}")
    public ResponseEntity<Void> updateCompany(@PathVariable int companyNumber, @RequestBody Company companyUpdate) throws SQLException {
        boolean updateSuccess = companyServices.updateCompany(companyNumber, companyUpdate);
        if (updateSuccess) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


