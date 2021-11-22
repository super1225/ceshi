package com.example.demo3.dao.bean;

public class Hcrecent {
    private String time;
    private String type;
    private String num;

    public Hcrecent(String time, String type, String num) {
        this.time = time;
        this.type = type;
        this.num = num;
    }

    public Hcrecent() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
