package com.example.demo3.dao.bean;

public class Rela_person_info {
    //private int id;
    private String 关联人物;
    private int 关联案件id;
    private String 关联类型;
    private Case 案件信息;

    public Rela_person_info() {
    }

    public Rela_person_info(String 关联人物, int 关联案件id, String 关联类型, Case 案件信息) {
        this.关联人物 = 关联人物;
        this.关联案件id = 关联案件id;
        this.关联类型 = 关联类型;
        this.案件信息 = 案件信息;
    }

    public String get关联人物() {
        return 关联人物;
    }

    public void set关联人物(String 关联人物) {
        this.关联人物 = 关联人物;
    }

    public int get关联案件id() {
        return 关联案件id;
    }

    public void set关联案件id(int 关联案件id) {
        this.关联案件id = 关联案件id;
    }

    public String get关联类型() {
        return 关联类型;
    }

    public void set关联类型(String 关联类型) {
        this.关联类型 = 关联类型;
    }

    public Case get案件信息() {
        return 案件信息;
    }

    public void set案件信息(Case 案件信息) {
        this.案件信息 = 案件信息;
    }
}
