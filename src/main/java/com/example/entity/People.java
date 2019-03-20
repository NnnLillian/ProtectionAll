package com.example.entity;

public class People {
    private Integer people_id;
    private String people_name;
    private String people_profession;
    private Integer people_army_id;

    public People() {

    }

    public People(Integer people_id, String people_name, String people_profession, Integer people_army_id) {
        this.people_id = people_id;
        this.people_name = people_name;
        this.people_profession = people_profession;
        this.people_army_id = people_army_id;
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

    public String getPeople_profession() {
        return people_profession;
    }

    public void setPeople_profession(String people_profession) {
        this.people_profession = people_profession;
    }

    public Integer getPeople_army_id() {
        return people_army_id;
    }

    public void setPeople_army_id(Integer people_army_id) {
        this.people_army_id = people_army_id;
    }
}

