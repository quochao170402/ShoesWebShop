package com.github.shop.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String SERVER_NAME = "localhost";
            String DB_NAME = "webshop";
            String PORT_NUMBER = "3306";
            String url = "jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME;
            String USER_ID = "root";
            String PASSWORD = "quochao1";
            return DriverManager.getConnection(url, USER_ID, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
