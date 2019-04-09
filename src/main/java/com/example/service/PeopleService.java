package com.example.service;

import com.example.entity.Army;
import com.example.entity.People;

import java.util.List;

public interface PeopleService {
    public People GetPeopleByPeopleID(Integer people_id);

    public List<People> GetPeopleByProfession(String people_profession);

    public List<People> GetPeopleByArmyType(String army_type);

    public void AddPeople(People people);

    public Integer IncreaseBase(String baseName);

    public Integer IncreasePlatoon(String platoonName);

    public Integer IncreaseArmy(Army army);
}
