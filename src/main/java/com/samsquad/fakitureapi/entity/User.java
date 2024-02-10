package com.samsquad.fakitureapi.entity;

public class User {
    private int userNumber;
    private String userName;
    private String password;

    public User(int userNumber, String userName, String password) {
        this.userNumber = userNumber;
        this.userName = userName;
        this.password = password;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNumber=" + userNumber +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
