package com.example.service.impl;

import com.example.entity.Army;
import com.example.entity.Base;
import com.example.entity.People;
import com.example.entity.Platoon;
import com.example.mappers.ArmyMapper;
import com.example.mappers.PeopleMapper;
import com.example.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleMapper peopleMapper;
    @Autowired
    private ArmyMapper armyMapper;


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
    public List<People> GetPeopleByArmyType(String army_type) {
        return peopleMapper.GetPeopleByArmyType(army_type);
    }

    @Override
    public Integer AddPeople(People people) {
        String name = people.getPeople_name();
        if (name != null) {
            peopleMapper.AddPeople(people);
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public Integer IncreaseBase(String baseName) {
        Base base = armyMapper.GetBaseByName(baseName);
        if (base != null) {
            return 0;
        } else {
            armyMapper.IncreaseBase(baseName);
            return 1;
        }
    }

    @Override
    public Integer IncreasePlatoon(String platoonName) {
        Platoon platoon = armyMapper.GetPlatoonByName(platoonName);
        if (platoon != null) {
            return 0;
        } else {
            armyMapper.IncreasePlatoon(platoonName);
            return 1;
        }
    }

    @Override
    public Integer IncreaseArmy(Army army) {
        Army army1 = armyMapper.GetArmyByNameAndPlatooId(army.getArmy_name(), army.getPlatoon_id());
        if (army1!=null){
            return 0;
        }else {
            armyMapper.IncreaseArmy(army);
            return 1;
        }
    }
}
