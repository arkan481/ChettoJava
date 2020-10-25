/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.pojo.UserFriendTb;
import com.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author arkan481
 */
public class FriendDAO {

    public void addFriend(UserFriendTb userFriendTb) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(userFriendTb);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
    }
    
        // buat method fetch friend pake session id
    public List<UserFriendTb> getUserFriend(int userID) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();

        List<UserFriendTb> userFriend = new ArrayList<>();

        try {

            session.beginTransaction();
            Query qu = session.createQuery("FROM UserFriendTb G WHERE G.usersTbByAdder.id=:userId or G.usersTbByAddee.id=:userId");
            qu.setParameter("userId", userID);
            userFriend = qu.list();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return userFriend;
    }

    // contoh query
    //"From UsersFriendTb U where U.usersTbByAdder.id=:id"
    // buat method delete friend pake id
    public void delete(UserFriendTb friend) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("delete UserFriendTb T where T.id =:id");
            q.setParameter("id", friend.getId());
            q.executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
}
