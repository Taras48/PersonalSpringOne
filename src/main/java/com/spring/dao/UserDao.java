package com.spring.dao;

import com.spring.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public void deletUser(Long id);
    public User getUserById(Long id);
    public User getUserByName(String name);
    public List<User> getAllUsers();
}
