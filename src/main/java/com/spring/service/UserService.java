package com.spring.service;

import com.spring.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long id);
    public User getUserById(Long id);
    public List<User> getAllUsers();
}
