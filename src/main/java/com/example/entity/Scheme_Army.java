package com.example.entity;

public class Scheme_Army {

    private Integer scheme_id;
    private Integer army_id;
    private String  army_name;
    private Integer army_people;
    private Integer army_action_group;

    public Scheme_Army() {
    }

    public Scheme_Army(Integer scheme_id, Integer army_id, String army_name, Integer army_people, Integer army_action_group) {
        this.scheme_id = scheme_id;
        this.army_id = army_id;
        this.army_name = army_name;
        this.army_people = army_people;
        this.army_action_group = army_action_group;
    }

    public Integer getScheme_id() {
        return scheme_id;
    }

    public void setScheme_id(Integer scheme_id) {
        this.scheme_id = scheme_id;
    }

    public Integer getArmy_id() {
        return army_id;
    }

    public void setArmy_id(Integer army_id) {
        this.army_id = army_id;
    }

    public String getArmy_name() {
        return army_name;
    }

    public void setArmy_name(String army_name) {
        this.army_name = army_name;
    }

    public Integer getArmy_people() {
        return army_people;
    }

    public void setArmy_people(Integer army_people) {
        this.army_people = army_people;
    }

    public Integer getArmy_action_group() {
        return army_action_group;
    }

    public void setArmy_action_group(Integer army_action_group) {
        this.army_action_group = army_action_group;
    }
}
