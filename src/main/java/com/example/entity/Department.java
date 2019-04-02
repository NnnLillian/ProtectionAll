package com.example.entity;

public class Department {
    private Integer department_id;
    private String  department_name;
    private Integer people_max_number;

    private Department(){
    }

    public Department(Integer department_id, String department_name, Integer people_max_number) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.people_max_number = people_max_number;
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

    public Integer getPeople_max_number() {
        return people_max_number;
    }

    public void setPeople_max_number(Integer people_max_number) {
        this.people_max_number = people_max_number;
    }
}
