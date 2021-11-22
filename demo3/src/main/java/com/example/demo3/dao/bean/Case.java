package com.example.demo3.dao.bean;

import java.sql.Date;
import java.sql.Time;

public class Case {
    private int id;
    private String name;
    private String personid_involve;
    private int amount;
    private String place;
    private String type;
    private String website;
    private String phone;
    private String bankcard;
    private String victims;
    private Date time;
    private Date import_time;
    private String personname_involve;
    private String victimsname;
    private String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getTime() {
        return time;
    }

    public String getPersonname_involve() {
        return personname_involve;
    }

    public void setPersonname_involve(String personname_involve) {
        this.personname_involve = personname_involve;
    }

    public String getVictimsname() {
        return victimsname;
    }

    public void setVictimsname(String victimsname) {
        this.victimsname = victimsname;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getImport_time() {
        return import_time;
    }

    public void setImport_time(Date import_time) {
        this.import_time = import_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonid_involve() {
        return personid_involve;
    }

    public void setPersonid_involve(String personid_involve) {
        this.personid_involve = personid_involve;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getVictims() {
        return victims;
    }

    public void setVictims(String victims) {
        this.victims = victims;
    }


}
