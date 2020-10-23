/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.GroupChatDAO;
import com.model.pojo.GroupChatTb;
import com.model.pojo.GroupTb;
import com.model.pojo.UsersTb;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;

/**
 *
 * @author arkan481
 */
@ManagedBean
@RequestScoped
public class GroupChatBean {

    private GroupChatTb groupChatTb = new GroupChatTb();
    private GroupChatDAO groupChatDAO = new GroupChatDAO();
    private int groupID = 0;

    /**
     * Creates a new instance of GroupChatBean
     */
    public GroupChatBean() {
    }

    public List<GroupChatTb> getGroupChatByGroupId(int groupId) {
        this.groupID = groupId;

        return groupChatDAO.getGroupChatByGroupId(groupId);
    }

    public void sendChat() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

        GroupTb groupTb = new GroupTb();
        groupTb.setId(groupID);

        UsersTb usersTb = new UsersTb();
        usersTb.setId(Integer.parseInt(session.getAttribute("user_session_id").toString()));

        groupChatTb.setGroupTb(groupTb);
        groupChatTb.setUsersTb(usersTb);

        groupChatDAO.sendChat(groupChatTb);
        
        try {
            facesContext.getExternalContext().redirect("chatpage.xhtml?group="+groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupChatBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public GroupChatTb getGroupChatTb() {
        return groupChatTb;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

}
