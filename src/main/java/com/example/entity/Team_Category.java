package com.example.entity;

public class Team_Category {
    private Integer team_id;
    private Integer category_id;
    private Integer category_number;

    public Team_Category() {
    }

    public Team_Category(Integer team_id, Integer category_id, Integer category_number) {
        this.team_id = team_id;
        this.category_id = category_id;
        this.category_number = category_number;
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

    public Integer getCategory_number() {
        return category_number;
    }

    public void setCategory_number(Integer category_number) {
        this.category_number = category_number;
    }
}
