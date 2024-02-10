package com.samsquad.fakitureapi.service;

import com.samsquad.fakitureapi.entity.Client;
import com.samsquad.fakitureapi.repository.ClientCrudOperations;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClientServices {
    private final ClientCrudOperations clientCrudOperations;

    public ClientServices(ClientCrudOperations clientCrudOperations) {
        this.clientCrudOperations = clientCrudOperations;
    }
    public List<Client> getAllClients() throws SQLException {
        return clientCrudOperations.findAll();
    }
    public Client saveClient(Client client) throws SQLException {
        return clientCrudOperations.save(client);
    }
    public List<Client> saveAllClients(List<Client> clients) throws SQLException {
        return clientCrudOperations.saveAll(clients);
    }
    public boolean updateClient(int clientNumber, Client client) throws SQLException {
        return clientCrudOperations.update(client);
    }
    public Client getClientByNumber(int clientNumber) {
        return clientCrudOperations.getClientByNumber(clientNumber);
    }
}

