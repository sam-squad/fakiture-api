package com.samsquad.fakitureapi.controller;

import com.samsquad.fakitureapi.entity.User;
import com.samsquad.fakitureapi.service.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/")
    public List<User> getAllUsers() throws SQLException {
        return userServices.getAllUsers();
    }

    @PostMapping("/all")
    public ResponseEntity<User> addUser(@RequestBody User user) throws SQLException {
        User savedUser = userServices.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/")
    public ResponseEntity<List<User>> addAllUsers(@RequestBody List<User> users) throws SQLException {
        List<User> savedUsers = userServices.saveAllUsers(users);
        return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
    }

    @PutMapping("/{userNumber}")
    public ResponseEntity<Void> updateUser(@PathVariable int userNumber, @RequestBody User userUpdate) throws SQLException {
        boolean updateSuccess = userServices.updateUser(userNumber, userUpdate);
        if (updateSuccess) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

