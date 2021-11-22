package com.example.demo3.dao.bean;

import java.sql.Date;

public class Travel {
    private int id;
    private int userid;
    private String trainnumber;
    private String partnerids;
    private Date time;

    public Travel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTrainnumber() {
        return trainnumber;
    }

    public void setTrainnumber(String trainnumber) {
        this.trainnumber = trainnumber;
    }

    public String getPartnerids() {
        return partnerids;
    }

    public void setPartnerids(String partnerids) {
        this.partnerids = partnerids;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
