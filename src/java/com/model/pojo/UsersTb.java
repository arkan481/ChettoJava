package com.model.pojo;
// Generated Oct 20, 2020 1:17:42 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * UsersTb generated by hbm2java
 */
public class UsersTb  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String password;
     private Set<UserFriendTb> userFriendTbsForAddee = new HashSet<UserFriendTb>(0);
     private Set<GroupChatTb> groupChatTbs = new HashSet<GroupChatTb>(0);
     private Set<GroupUserTb> groupUserTbs = new HashSet<GroupUserTb>(0);
     private Set<UserFriendTb> userFriendTbsForAdder = new HashSet<UserFriendTb>(0);

    public UsersTb() {
    }

	
    public UsersTb(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public UsersTb(String username, String password, Set<UserFriendTb> userFriendTbsForAddee, Set<GroupChatTb> groupChatTbs, Set<GroupUserTb> groupUserTbs, Set<UserFriendTb> userFriendTbsForAdder) {
       this.username = username;
       this.password = password;
       this.userFriendTbsForAddee = userFriendTbsForAddee;
       this.groupChatTbs = groupChatTbs;
       this.groupUserTbs = groupUserTbs;
       this.userFriendTbsForAdder = userFriendTbsForAdder;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<UserFriendTb> getUserFriendTbsForAddee() {
        return this.userFriendTbsForAddee;
    }
    
    public void setUserFriendTbsForAddee(Set<UserFriendTb> userFriendTbsForAddee) {
        this.userFriendTbsForAddee = userFriendTbsForAddee;
    }
    public Set<GroupChatTb> getGroupChatTbs() {
        return this.groupChatTbs;
    }
    
    public void setGroupChatTbs(Set<GroupChatTb> groupChatTbs) {
        this.groupChatTbs = groupChatTbs;
    }
    public Set<GroupUserTb> getGroupUserTbs() {
        return this.groupUserTbs;
    }
    
    public void setGroupUserTbs(Set<GroupUserTb> groupUserTbs) {
        this.groupUserTbs = groupUserTbs;
    }
    public Set<UserFriendTb> getUserFriendTbsForAdder() {
        return this.userFriendTbsForAdder;
    }
    
    public void setUserFriendTbsForAdder(Set<UserFriendTb> userFriendTbsForAdder) {
        this.userFriendTbsForAdder = userFriendTbsForAdder;
    }




}


