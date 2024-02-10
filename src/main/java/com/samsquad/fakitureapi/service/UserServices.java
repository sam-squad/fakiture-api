package com.samsquad.fakitureapi.service;


import com.samsquad.fakitureapi.entity.User;
import com.samsquad.fakitureapi.repository.UserCrudOperations;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServices {
    private final UserCrudOperations userCrudOperations;

    public UserServices(UserCrudOperations userCrudOperations) throws SQLException {
        this.userCrudOperations = userCrudOperations;
    }
    public List<User> getAllUsers() throws SQLException {
        return userCrudOperations.findAll();
    }
    public User saveUser(User user) throws SQLException {
        return userCrudOperations.save(user);
    }
    public List<User> saveAllUsers(List<User> users) throws SQLException {
        return userCrudOperations.saveAll(users);
    }
    public boolean updateUser(int userNumber, User user) throws SQLException {
        return userCrudOperations.update(user);
    }
    public User getUserByNumber(int userNumber) {
        return userCrudOperations.getUserByNumber(userNumber);
    }
}

