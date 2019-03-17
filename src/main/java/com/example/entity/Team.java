package com.example.entity;

import java.util.List;

public class Team {
    private Integer team_id;
    private Integer group_id;
    private Integer army_id;
    private Integer location_id;
    private String team_name;
    private List<Team_Department> team_department_list;
    private List<Team_Category> team_category_list;
    private String team_type;

    public Team() {
    }

    public Team(Integer team_id, Integer group_id, Integer army_id, Integer location_id, String team_name, List<Team_Department> team_department_list, List<Team_Category> team_category_list, String team_type) {
        this.team_id = team_id;
        this.group_id = group_id;
        this.army_id = army_id;
        this.location_id = location_id;
        this.team_name = team_name;
        this.team_department_list = team_department_list;
        this.team_category_list = team_category_list;
        this.team_type = team_type;
    }

    public String getTeam_type() {
        return team_type;
    }

    public void setTeam_type(String team_type) {
        this.team_type = team_type;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Integer getArmy_id() {
        return army_id;
    }

    public void setArmy_id(Integer army_id) {
        this.army_id = army_id;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public List<Team_Department> getTeam_department_list() {
        return team_department_list;
    }

    public void setTeam_department_list(List<Team_Department> team_department_list) {
        this.team_department_list = team_department_list;
    }

    public List<Team_Category> getTeam_category_list() {
        return team_category_list;
    }

    public void setTeam_category_list(List<Team_Category> team_category_list) {
        this.team_category_list = team_category_list;
    }
}
