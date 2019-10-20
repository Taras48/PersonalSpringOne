package com.spring.dao;

import com.spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        System.out.println("user add ");
    }

    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        System.out.println("user update");
    }

    public void deletUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        session.delete(user);
        System.out.println("user delete");
    }

    public User getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        System.out.println("user get by id");
        return user;
    }

    @Override
    public User getUserByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where name = :name");
        query.setParameter("name", name);
        User user = (User) query.uniqueResult();
        return user;
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> listUsers = session.createQuery("from User").list();
        System.out.println("get all users");
        return listUsers;
    }


}
