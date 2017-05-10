package com.persistence;

import com.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Returnt a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = null;
        Session session = null;
        try {
            session = openSession();
            users = session.createCriteria(User.class).list();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception: " + he);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }

    /**
     * Get a single user for the given id
     *
     * @param id user's id
     * @return User
     */
    public User getUser(int id) {
        User user = null;
        Session session = null;
        try {
            session = openSession();
            user = (User) session.get(User.class, id);
        } catch (HibernateException he) {
            logger.error("Hibernate Exception: " + he);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    /**
     * Retrieve users by userName
     *
     * @param userName User's userName
     * @return User
     */
    public User getUserByUserName(String userName) {
        User user = new User();
        Session session = null;
        try {
            session = openSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", userName));

        } catch (HibernateException he) {
            logger.error("Hibernate Exception: " + he);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}