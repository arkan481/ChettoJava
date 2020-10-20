/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.UserDAO;
import com.model.pojo.UsersTb;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author arkan481
 */
@ManagedBean
@RequestScoped
public class UserBean {

    private UsersTb newUser = new UsersTb();
    private String cofirmPassword = "";
    private UserDAO userDAO = new UserDAO();

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }

    public void onLoad() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

        if (session.getAttribute("user_session_id") != null) {
            try {
                facesContext.getExternalContext().redirect("chatpage.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void signup() {
        userDAO.signUp(newUser);
    }

    public String getUserName() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        String userID = "";
        try {
            userID = session.getAttribute("user_session_id").toString();
            
        } catch (NullPointerException e) {
            
            e.printStackTrace();
            return "Not Logged In";
        }

        if (userID != null) {
            newUser = userDAO.getUsernameById(Integer.valueOf(userID));
            return newUser.getUsername();
        }

        return "Not Logged In";
    }

    public void signIn() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        List<UsersTb> loggedInUser = userDAO.signIn(newUser);
        if (loggedInUser.size() < 1) {
            // Invalid Credentials
            facesContext.addMessage("globalLogin", new FacesMessage("Wrong username or password!"));
        } else {
            try {
                // Do move to the chat page
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("user_session_id", loggedInUser.get(0).getId().toString());
                facesContext.getExternalContext().redirect("chatpage.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setCofirmPassword(String cofirmPassword) {
        this.cofirmPassword = cofirmPassword;
    }

    public String getCofirmPassword() {
        return cofirmPassword;
    }

    public UsersTb getNewUser() {
        return newUser;
    }

    public void setNewUser(UsersTb newUser) {
        this.newUser = newUser;
    }

}
