package com.example.mappers;

import com.example.entity.People;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleMapper {
    public People GetPeopleByPeopleID(Integer people_id);

    public List<People> GetPeopleByProfession(String people_profession);

    public List<People> GetPeopleByArmyType(String army_type);

    public void AddPeople(People people);

    public void changePeopleSelected(@Param("people_id") Integer people_id, @Param("check") boolean check);
}
