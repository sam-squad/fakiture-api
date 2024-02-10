package com.samsquad.fakitureapi.controller;


import com.samsquad.fakitureapi.entity.Client;
import com.samsquad.fakitureapi.service.ClientServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
    private ClientServices clientServices;

    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() throws SQLException {
        return clientServices.getAllClients();
    }
    @GetMapping("/client/{clientNumber}")
    public ResponseEntity<Client> getClientByNumber(@PathVariable int clientNumber) throws SQLException {
        Client client = clientServices.getClientByNumber(clientNumber);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/client")
    public ResponseEntity<Client> addClient(@RequestBody Client client) throws SQLException {
        Client savedClient = clientServices.saveClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }
    @PutMapping("/client/{clientNumber}")
    public ResponseEntity<Void> updateClient(@PathVariable int clientNumber, @RequestBody Client clientUpdate) throws SQLException {
        boolean updateSuccess = clientServices.updateClient(clientNumber, clientUpdate);
        if (updateSuccess) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
