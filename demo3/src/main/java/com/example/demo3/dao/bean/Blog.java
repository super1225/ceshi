package com.example.demo3.dao.bean;

import javax.xml.crypto.Data;

public class Blog {
    private int id;
    private int userid;
    private String blog;
    private String forward_accounts;
    private String like_accounts;
    private Data time;

    public Blog() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getForward_accounts() {
        return forward_accounts;
    }

    public void setForward_accounts(String forward_accounts) {
        this.forward_accounts = forward_accounts;
    }

    public String getLike_accounts() {
        return like_accounts;
    }

    public void setLike_accounts(String like_accounts) {
        this.like_accounts = like_accounts;
    }

    public Data getTime() {
        return time;
    }

    public void setTime(Data time) {
        this.time = time;
    }
}
