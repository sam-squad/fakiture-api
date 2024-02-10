package com.samsquad.fakitureapi.repository;

import com.samsquad.fakitureapi.db.ConnectDB;
import com.samsquad.fakitureapi.entity.Bill;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BillCrudOperations implements CrudOperations<Bill> {
    private final ConnectDB db = ConnectDB.getInstance();
    private Connection connection = db.getConnection();

    @Override
    public List<Bill> findAll() {
        List<Bill> billList = new ArrayList<>();
        String sql = "SELECT * FROM bill ORDER BY billDate";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Bill bill = new Bill(
                        resultSet.getInt("billNumber"),
                        resultSet.getString("billType"),
                        resultSet.getTimestamp("billDate"),
                        resultSet.getTimestamp("saleServiceDateBill"),
                        resultSet.getTimestamp("paymentDate"),
                        resultSet.getString("paymentModalityDaysBill"),
                        resultSet.getString("paymentMethod"),
                        resultSet.getString("paymentIssuedBy"),
                        resultSet.getDouble("totalTtcFixed"),
                        resultSet.getInt("userNumber"),
                        resultSet.getInt("clientNumber"),
                        resultSet.getInt("companyNumber")
                );
                billList.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }
    @Override
    public List<Bill> saveAll(List<Bill> toSave) {
        String insertQuery = "INSERT INTO bill (billNumber,billType, billDate, saleServiceDateBill, paymentDate, paymentModalityDaysBill, paymentMethod, paymentIssuedBy, totalTtcFixed, userNumber, clientNumber, companyNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            for (Bill bill : toSave) {
                insertStatement.setInt(1, bill.getBillNumber());
                insertStatement.setString(2, bill.getBillType());
                insertStatement.setTimestamp(3, bill.getBillDate());
                insertStatement.setTimestamp(4, bill.getSaleServiceDateBill());
                insertStatement.setTimestamp(5, bill.getPaymentDate());
                insertStatement.setString(6, bill.getPaymentModalityDaysBill());
                insertStatement.setString(7, bill.getPaymentMethod());
                insertStatement.setString(8, bill.getPaymentIssuedBy());
                insertStatement.setDouble(9, bill.getTotalTtcFixed());
                insertStatement.setInt(10, bill.getUserNumber());
                insertStatement.setInt(11, bill.getClientNumber());
                insertStatement.setInt(12, bill.getCompanyNumber());
                insertStatement.addBatch();
            }
            int[] rowsAffected = insertStatement.executeBatch();
            ResultSet generatedKeys = insertStatement.getGeneratedKeys();
            int i = 0;
            while (generatedKeys.next()) {
                toSave.get(i).setBillNumber(generatedKeys.getInt(1));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Bill save(Bill toSave) {
        String insertQuery = "INSERT INTO bill (billType, billDate, saleServiceDateBill, paymentDate, paymentModalityDaysBill, paymentMethod, paymentIssuedBy, totalTtcFixed, userNumber, clientNumber, companyNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            insertStatement.setString(1, toSave.getBillType());
            insertStatement.setTimestamp(2, toSave.getBillDate());
            insertStatement.setTimestamp(3, toSave.getSaleServiceDateBill());
            insertStatement.setTimestamp(4, toSave.getPaymentDate());
            insertStatement.setString(5, toSave.getPaymentModalityDaysBill());
            insertStatement.setString(6, toSave.getPaymentMethod());
            insertStatement.setString(7, toSave.getPaymentIssuedBy());
            insertStatement.setDouble(8, toSave.getTotalTtcFixed());
            insertStatement.setInt(9, toSave.getUserNumber());
            insertStatement.setInt(10, toSave.getClientNumber());
            insertStatement.setInt(11, toSave.getCompanyNumber());

            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = insertStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    toSave.setBillNumber(generatedKeys.getInt(1));
                    return toSave;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Bill toSave) {
        String updateQuery = "UPDATE bill SET billType=?, billDate=?, saleServiceDateBill=?, " +
                "paymentDate=?, paymentModalityDaysBill=?, paymentMethod=?, " +
                "paymentIssuedBy=?, totalTtcFixed=?, userNumber=?, clientNumber=?, " +
                "companyNumber=? WHERE billNumber=?";

        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, toSave.getBillType());
            updateStatement.setTimestamp(2, toSave.getBillDate());
            updateStatement.setTimestamp(3, toSave.getSaleServiceDateBill());
            updateStatement.setTimestamp(4, toSave.getPaymentDate());
            updateStatement.setTimestamp(5, Timestamp.valueOf(toSave.getPaymentModalityDaysBill()));
            updateStatement.setString(6, toSave.getPaymentMethod());
            updateStatement.setString(7, toSave.getPaymentIssuedBy());
            updateStatement.setDouble(8, toSave.getTotalTtcFixed());
            updateStatement.setInt(9, toSave.getUserNumber());
            updateStatement.setInt(10, toSave.getClientNumber());
            updateStatement.setInt(11, toSave.getCompanyNumber());
            updateStatement.setInt(12, toSave.getBillNumber());

            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Bill getBillByNumber(int billNumber) {
        String sql = "SELECT * FROM bill WHERE billNumber=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, billNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Bill(
                        resultSet.getInt("billNumber"),
                        resultSet.getString("billType"),
                        resultSet.getTimestamp("billDate"),
                        resultSet.getTimestamp("saleServiceDateBill"),
                        resultSet.getTimestamp("paymentDate"),
                        resultSet.getString("paymentModalityDaysBill"),
                        resultSet.getString("paymentMethod"),
                        resultSet.getString("paymentIssuedBy"),
                        resultSet.getDouble("totalTtcFixed"),
                        resultSet.getInt("userNumber"),
                        resultSet.getInt("clientNumber"),
                        resultSet.getInt("companyNumber")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
