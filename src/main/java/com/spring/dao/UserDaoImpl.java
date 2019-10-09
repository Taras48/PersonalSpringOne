package com.spring.dao;

import com.spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        session.close();
        System.out.println("user add ");

    }

    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        session.close();
        System.out.println("user update");
    }

    public void deletUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        session.close();
        System.out.println("user delete");

    }

    public User getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        session.close();
        System.out.println("user get by id ");
        return user;
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<User> listUsers = session.createQuery("from user").list();
        transaction.commit();
        session.close();
        System.out.println("get all users ");
        return listUsers;
    }


}
