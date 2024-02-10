package com.samsquad.fakitureapi.repository;

import com.samsquad.fakitureapi.db.ConnectDB;
import com.samsquad.fakitureapi.entity.Company;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CompanyCrudOperations implements CrudOperations<Company> {
    private final ConnectDB db = ConnectDB.getInstance();
    private Connection connection = db.getConnection();

    @Override
    public List<Company> findAll() {
        List<Company> companyList = new ArrayList<>();
        String sql = "SELECT * FROM company ORDER BY companyName";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Company company = new Company(
                        resultSet.getInt("companyNumber"),
                        resultSet.getString("companyName"),
                        resultSet.getString("companyAddresse"),
                        resultSet.getString("companyCodePostal"),
                        resultSet.getString("companyContact")
                );
                companyList.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyList;
    }

    @Override
    public List<Company> saveAll(List<Company> toSave) {
        String insertQuery = "INSERT INTO company (companyNumber, companyName, companyAddresse, companyCodePostal, companyContact) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            for (Company company : toSave) {
                insertStatement.setInt(1, company.getCompanyNumber());
                insertStatement.setString(2, company.getCompanyName());
                insertStatement.setString(3, company.getCompanyAddresse());
                insertStatement.setString(4, company.getCompanyCodePostal());
                insertStatement.setString(5, company.getCompanyContact());
                insertStatement.addBatch();
            }
            int[] rowsAffected = insertStatement.executeBatch();
            ResultSet generatedKeys = insertStatement.getGeneratedKeys();
            int i = 0;
            while (generatedKeys.next()) {
                toSave.get(i).setCompanyNumber(generatedKeys.getInt(1));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Company save(Company toSave) {
        String insertQuery = "INSERT INTO company (companyNumber, companyName, companyAddresse, companyCodePostal, companyContact) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            insertStatement.setInt(1, toSave.getCompanyNumber());
            insertStatement.setString(2, toSave.getCompanyName());
            insertStatement.setString(3, toSave.getCompanyAddresse());
            insertStatement.setString(4, toSave.getCompanyCodePostal());
            insertStatement.setString(5, toSave.getCompanyContact());

            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = insertStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    toSave.setCompanyNumber(generatedKeys.getInt(1));
                    return toSave;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Company toSave) {
        String updateQuery = "UPDATE company SET companyName=?, companyAddresse=?, " +
                "companyCodePostal=?, companyContact=? WHERE companyNumber=?";

        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, toSave.getCompanyName());
            updateStatement.setString(2, toSave.getCompanyAddresse());
            updateStatement.setString(3, toSave.getCompanyCodePostal());
            updateStatement.setString(4, toSave.getCompanyContact());
            updateStatement.setInt(5, toSave.getCompanyNumber());

            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Company getCompanyByNumber(int companyNumber) {
        String sql = "SELECT * FROM company WHERE companyNumber = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, companyNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Company(
                        resultSet.getInt("companyNumber"),
                        resultSet.getString("companyName"),
                        resultSet.getString("companyAddresse"),
                        resultSet.getString("companyCodePostal"),
                        resultSet.getString("companyContact")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

