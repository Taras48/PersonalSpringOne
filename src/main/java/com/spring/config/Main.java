package com.spring.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_example";
        String name ="root";
        String pass ="root";

        try (Connection connection = DriverManager.getConnection(url,name,pass)){
            System.out.println("ok");
        } catch (SQLException e) {
            System.out.println("no");
            e.printStackTrace();
        }
    }
}
