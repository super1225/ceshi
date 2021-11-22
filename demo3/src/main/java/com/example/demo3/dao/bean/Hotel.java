package com.example.demo3.dao.bean;

import java.sql.Date;

public class Hotel {
    private int id;
    private int userid;
    private String hotelname;
    private String partnerids;
    private Date time;
    private  String hotel_info;

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getHotel_info() {
        return hotel_info;
    }

    public void setHotel_info(String hotel_info) {
        this.hotel_info = hotel_info;
    }

    public Hotel() {
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
