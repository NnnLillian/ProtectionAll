package com.example.entity;

public class Team_Department {
    private Integer team_id;
    private Integer department_id;
    private Integer department_people;

    public Team_Department() {
    }

    public Team_Department(Integer team_id, Integer department_id, Integer department_people) {
        this.team_id = team_id;
        this.department_id = department_id;
        this.department_people = department_people;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Integer getDepartment_people() {
        return department_people;
    }

    public void setDepartment_people(Integer department_people) {
        this.department_people = department_people;
    }
}
