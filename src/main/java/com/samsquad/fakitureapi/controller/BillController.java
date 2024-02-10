package com.samsquad.fakitureapi.controller;

import com.samsquad.fakitureapi.entity.Bill;
import com.samsquad.fakitureapi.entity.BillLine;
import com.samsquad.fakitureapi.service.BillServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BillController {
    private BillServices billServices;

    public BillController(BillServices billServices) {
        this.billServices = billServices;
    }

    @GetMapping("/bills")
    public List<Bill> getAllBills() throws SQLException {
        int pageSize = 10;
        return billServices.getAllBills();
    }
    @GetMapping("/bill/{billNumber}")
    public ResponseEntity<Bill> getBillByNumber(@PathVariable int billNumber) throws SQLException {
        Bill bill = billServices.getBillByNumber(billNumber);
        if (bill != null) {
            return new ResponseEntity<>(bill, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/Bill")
    public ResponseEntity<Bill> addBill(@RequestBody Bill bill) throws SQLException {
        Bill savedBill = billServices.saveBill(bill);
        return new ResponseEntity<>(savedBill, HttpStatus.CREATED);
    }
    @PutMapping("/bill/{billNumber}")
    public ResponseEntity<Void> updateBill(@PathVariable int billNumber, @RequestBody Bill billUpdate) throws SQLException {
        boolean updateSuccess = billServices.updateBill(billNumber, billUpdate);
        if (updateSuccess) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

