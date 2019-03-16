package com.example.entity;

import java.util.List;

public class Group {
    private Integer group_id;
    private Integer scheme_id;
    private String  group_name;
    private String  group_type;
    private List<Team> team_list;

    public Group() {
    }

    public Group(Integer group_id, Integer scheme_id, String group_name, String group_type, List<Team> team_list) {
        this.group_id = group_id;
        this.scheme_id = scheme_id;
        this.group_name = group_name;
        this.group_type = group_type;
        this.team_list = team_list;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Integer getScheme_id() {
        return scheme_id;
    }

    public void setScheme_id(Integer scheme_id) {
        this.scheme_id = scheme_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_type() {
        return group_type;
    }

    public void setGroup_type(String group_type) {
        this.group_type = group_type;
    }

    public List<Team> getTeam_list() {
        return team_list;
    }

    public void setTeam_list(List<Team> team_list) {
        this.team_list = team_list;
    }
}
