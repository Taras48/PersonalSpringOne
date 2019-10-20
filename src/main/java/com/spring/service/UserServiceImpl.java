package com.spring.service;

import com.spring.dao.UserDao;
import com.spring.dao.UserDaoImpl;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserDao(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }


    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.addUser(user);
    }


    public void updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.updateUser(user);
    }


    public void deleteUser(Long id) {
        userDao.deletUser(id);
    }


    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }


    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
