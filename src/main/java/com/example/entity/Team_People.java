package com.example.entity;

public class Team_People {
    private Integer team_id;
    private String team_name;
    private String team_duty;
    private Integer department_id;
    private String department_name;
    private Integer people_id;
    private String people_name;
    private String people_job;
    private String people_profession;

    public Team_People(){}

    public Team_People(Integer team_id, String team_name, String team_duty, Integer department_id, String department_name, Integer people_id, String people_name, String people_job, String people_profession) {
        this.team_id = team_id;
        this.team_name = team_name;
        this.team_duty = team_duty;
        this.department_id = department_id;
        this.department_name = department_name;
        this.people_id = people_id;
        this.people_name = people_name;
        this.people_job = people_job;
        this.people_profession = people_profession;
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

    public String getTeam_duty() {
        return team_duty;
    }

    public void setTeam_duty(String team_duty) {
        this.team_duty = team_duty;
    }

    public Integer getPeople_id() {
        return people_id;
    }

    public void setPeople_id(Integer people_id) {
        this.people_id = people_id;
    }

    public String getPeople_name() {
        return people_name;
    }

    public void setPeople_name(String people_name) {
        this.people_name = people_name;
    }

    public String getPeople_job() {
        return people_job;
    }

    public void setPeople_job(String people_job) {
        this.people_job = people_job;
    }

    public String getPeople_profession() {
        return people_profession;
    }

    public void setPeople_profession(String people_profession) {
        this.people_profession = people_profession;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}



