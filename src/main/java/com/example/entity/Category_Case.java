package com.example.entity;

public class Category_Case {
    private Integer category_case_id;
    private Integer category_id;
    private String  case_position;
    private String  case_description;

    public Category_Case() {
    }

    public Category_Case(Integer category_case_id, Integer category_id, String case_position, String case_description) {
        this.category_case_id = category_case_id;
        this.category_id = category_id;
        this.case_position = case_position;
        this.case_description = case_description;
    }

    public Integer getCategory_case_id() {
        return category_case_id;
    }

    public void setCategory_case_id(Integer category_case_id) {
        this.category_case_id = category_case_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCase_position() {
        return case_position;
    }

    public void setCase_position(String case_position) {
        this.case_position = case_position;
    }

    public String getCase_description() {
        return case_description;
    }

    public void setCase_description(String case_description) {
        this.case_description = case_description;
    }
}

