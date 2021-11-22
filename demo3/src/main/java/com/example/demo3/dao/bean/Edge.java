package com.example.demo3.dao.bean;

public class Edge {
    private int id1;
    private int id2;
    private String type;

    public Edge(int id1, int id2, String type) {
        this.id1 = id1;
        this.id2 = id2;
        this.type = type;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}