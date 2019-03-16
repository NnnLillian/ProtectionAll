package com.example.entity;

public class Special_Case {
    private Integer case_id;
    private String  case_position;
    private String  case_type;
    private Integer month_time;
    private String  description;

    public Special_Case() {
    }

    public Special_Case(Integer case_id, String case_position, String case_type, Integer month_time, String description) {
        this.case_id = case_id;
        this.case_position = case_position;
        this.case_type = case_type;
        this.month_time = month_time;
        this.description = description;
    }

    public Integer getCase_id() {
        return case_id;
    }

    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }

    public String getCase_position() {
        return case_position;
    }

    public void setCase_position(String case_position) {
        this.case_position = case_position;
    }

    public String getCase_type() {
        return case_type;
    }

    public void setCase_type(String case_type) {
        this.case_type = case_type;
    }

    public Integer getMonth_time() {
        return month_time;
    }

    public void setMonth_time(Integer month_time) {
        this.month_time = month_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
