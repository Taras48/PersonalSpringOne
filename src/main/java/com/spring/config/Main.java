package com.spring.config;

import com.spring.dao.UserDaoImpl;
import com.spring.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppInitializer.class);

       /* List<User> userList = context.getBean(UserDaoImpl.class).getAllUsers();
        for (User elem :userList) {
            System.out.println(elem);
        }*/

       User user = context.getBean(UserDaoImpl.class).getUserById(1L);
        System.out.println(user.getMessage());
    }
}
