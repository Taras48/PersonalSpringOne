package com.spring.service;

import com.spring.dao.UserDao;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {


        User user = userDao.getUserByName(name);
        if (user == null){
            throw new UsernameNotFoundException("User name Not Found");
        }

        return user;
    }
}
*/
