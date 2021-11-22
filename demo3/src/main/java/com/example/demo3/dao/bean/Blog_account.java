package com.example.demo3.dao.bean;

import javax.xml.crypto.Data;

public class Blog_account {
    private int id;
    private String account;
    private String info;
    private String partnerids;
    private String username;

    public Blog_account() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPartnerids() {
        return partnerids;
    }

    public void setPartnerids(String partnerids) {
        this.partnerids = partnerids;
    }
}
