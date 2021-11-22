package com.example.demo3.dao.bean;

public class Sim_Case_info {
    private int id;
    private int caseid1;
    private int caseid2;
    private String similarity;
    private String name1;
    private String name2;

    public Sim_Case_info() {
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

    public String getSimilarity() {
        return similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }
}
