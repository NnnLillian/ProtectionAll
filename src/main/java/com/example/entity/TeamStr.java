package com.example.entity;

public class TeamStr {
    private Integer team_id;
    private String team_name;
    private String group_name;
    private String army_name;
    private String team_duty;

    public TeamStr() {
    }

    public TeamStr(Integer team_id, String team_name, String group_name, String army_name, String team_duty) {
        this.team_id = team_id;
        this.team_name = team_name;
        this.group_name = group_name;
        this.army_name = army_name;
        this.team_duty = team_duty;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getArmy_name() {
        return army_name;
    }

    public void setArmy_name(String army_name) {
        this.army_name = army_name;
    }

    public String getTeam_duty() {
        return team_duty;
    }

    public void setTeam_duty(String team_duty) {
        this.team_duty = team_duty;
    }
}
