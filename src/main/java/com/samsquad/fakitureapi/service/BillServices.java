package com.samsquad.fakitureapi.service;

import com.samsquad.fakitureapi.entity.Bill;
import com.samsquad.fakitureapi.repository.BillCrudOperations;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BillServices {
    private final BillCrudOperations billCrudOperations;

    public BillServices(BillCrudOperations billCrudOperations) {
        this.billCrudOperations = billCrudOperations;
    }
    public List<Bill> getAllBills()throws SQLException {
        return billCrudOperations.findAll();
    }
    public Bill saveBill(Bill bill)throws SQLException {
        return billCrudOperations.save(bill);
    }
    public List<Bill> saveAllBills(List<Bill> bills)throws SQLException {
        return billCrudOperations.saveAll(bills);
    }
    public boolean updateBill(int billNumber, Bill bill) throws SQLException {
        return billCrudOperations.update(bill);
    }
    public Bill getBillByNumber(int billNumber) {
        return billCrudOperations.getBillByNumber(billNumber);
    }
}

