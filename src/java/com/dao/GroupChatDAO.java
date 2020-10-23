/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.pojo.GroupChatTb;
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
public class GroupChatDAO {

    public List<GroupChatTb> getGroupChatByGroupId(int groupId) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();

        List<GroupChatTb> groupChatTbs = new ArrayList<>();

        try {
            session.beginTransaction();
            Query qu = session.createQuery("From GroupChatTb G where G.groupTb.id=:groupId");
            qu.setParameter("groupId", groupId);
            groupChatTbs = qu.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return groupChatTbs;
    }

    public void sendChat(GroupChatTb groupChatTb) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.merge(groupChatTb);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
    }

}
