/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.FriendDAO;
import com.dao.UserDAO;
import com.model.pojo.UserFriendTb;
import com.model.pojo.UsersTb;
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
public class FriendBean {

    public UserFriendTb userFriendTb = new UserFriendTb();
    private FriendDAO friendDAO = new FriendDAO();
    private UserDAO userDAO = new UserDAO();
    
    public String username;

    /**
     * Creates a new instance of FriendBean
     */
    public FriendBean() {
    }

    public void addFriend() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        
        UsersTb adder = new UsersTb();
        UsersTb addee = userDAO.getByUsername(username);
        
        adder.setId(Integer.valueOf(session.getAttribute("user_session_id").toString()));
        
        userFriendTb.setUsersTbByAdder(adder);
        userFriendTb.setUsersTbByAddee(addee);        
        
        friendDAO.addFriend(userFriendTb);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
