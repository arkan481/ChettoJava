/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.pojo.UsersTb;
import com.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author arkan481
 */
public class UserDAO {

    public void signUp(UsersTb newUser) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(newUser);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
    }

    public List<UsersTb> signIn(UsersTb user) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();

        List<UsersTb> userList = new ArrayList<>();

        try {
            session.beginTransaction();
            Query qu = session.createQuery("From UsersTb U where U.username=:username AND U.password=:password");
            qu.setParameter("username", user.getUsername());
            qu.setParameter("password", user.getPassword());
            userList = qu.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return userList;
    }

    public UsersTb getUsernameById(int id) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();

        UsersTb user = new UsersTb();

        try {
            session.beginTransaction();
            Query qu = session.createQuery("From UsersTb U where U.id=:id");
            qu.setParameter("id", id);
            user = (UsersTb) qu.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return user;
    }

    public UsersTb getByUsername(String username) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();

        UsersTb user = new UsersTb();

        try {
            session.beginTransaction();
            Query qu = session.createQuery("From UsersTb U where U.username=:username");
            qu.setParameter("username", username);
            user = (UsersTb) qu.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return user;
    }

}
