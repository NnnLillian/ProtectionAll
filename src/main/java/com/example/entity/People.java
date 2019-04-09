package com.example.entity;

import java.sql.Date;

public class People {
    private Integer people_id;
    private String people_name;
    private String people_job;
    private String people_sex;
    private String people_nationality;
    private String military_rank;
    private String birthplace;
    private String birthday;
    private String enlistment;
    private String graduated_school;
    private String people_profession;
    private String education;
    private Integer people_army_id;
    private String people_army_name;
    private String comment;

    public People() {

    }

    public People(Integer people_id, String people_name, String people_job, String people_sex, String people_nationality, String military_rank, String birthplace, String birthday, String enlistment, String graduated_school, String people_profession, String education, Integer people_army_id, String people_army_name, String comment) {
        this.people_id = people_id;
        this.people_name = people_name;
        this.people_job = people_job;
        this.people_sex = people_sex;
        this.people_nationality = people_nationality;
        this.military_rank = military_rank;
        this.birthplace = birthplace;
        this.birthday = birthday;
        this.enlistment = enlistment;
        this.graduated_school = graduated_school;
        this.people_profession = people_profession;
        this.education = education;
        this.people_army_id = people_army_id;
        this.people_army_name = people_army_name;
        this.comment = comment;
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

    public String getPeople_job() {
        return people_job;
    }

    public void setPeople_job(String people_job) {
        this.people_job = people_job;
    }

    public String getPeople_sex() {
        return people_sex;
    }

    public void setPeople_sex(String people_sex) {
        this.people_sex = people_sex;
    }

    public String getPeople_nationality() {
        return people_nationality;
    }

    public void setPeople_nationality(String people_nationality) {
        this.people_nationality = people_nationality;
    }

    public String getMilitary_rank() {
        return military_rank;
    }

    public void setMilitary_rank(String military_rank) {
        this.military_rank = military_rank;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEnlistment() {
        return enlistment;
    }

    public void setEnlistment(String enlistment) {
        this.enlistment = enlistment;
    }

    public String getGraduated_school() {
        return graduated_school;
    }

    public void setGraduated_school(String graduated_school) {
        this.graduated_school = graduated_school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPeople_army_name() {
        return people_army_name;
    }

    public void setPeople_army_name(String people_army_name) {
        this.people_army_name = people_army_name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

