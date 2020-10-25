/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.GroupDAO;
import com.model.pojo.GroupTb;
import com.model.pojo.GroupUserTb;
import com.model.pojo.UsersTb;
import java.util.ArrayList;
import java.util.HashSet;
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
public class GroupBean {

    public GroupTb groupTB = new GroupTb();
    public GroupDAO groupDAO = new GroupDAO();

    /**
     * Creates a new instance of GroupBean
     */
    public GroupBean() {
    }

    public void createGroup() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

        groupTB.setGroupOwner(Integer.parseInt(session.getAttribute("user_session_id").toString()));

        groupDAO.createGroup(groupTB);
    }

    public GroupTb getGroupTB() {
        return groupTB;
    }

    public void setGroupTB(GroupTb groupTB) {
        this.groupTB = groupTB;
    }

    public List<GroupUserTb> getGroupMembers(int groupID) {
        List<GroupUserTb> groupMembers = new ArrayList<>();
        Set<GroupUserTb> groupUserTbs;
        
        try {
             groupUserTbs = groupDAO.getGroupById(groupID).getGroupUserTbs();

        } catch (NullPointerException e) {
            return groupMembers;
        }

        for (GroupUserTb groupUserTb : groupUserTbs) {
            groupMembers.add(groupUserTb);
        }

        return groupMembers;
    }

}
