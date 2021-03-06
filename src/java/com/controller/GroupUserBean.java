/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.GroupUserDAO;
import com.model.pojo.GroupChatTb;
import com.model.pojo.GroupUserTb;
import com.model.pojo.UsersTb;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arkan481
 */
@ManagedBean
@RequestScoped
public class GroupUserBean {

    public GroupUserTb groupUserTb = new GroupUserTb();
    public GroupUserDAO groupUserDAO = new GroupUserDAO();

    /**
     * Creates a new instance of GroupUserBean
     */
    public GroupUserBean() {
    }

    public void joinGroup() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        
        int currentUserID = Integer.parseInt(session.getAttribute("user_session_id").toString());
        
        UsersTb currentUser = new UsersTb();
        currentUser.setId(currentUserID);

        groupUserTb.setUsersTb(currentUser);
        groupUserDAO.createGroup(groupUserTb);
    }

    public List<GroupUserTb> getUserGroup() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

        List<GroupUserTb> groupUserTbs = groupUserDAO.getUserGroups(Integer.parseInt(session.getAttribute("user_session_id").toString()));

        return groupUserTbs;

    }
    
    public void inviteToGroup() {
        groupUserDAO.createGroup(groupUserTb);
    }

    public String getLatestMessage(Set<GroupChatTb> groupChatTbs) {
        String lastMessage = "";

        for (GroupChatTb groupChatTb : groupChatTbs) {
            lastMessage = groupChatTb.getMessage();
        }

        return lastMessage;
    }
    
    public void leaveGroup(GroupUserTb groupUserTb) {
        groupUserDAO.leaveGroup(groupUserTb);
    }

    public GroupUserTb getGroupUserTb() {
        return groupUserTb;
    }

    public void setGroupUserTb(GroupUserTb groupUserTb) {
        this.groupUserTb = groupUserTb;
    }

}
