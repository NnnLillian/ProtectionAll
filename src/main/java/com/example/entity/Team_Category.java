package com.example.entity;

public class Team_Category {
    private Integer team_id;
    private Integer category_id;
    private String category_name;
    private Integer category_number;
    private String category_unit;

    public Team_Category() {
    }

    public Team_Category(Integer team_id, Integer category_id, String category_name, Integer category_number, String category_unit) {
        this.team_id = team_id;
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_number = category_number;
        this.category_unit = category_unit;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Integer getCategory_number() {
        return category_number;
    }

    public void setCategory_number(Integer category_number) {
        this.category_number = category_number;
    }

    public String getCategory_unit() {
        return category_unit;
    }

    public void setCategory_unit(String category_unit) {
        this.category_unit = category_unit;
    }
}
