package com.model.pojo;
// Generated Oct 20, 2020 1:17:42 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * GroupChatTb generated by hbm2java
 */
public class GroupChatTb  implements java.io.Serializable {


     private Integer id;
     private GroupTb groupTb;
     private UsersTb usersTb;
     private String message;
     private Date date;

    public GroupChatTb() {
    }

    public GroupChatTb(GroupTb groupTb, UsersTb usersTb, String message, Date date) {
       this.groupTb = groupTb;
       this.usersTb = usersTb;
       this.message = message;
       this.date = date;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public GroupTb getGroupTb() {
        return this.groupTb;
    }
    
    public void setGroupTb(GroupTb groupTb) {
        this.groupTb = groupTb;
    }
    public UsersTb getUsersTb() {
        return this.usersTb;
    }
    
    public void setUsersTb(UsersTb usersTb) {
        this.usersTb = usersTb;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }




}


