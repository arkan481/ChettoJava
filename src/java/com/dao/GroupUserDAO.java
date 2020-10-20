/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.pojo.GroupTb;
import com.model.pojo.GroupUserTb;
import com.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author arkan481
 */
public class GroupUserDAO {

    public void createGroup(GroupUserTb groupUserTb) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(groupUserTb);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
    }

        public List<GroupUserTb> getUserGroups(int userID) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        
        List<GroupUserTb> userGroup = new ArrayList<>();

        try {
            
            session.beginTransaction();
            Query qu = session.createQuery("FROM GroupUserTb G WHERE G.usersTb.id=:userId");
            qu.setParameter("userId", userID);
            userGroup = qu.list();            
            
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        return userGroup;
    }

}
