package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulawaite on 2/2/16.
 */
public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            users = session.createCriteria(User.class).list();
            transaction.commit();
        }catch (HibernateException hibernateException) {
            if (transaction!=null) transaction.rollback();
            log.error("Hibernate Exception", hibernateException);
        }finally {
            session.close();
        }

        return users;
    }




    /**
     * retrieve a user given their id
     *
     * @param id the user's id
     * @return user
     *
    public User getUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        log.info(user.getUserid());
        return user;
    }

    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record
     *
    public int addUser(User user) {
        //TODO add the user and return the id of the inserted user
        //int id = 0;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(user);
        transaction.commit();
        return id;
    }

    /**
     * delete a user
     * @param id
     *
    public void deleteUser(int id) {
        // TODO delete the user with the given id
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = new User();
        user.setUserid(id);
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
    }

    /**
     * delete a user
     * @param user
     *
    public void deleteUser(User user) {
        // TODO delete the user with the given id
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
    }

    /**
     * Update the user
     * @param user
     *

    public int updateUser(User user) {
        // TODO update the user
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String Update = "update User user set user.lastName = :newLastName," +
                " user.firstName=:newFirstName," +
                " user.password=:newpassword," +
                " user.emailId=:newEmailId where user.id = :id";
       // or String hqlUpdate = "update Customer set name = :newName where name = :oldName";
        int updatedEntities = session.createQuery(Update)
                .setString("newLastName", user.getLastName())
                .executeUpdate();
        transaction.commit();
        return updatedEntities;
    }*/

}

