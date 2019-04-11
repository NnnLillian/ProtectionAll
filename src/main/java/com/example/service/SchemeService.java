package com.example.service;

import com.example.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchemeService {

    public List<Platoon> RequestPlatoon();

    public List<Base> RequestBase();

    public List<Army> RequestArmy(Integer platoon_id);

    public List<Army> RequestGroupArmy(Integer action_group_id);

    public List<Army> RequestArmyByType(Integer platoon_id, String army_type);

    public List<TeamStr> RequestTeamBySchemeIdAndType(Integer scheme_id, String group_type);

    //  获得保障小分队内的人员职位信息
    public List<Department> RequestTeamDepartmentByTeamId(Integer team_id);

    //  获得保障小分队内的人员详细信息
    public List<People> RequestPeopleByDepartmentId(Integer department_id);

    //  获得保障小分队内的装备详细信息
    public List<Category> RequestTeamCategoryByTeamId(Integer team_id);

    public Scheme GetSchemeBySchemeID(Integer scheme_id);

    public List<Army> GetArmyBySchemeID(Integer scheme_id);

    //如果添加成功，则返回scheme_id；失败则返回null
    public Integer AddScheme(Scheme scheme);

    public Integer GetLocationID(double longitude, double latitude);

    public void AddSchemeArmy(Scheme_Army scheme_army);

    public void AddActionGroup(Action_Group action_group);

    public void AddSchemeSafeGuard(Scheme_Safeguard scheme_safeguard);

    public List<Scheme_Army> GetSchemeArmyBySchemeId(Integer scheme_id);

    public List<Equipment> GetEquipmentBySchemeId(Integer scheme_id);

    //如果添加成功，则返回group_id；失败则返回null
    public Integer AddGroupIntoScheme(Group group);

    public String AddTeam(Team team);

    public void DeleteTeam(Integer team_id);

    public void DeleteActionGroup(Integer action_group_id);

    public List<Team> GetTeamBySchemeIdAndTeamType(Integer scheme_id, String team_type);

    public Integer GetActionGroupId(Action_Group action_group);

    public List<Action_Group> GetActionGroups(Integer scheme_id);
}
