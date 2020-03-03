package com.example.nagendra.movie.Models;

public class User {

    String username,userphonenumber,useremailid,userpassword;

    public User() {
    }

    public User(String username, String userphonenumber, String useremailid, String userpassword) {
        this.username = username;
        this.userphonenumber = userphonenumber;
        this.useremailid = useremailid;
        this.userpassword = userpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphonenumber() {
        return userphonenumber;
    }

    public void setUserphonenumber(String userphonenumber) {
        this.userphonenumber = userphonenumber;
    }

    public String getUseremailid() {
        return useremailid;
    }

    public void setUseremailid(String useremailid) {
        this.useremailid = useremailid;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
