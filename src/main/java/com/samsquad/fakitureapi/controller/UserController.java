package com.samsquad.fakitureapi.controller;

import com.samsquad.fakitureapi.entity.Client;
import com.samsquad.fakitureapi.entity.User;
import com.samsquad.fakitureapi.service.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() throws SQLException {
        return userServices.getAllUsers();
    }
    @GetMapping("/user/{userNumber}")
    public ResponseEntity<User> getUserByNumber(@PathVariable int userNumber) throws SQLException {
        User user = userServices.getUserByNumber(userNumber);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user) throws SQLException {
        User savedUser = userServices.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @PutMapping("/user/{userNumber}")
    public ResponseEntity<Void> updateUser(@PathVariable int userNumber, @RequestBody User userUpdate) throws SQLException {
        boolean updateSuccess = userServices.updateUser(userNumber, userUpdate);
        if (updateSuccess) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

