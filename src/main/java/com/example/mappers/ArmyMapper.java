package com.example.mappers;

import com.example.entity.Action_Group;
import com.example.entity.Army;
import com.example.entity.Base;
import com.example.entity.Platoon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArmyMapper {
    public List<Platoon> GetPlatoon();

    public Platoon GetPlatoonById(Integer platoon_id);

    public List<Base> RequestBase();

    public Platoon GetPlatoonByName(String platoon_name);

    public void IncreasePlatoon(String platoon_name);

    public void IncreaseArmy(Army army);

    public Army GetArmyByNameAndPlatooId(@Param("army_name") String army_name, @Param("platoon_id") Integer platoon_id);

    public List<Army> GetArmyByPlatoonId(@Param("platoon_id") Integer platoon_id);

    public List<Army> GetArmyBySchemeId(@Param("scheme_id") Integer scheme_id);

    public Army GetArmyByArmyId(@Param("army_id") Integer army_id);

    public void AddActionGroup(Action_Group action_group);

    public Integer GetActionGroupId(Action_Group action_group);

    public List<Action_Group> GetActionGroupBySchemeId(Integer scheme_id);

    public List<Army> RequestGroupArmy(Integer action_group_id);

    public List<Army> RequestArmyByType(@Param("platoon_id") Integer platoon_id, @Param("army_type") String army_type);

    public void DeleteActionGroup(@Param("action_group_id") Integer action_group_id);

    public Base GetBaseByName(String base_name);

    public void IncreaseBase(String base_name);
}
