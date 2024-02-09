package com.samsquad.fakitureapi.controller;

import com.samsquad.fakitureapi.entity.Bill;
import com.samsquad.fakitureapi.entity.BillLine;
import com.samsquad.fakitureapi.service.BillLineServices;
import com.samsquad.fakitureapi.service.BillServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/billLines")
public class BillLineController {
    private BillLineServices billLineServices;

    public BillLineController(BillLineServices billLineServices) {
        this.billLineServices = billLineServices;
    }

    @GetMapping("/")
    public List<BillLine> getAllBillLines() throws SQLException {
        return billLineServices.getAllBillLines();
    }
    @PostMapping("/all")
    public ResponseEntity<List<BillLine>> addAllBillLines(@RequestBody List<BillLine> billLines) throws SQLException {
        List<BillLine> savedBillLines = billLineServices.saveAllBillLines(billLines);
        return new ResponseEntity<>(savedBillLines, HttpStatus.CREATED);
    }
    @PostMapping("/")
    public ResponseEntity<BillLine> addBillLine(@RequestBody BillLine billLine) throws SQLException {
        BillLine savedBillLine = billLineServices.saveBillLine(billLine);
        return new ResponseEntity<>(savedBillLine, HttpStatus.CREATED);
    }
    @PutMapping("/{billLineNumber}")
    public ResponseEntity<Void> updateBillLine(@PathVariable int billLineNumber, @RequestBody BillLine billLineUpdate) throws SQLException {
        boolean updateSuccess = billLineServices.updateBillLine(billLineNumber, billLineUpdate);
        if (updateSuccess) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



