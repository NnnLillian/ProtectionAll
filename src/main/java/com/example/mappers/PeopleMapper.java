package com.example.mappers;

import com.example.entity.People;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleMapper {
    public People GetPeopleByPeopleID(Integer people_id);

    public List<People> GetPeopleByProfession(String people_profession);

    public void AddPeople(People people);
}
