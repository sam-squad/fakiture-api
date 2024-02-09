package com.samsquad.fakitureapi.repository;

import com.samsquad.fakitureapi.db.ConnectDB;
import com.samsquad.fakitureapi.entity.Client;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ClientCrudOperations implements CrudOperations<Client> {
    private final ConnectDB db = ConnectDB.getInstance();
    private Connection connection = db.getConnection();

    @Override
    public List<Client> findAll() {
        List<Client> clientList = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt("clientNumber"),
                        resultSet.getString("companyNameClient"),
                        resultSet.getString("clientAddress"),
                        resultSet.getString("clientPostalCode"),
                        resultSet.getString("clientCountry")
                );
                clientList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientList;
    }

    @Override
    public List<Client> saveAll(List<Client> toSave) {
        String insertQuery = "INSERT INTO client (clientNumber, companyNameClient, clientAddress, clientPostalCode, clientCountry) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            for (Client client : toSave) {
                insertStatement.setInt(1, client.getClientNumber());
                insertStatement.setString(2, client.getCompanyNameClient());
                insertStatement.setString(3, client.getClientAddress());
                insertStatement.setString(4, client.getClientPostalCode());
                insertStatement.setString(5, client.getClientCountry());
                insertStatement.addBatch();
            }
            int[] rowsAffected = insertStatement.executeBatch();
            ResultSet generatedKeys = insertStatement.getGeneratedKeys();
            int i = 0;
            while (generatedKeys.next()) {
                toSave.get(i).setClientNumber(generatedKeys.getInt(1));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Client save(Client toSave) {
        String insertQuery = "INSERT INTO client (clientNumber, companyNameClient, clientAddress, clientPostalCode, clientCountry) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            insertStatement.setInt(1, toSave.getClientNumber());
            insertStatement.setString(2, toSave.getCompanyNameClient());
            insertStatement.setString(3, toSave.getClientAddress());
            insertStatement.setString(4, toSave.getClientPostalCode());
            insertStatement.setString(5, toSave.getClientCountry());

            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = insertStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    toSave.setClientNumber(generatedKeys.getInt(1));
                    return toSave;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Client toSave) {
        String updateQuery = "UPDATE client SET companyNameClient=?, clientAddress=?, " +
                "clientPostalCode=?, clientCountry=? WHERE clientNumber=?";

        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, toSave.getCompanyNameClient());
            updateStatement.setString(2, toSave.getClientAddress());
            updateStatement.setString(3, toSave.getClientPostalCode());
            updateStatement.setString(4, toSave.getClientCountry());
            updateStatement.setInt(5, toSave.getClientNumber());

            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}