package com.model.pojo;
// Generated Oct 20, 2020 1:17:42 PM by Hibernate Tools 4.3.1



/**
 * GroupUserTb generated by hbm2java
 */
public class GroupUserTb  implements java.io.Serializable {


     private Integer id;
     private GroupTb groupTb = new GroupTb();
     private UsersTb usersTb = new UsersTb();

    public GroupUserTb() {
    }

    public GroupUserTb(GroupTb groupTb, UsersTb usersTb) {
       this.groupTb = groupTb;
       this.usersTb = usersTb;
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




}


