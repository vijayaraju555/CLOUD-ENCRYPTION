package com.cloudencryption.service;

import com.cloudencryption.dao.UserDao;
import com.cloudencryption.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import org.hibernate.cfg.Configuration;

@Component
public class UserDaoImpl implements UserDao {

    private Session session;
    private SessionFactory factory;

    UserDaoImpl() {
        // for the spring to not show the error
        Configuration config = new Configuration().configure().addAnnotatedClass(User.class);
        factory = config.buildSessionFactory();
    }

    @Override
    public void addUser(User user) throws Exception {
        session = factory.openSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean checkUser(String email, String password) throws Exception {
        // check if the user exists and return true
        session = factory.openSession();
        Query query = session.createQuery("from User where email = :email and password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        try {
            if (query.list().size() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return false;
        }
        return false;
    }

    @Override
    public User getUserByEmail(String email) throws Exception {
        session = factory.openSession();
        Query q = session.createQuery("from User where email = :email ");
        q.setParameter("email", email);
        try {
            if (q.list().size() > 0) {
                User u = (User) q.list().get(0);
                session.close();
                return u;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return new User();
        }
    }
}
