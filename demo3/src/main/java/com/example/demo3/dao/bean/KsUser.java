package com.example.demo3.dao.bean;

public class KsUser {
    private int user_id;
    private String user_name;
    private String user_department;
    private int user_is_admin;
    private int user_is_tested;
    private int user_score;
    private String user_option_subject;
    private int user_group;

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getUserDepartment() {
        return user_department;
    }

    public void setUserDepartment(String user_department) {
        this.user_department = user_department;
    }

    public int getUserIsAdmin() {
        return user_is_admin;
    }

    public void setUserIsAdmin(int user_is_admin) {
        this.user_is_admin = user_is_admin;
    }

    public int getUserIsTested() {
        return user_is_tested;
    }

    public void setUserIsTested(int user_is_tested) {
        this.user_is_tested = user_is_tested;
    }

    public int getUserScore() {
        return user_score;
    }

    public void setUserScore(int user_score) {
        this.user_score = user_score;
    }

    public String getUser_option_subject() {
        return user_option_subject;
    }

    public void setUser_option_subject(String user_option_subject) {
        this.user_option_subject = user_option_subject;
    }

    public int getUser_group() {
        return user_group;
    }

    public void setUser_group(int user_group) {
        this.user_group = user_group;
    }
}
