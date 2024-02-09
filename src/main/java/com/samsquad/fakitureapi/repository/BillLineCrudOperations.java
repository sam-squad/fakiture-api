package com.samsquad.fakitureapi.repository;

import com.samsquad.fakitureapi.db.ConnectDB;
import com.samsquad.fakitureapi.entity.BillLine;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BillLineCrudOperations implements CrudOperations<BillLine> {
    private final ConnectDB db = ConnectDB.getInstance();
    private Connection connection = db.getConnection();

    @Override
    public List<BillLine> findAll() {
        List<BillLine> billLineList = new ArrayList<>();
        String sql = "SELECT * FROM bill_line";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                BillLine billLine = new BillLine(
                        resultSet.getInt("billLineNumber"),
                        resultSet.getString("productServiceDesignation"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("unit"),
                        resultSet.getDouble("unitPrice"),
                        resultSet.getString("percentageVatLine"),
                        resultSet.getDouble("VatCalculatedLine"),
                        resultSet.getDouble("totalTtcCalculatedLine"),
                        resultSet.getInt("billNumber")
                );
                billLineList.add(billLine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billLineList;
    }

    @Override
    public List<BillLine> saveAll(List<BillLine> toSave) {
        String insertQuery = "INSERT INTO bill_line (billLineNumber, productServiceDesignation, quantity, unit, unitPrice, percentageVatLine, VatCalculatedLine, totalTtcCalculatedLine, billNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            for (BillLine billLine : toSave) {
                insertStatement.setInt(1, billLine.getBillLineNumber());
                insertStatement.setString(2, billLine.getProductServiceDesignation());
                insertStatement.setInt(3, billLine.getQuantity());
                insertStatement.setString(4, billLine.getUnit());
                insertStatement.setDouble(5, billLine.getUnitPrice());
                insertStatement.setString(6, billLine.getPercentageVatLine());
                insertStatement.setDouble(7, billLine.getVatCalculatedLine());
                insertStatement.setDouble(8, billLine.getTotalTtcCalculatedLine());
                insertStatement.setInt(9, billLine.getBillNumber());
                insertStatement.addBatch();
            }
            int[] rowsAffected = insertStatement.executeBatch();
            ResultSet generatedKeys = insertStatement.getGeneratedKeys();
            int i = 0;
            while (generatedKeys.next()) {
                toSave.get(i).setBillLineNumber(generatedKeys.getInt(1));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public BillLine save(BillLine toSave) {
        String insertQuery = "INSERT INTO bill_line (productServiceDesignation, quantity, unit, unitPrice, percentageVatLine, VatCalculatedLine, totalTtcCalculatedLine, billNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            insertStatement.setString(1, toSave.getProductServiceDesignation());
            insertStatement.setInt(2, toSave.getQuantity());
            insertStatement.setString(3, toSave.getUnit());
            insertStatement.setDouble(4, toSave.getUnitPrice());
            insertStatement.setString(5, toSave.getPercentageVatLine());
            insertStatement.setDouble(6, toSave.getVatCalculatedLine());
            insertStatement.setDouble(7, toSave.getTotalTtcCalculatedLine());
            insertStatement.setInt(8, toSave.getBillNumber());

            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = insertStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    toSave.setBillLineNumber(generatedKeys.getInt(1));
                    return toSave;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(BillLine toSave) {
        String updateQuery = "UPDATE billLine SET productServiceDesignation=?, quantity=?, unit=?, " +
                "unitPrice=?, percentageVatLine=?, VatCalculatedLine=?, totalTtcCalculatedLine=?, " +
                "billNumber=? WHERE billLineNumber=?";

        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, toSave.getProductServiceDesignation());
            updateStatement.setInt(2, toSave.getQuantity());
            updateStatement.setString(3, toSave.getUnit());
            updateStatement.setDouble(4, toSave.getUnitPrice());
            updateStatement.setString(5, toSave.getPercentageVatLine());
            updateStatement.setDouble(6, toSave.getVatCalculatedLine());
            updateStatement.setDouble(7, toSave.getTotalTtcCalculatedLine());
            updateStatement.setInt(8, toSave.getBillNumber());
            updateStatement.setInt(9, toSave.getBillLineNumber());

            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
