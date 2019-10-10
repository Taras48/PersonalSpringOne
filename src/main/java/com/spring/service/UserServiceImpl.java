package com.spring.service;

import com.spring.dao.UserDao;
import com.spring.dao.UserDaoImpl;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserDao userDao = new UserDaoImpl();

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Transactional
    public void updateUser(User user) {
userDao.updateUser(user);
    }
    @Transactional
    public void deletUser(Long id) {
userDao.deletUser(id);
    }
    @Transactional
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
