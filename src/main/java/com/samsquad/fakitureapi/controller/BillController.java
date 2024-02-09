package com.samsquad.fakitureapi.controller;

import com.samsquad.fakitureapi.entity.Bill;
import com.samsquad.fakitureapi.service.BillServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {
    private BillServices billServices;

    public BillController(BillServices billServices) {
        this.billServices = billServices;
    }

    @GetMapping("/")
    public List<Bill> getAllBills() throws SQLException {
        return billServices.getAllBills();
    }
    @PostMapping("/all")
    public ResponseEntity<List<Bill>> addAllBills(@RequestBody List<Bill> bills) throws SQLException {
        List<Bill> savedBills = billServices.saveAllBills(bills);
        return new ResponseEntity<>(savedBills, HttpStatus.CREATED);
    }
    @PostMapping("/")
    public ResponseEntity<Bill> addBill(@RequestBody Bill bill) throws SQLException {
        Bill savedBill = billServices.saveBill(bill);
        return new ResponseEntity<>(savedBill, HttpStatus.CREATED);
    }
    @PutMapping("/{billNumber}")
    public ResponseEntity<Void> updateBill(@PathVariable int billNumber, @RequestBody Bill billUpdate) throws SQLException {
        boolean updateSuccess = billServices.updateBill(billNumber, billUpdate);
        if (updateSuccess) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

