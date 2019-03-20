package com.example.service;

import com.example.entity.People;

import java.util.List;

public interface PeopleService {
    public People GetPeopleByPeopleID(Integer people_id);

    public List<People> GetPeopleByProfession(String people_profession);

    public void AddPeople(People people);
}
