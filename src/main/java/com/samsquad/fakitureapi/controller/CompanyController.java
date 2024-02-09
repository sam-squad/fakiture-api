package com.samsquad.fakitureapi.controller;

import com.samsquad.fakitureapi.entity.Bill;
import com.samsquad.fakitureapi.entity.Company;
import com.samsquad.fakitureapi.service.BillServices;
import com.samsquad.fakitureapi.service.CompanyServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private CompanyServices companyServices;

    public CompanyController(CompanyServices companyServices) {
        this.companyServices = companyServices;
    }

    @GetMapping("/")
    public List<Company> getAllCompanies() throws SQLException {
        return companyServices.getAllCompanies();
    }
    @PostMapping("/all")
    public ResponseEntity<List<Company>> addAllCompanies(@RequestBody List<Company> companies) throws SQLException {
        List<Company> savedCompanies = companyServices.saveAllCompanies(companies);
        return new ResponseEntity<>(savedCompanies, HttpStatus.CREATED);
    }
    @PostMapping("/")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) throws SQLException {
        Company savedCompany = companyServices.saveCompany(company);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }
    @PutMapping("/{companyNumber}")
    public ResponseEntity<Void> updateCompany(@PathVariable int companyNumber, @RequestBody Company companyUpdate) throws SQLException {
        boolean updateSuccess = companyServices.updateCompany(companyNumber, companyUpdate);
        if (updateSuccess) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


