/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.pojo.GroupTb;
import com.model.pojo.UsersTb;
import com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author arkan481
 */
public class GroupDAO {

    public void createGroup(GroupTb groupTb) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(groupTb);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
    }

    public GroupTb getGroupById(int groupId) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();

        GroupTb group = new GroupTb();

        try {
            session.beginTransaction();
            Query qu = session.createQuery("From GroupTb U where U.id=:id");
            qu.setParameter("id", groupId);
            group = (GroupTb) qu.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        return group;
    }
}
