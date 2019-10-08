package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.util.impl.LoggerFactory;

import java.util.List;
import java.util.logging.Logger;

public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        session.close();

    }

    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        session.close();

    }

    public void deletUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        session.close();

    }

    public User getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        session.close();
        return user;
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<User> listUsers = session.createQuery("from user").list();
        transaction.commit();
        session.close();
        return listUsers;
    }


}
