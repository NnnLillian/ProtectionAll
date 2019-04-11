package com.example.service.impl;

import com.example.entity.*;
import com.example.mappers.*;
import com.example.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchemeServiceImpl implements SchemeService {
    @Autowired
    private ArmyMapper armyMapper;
    @Autowired
    private SchemeMapper schemeMapper;
    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public List<Platoon> RequestPlatoon() {
        return armyMapper.GetPlatoon();
    }

    @Override
    public List<Base> RequestBase() {
        return armyMapper.RequestBase();
    }

    @Override
    public List<Army> RequestArmy(Integer platoon_id) {
        return armyMapper.GetArmyByPlatoonId(platoon_id);
    }

    @Override
    public List<Army> RequestGroupArmy(Integer action_group_id) {
        return armyMapper.RequestGroupArmy(action_group_id);
    }

    @Override
    public List<Army> RequestArmyByType(Integer platoon_id, String army_type) {
        return armyMapper.RequestArmyByType(platoon_id, army_type);
    }

    @Override
    public List<TeamStr> RequestTeamBySchemeIdAndType(Integer scheme_id, String group_type) {
        Group group = groupMapper.GetSchemeGroupBySchemeIdAndGroupType(scheme_id, group_type);
        Integer groupId = group.getGroup_id();
        String groupName = group.getGroup_name();
        List<Team> teamList = groupMapper.GetTeamByGroupId(groupId);
        List<TeamStr> teamStrList = new ArrayList<>();
        for (int i = 0; i < teamList.size(); i++) {
            TeamStr teamStr = new TeamStr();
            teamStr.setTeam_id(teamList.get(i).getTeam_id());
            String teamName = "第" + teamList.get(i).getTeam_name() + groupName;
            teamStr.setTeam_name(teamName);
            teamStr.setGroup_name(groupName);
            String armyIds = teamList.get(i).getArmy_id();
            String[] armyId = armyIds.split(",");
            String armyNames = "";
            for (int j = 0; j < armyId.length; j++) {
                String armyName = armyMapper.GetArmyByArmyId(Integer.parseInt(armyId[j])).getArmy_name();
                armyNames = armyName + "、" + armyNames;
            }
            teamStr.setArmy_name(armyNames);
            teamStrList.add(teamStr);
        }
        return teamStrList;
    }

    @Override
    public List<Department> RequestTeamDepartmentByTeamId(Integer team_id) {
        List<Team_Department> team_departmentList = groupMapper.GetTeamByTeamId(team_id);
        List<Department> departmentStrs = new ArrayList<>();
        for (int i = 0; i < team_departmentList.size(); i++) {
            Department department = groupMapper.GetDepartmentById(team_departmentList.get(i).getDepartment_id());
            departmentStrs.add(department);
        }
        return departmentStrs;
    }

    @Override
    public List<People> RequestPeopleByDepartmentId(Integer department_id) {
        Team_Department team_department = groupMapper.GetTeamDepartmentByDepartmentId(department_id);
        String peopleStrs = team_department.getDepartment_people();
        String peopleStr = peopleStrs.substring(1, peopleStrs.length() - 1);
        String[] peopleListStr = peopleStr.split(",");
        List<People> peopleList = new ArrayList<>();
        for (int i = 0; i < peopleListStr.length; i++) {
            Integer peopleId = Integer.parseInt(peopleListStr[i]);
            peopleList.add(peopleMapper.GetPeopleByPeopleID(peopleId));
        }
        return peopleList;
    }

    @Override
    public List<Category> RequestTeamCategoryByTeamId(Integer team_id) {
        List<Team_Category> team_categoryList = groupMapper.GetTeamCategoryByTeamId(team_id);
        List<Category> categoryList = new ArrayList<>();
        for (int i = 0; i < team_categoryList.size(); i++) {
            Category category = equipmentMapper.GetCategoryById(team_categoryList.get(i).getCategory_id());
            category.setCategory_number(team_categoryList.get(i).getCategory_number());
            categoryList.add(category);
        }
        return categoryList;
    }

    @Override
    public Scheme GetSchemeBySchemeID(Integer scheme_id) {
        return schemeMapper.GetSchemeBySchemeID(scheme_id);
    }

    @Override
    public List<Army> GetArmyBySchemeID(Integer scheme_id) {
        return armyMapper.GetArmyBySchemeId(scheme_id);
    }

    @Override
    public Integer AddScheme(Scheme scheme) {
        Scheme scheme1 = schemeMapper.GetSchemeBySchemeCode(scheme.getScheme_code());
        if (scheme1 != null) {
            return null;
        } else {
            schemeMapper.AddScheme(scheme);
            return schemeMapper.GetSchemeBySchemeCode(scheme.getScheme_code()).getScheme_id();
        }
    }

    @Override
    public Integer GetLocationID(double longitude, double latitude) {
        Integer locationID = locationMapper.GetLocationID(longitude, latitude);
        if (locationID != null)
            return locationID;
        else {
            Location location = new Location(null, longitude, latitude);
            locationMapper.AddLocation(location);
            locationID = locationMapper.GetLocationID(longitude, latitude);
            return locationID;
        }
    }

    @Override
    public void AddSchemeArmy(Scheme_Army scheme_army) {
        Scheme_Army schemeArmy = schemeMapper.GetSchemeArmyNumber(scheme_army);
        if (schemeArmy != null) {
            schemeMapper.ModifySchemeArmy(scheme_army);
        } else {
            schemeMapper.AddSchemeArmy(scheme_army);
        }
    }

    @Override
    public void AddActionGroup(Action_Group action_group) {
        Integer id = GetActionGroupId(action_group);
        if (id == null) {
            armyMapper.AddActionGroup(action_group);
        }
    }

    @Override
    public void AddSchemeSafeGuard(Scheme_Safeguard scheme_safeguard) {
        schemeMapper.AddSchemeSafeGuard(scheme_safeguard);
    }

    @Override
    public List<Scheme_Army> GetSchemeArmyBySchemeId(Integer scheme_id) {
        return schemeMapper.GetSchemeArmyBySchemeId(scheme_id);
    }

    @Override
    public List<Equipment> GetEquipmentBySchemeId(Integer scheme_id) {
        return schemeMapper.GetSchemeEquipmentBySchemeId(scheme_id);
    }

    @Override
    public Integer AddGroupIntoScheme(Group group) {
        Group group1 = groupMapper.GetSchemeGroupBySchemeIdAndGroupType(group.getScheme_id(), group.getGroup_type());
        if (group1 != null) {
            System.out.println("group error");
//            如果该保障组已经存在，则返回这个已经存在的保障组ID
            return group1.getGroup_id();
        } else {
            schemeMapper.AddGroupIntoScheme(group);
            return groupMapper.GetSchemeGroupBySchemeIdAndGroupType(group.getScheme_id(), group.getGroup_type()).getGroup_id();
        }

    }

    @Override
    public String AddTeam(Team team) {
        Integer team_id = groupMapper.GetTeamId(team);
        if (team_id != null) {
            return "{\"tips\": \"error\"}";
        } else {
            groupMapper.AddTeam(team);
            Integer team_id1 = groupMapper.GetTeamId(team);
            List<Team_Category> team_categories = team.getTeam_category_list();
            for (int i = 0; i < team_categories.size(); i++) {
                Team_Category team_category = team_categories.get(i);
                team_category.setTeam_id(team_id1);
                groupMapper.AddTeamCategory(team_category);
            }
            List<Team_Department> team_departments = team.getTeam_department_list();
            List<Department> departments = team.getDepartmentList();
//            其实 departments.size() = team_departments.size()
            for (int i = 0; i < team_departments.size(); i++) {
                Team_Department team_department = team_departments.get(i);
                team_department.setTeam_id(team_id1);
                Department department = departments.get(i);
                groupMapper.AddDepartment(department);
                Integer did = groupMapper.GetDepartmentLastItem();
                team_department.setDepartment_id(did);
                groupMapper.AddTeamDepartment(team_department);
            }
            System.out.println("{\"tips\": \"success\",\"team_id\": " + team_id1 + "}");
            return "{\"tips\": \"success\",\"team_id\": " + team_id1 + "}";
        }
    }

    @Override
    public void DeleteTeam(Integer team_id) {
        groupMapper.DeleteTeamCategory(team_id);
        groupMapper.DeleteTeamDepartment(team_id);
        groupMapper.DeleteTeam(team_id);
    }

    @Override
    public void DeleteActionGroup(Integer action_group_id) {
        schemeMapper.DeleteSchemeActionGroup(action_group_id);
        armyMapper.DeleteActionGroup(action_group_id);
    }

    @Override
    public List<Team> GetTeamBySchemeIdAndTeamType(Integer scheme_id, String team_type) {
        return groupMapper.GetTeamBySchemeIdAndTeamType(scheme_id, team_type);
    }

    @Override
    public Integer GetActionGroupId(Action_Group action_group) {
        return armyMapper.GetActionGroupId(action_group);
    }

    @Override
    public List<Action_Group> GetActionGroups(Integer scheme_id) {
        List<Action_Group> groups = armyMapper.GetActionGroupBySchemeId(scheme_id);

        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).setLocation("经度：" + groups.get(i).getLongitude() + ", 纬度：" + groups.get(i).getLatitude());
        }
        return groups;
    }
}
