package com.samsquad.fakitureapi.service;

import com.samsquad.fakitureapi.entity.BillLine;
import com.samsquad.fakitureapi.repository.BillLineCrudOperations;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class BillLineServices {
    private final BillLineCrudOperations billLineCrudOperations;
    public BillLineServices(BillLineCrudOperations billLineCrudOperations) {
        this.billLineCrudOperations = billLineCrudOperations;
    }
    public List<BillLine> getAllBillLines() throws SQLException {
        return billLineCrudOperations.findAll();
    }
    public BillLine saveBillLine(BillLine billLine) throws SQLException {
        return billLineCrudOperations.save(billLine);
    }
    public List<BillLine> saveAllBillLines(List<BillLine> billLines) throws SQLException {
        return billLineCrudOperations.saveAll(billLines);
    }
    public boolean updateBillLine(int billLineNumber, BillLine billLine) throws SQLException {
        return billLineCrudOperations.update(billLine);
    }

}

