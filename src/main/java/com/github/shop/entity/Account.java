package com.github.shop.entity;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {

    private int userId;
    private String username, password;
    private int isSeller, isAdmin;

    public Account() {
    }

    public Account(int userId) {
        this.userId = userId;
    }

    public Account(int userId, String username, String password, int isSeller, int isAdmin) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.isSeller = isSeller;
        this.isAdmin = isAdmin;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(int isSeller) {
        this.isSeller = isSeller;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isSeller=" + isSeller +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
