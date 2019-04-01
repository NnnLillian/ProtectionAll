package com.example.service.impl;

import com.example.entity.People;
import com.example.mappers.PeopleMapper;
import com.example.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleMapper peopleMapper;


    @Override
    public People GetPeopleByPeopleID(Integer people_id) {
        return peopleMapper.GetPeopleByPeopleID(people_id);
    }

    @Override
    public List<People> GetPeopleByProfession(String people_profession) {
        List<People> list = peopleMapper.GetPeopleByProfession(people_profession);
        return list;
    }

    @Override
    public void AddPeople(People people) {
        Integer id = people.getPeople_id();
        if (id == null) {
            peopleMapper.AddPeople(people);
        }
    }
}