package com.spring.dao;

import com.spring.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RoleDaoImpl implements RoleDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role getRoleByString(String role) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Role where role = :role");
        query.setParameter("role", role);
        Role roles = (Role) query.uniqueResult();
        return roles;
    }
}


