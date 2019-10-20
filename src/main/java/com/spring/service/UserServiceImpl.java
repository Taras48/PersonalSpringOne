package com.spring.service;

import com.spring.dao.UserDao;
import com.spring.dao.UserDaoImpl;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {


    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserDao(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userDao.getUserByName(name);
        if (user == null){
            throw new UsernameNotFoundException("User name Not Found");
        }
        return user;
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
