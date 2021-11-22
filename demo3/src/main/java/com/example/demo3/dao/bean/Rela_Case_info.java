package com.example.demo3.dao.bean;

import java.sql.Time;

public class Rela_Case_info {
    private int id;
    private int caseid1;
    private int caseid2;
    private String relation_type;
    private String name1;
    private String name2;
    private String place1;
    private String place2;
    private String userid1;
    private String userid2;

    public String getUserid1() {
        return userid1;
    }

    public void setUserid1(String userid1) {
        this.userid1 = userid1;
    }

    public String getUserid2() {
        return userid2;
    }

    public void setUserid2(String userid2) {
        this.userid2 = userid2;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public Rela_Case_info() {
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaseid1() {
        return caseid1;
    }

    public void setCaseid1(int caseid1) {
        this.caseid1 = caseid1;
    }

    public int getCaseid2() {
        return caseid2;
    }

    public void setCaseid2(int caseid2) {
        this.caseid2 = caseid2;
    }

    public String getRelation_type() {
        return relation_type;
    }

    public void setRelation_type(String relation_type) {
        this.relation_type = relation_type;
    }
}
