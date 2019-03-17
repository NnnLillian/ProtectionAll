package com.example.service.impl;

import com.example.entity.*;
import com.example.mappers.ArmyMapper;
import com.example.mappers.GroupMapper;
import com.example.mappers.LocationMapper;
import com.example.mappers.SchemeMapper;
import com.example.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Platoon> RequestPlatoon() {
        return armyMapper.GetPlatoon();
    }

    @Override
    public List<Army> RequestArmy(Integer platoon_id) {
        return armyMapper.GetArmyByPlatoonId(platoon_id);
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
    public List<Scheme_Army> GetSchemeArmyBySchemeId(Integer scheme_id) {
        return schemeMapper.GetSchemeArmyBySchemeId(scheme_id);
    }

    @Override
    public List<Equipment> GetEquipmentBySchemeId(Integer scheme_id) {
        return schemeMapper.GetSchemeEquipmentBySchemeId(scheme_id);
    }

    @Override
    public Integer AddGroupIntoScheme(Group group) {
        Group group1 = groupMapper.GetGroupBySchemeId(group.getScheme_id());
        if (group1 != null) {
            System.out.println("group error");
            return null;
        } else {
            schemeMapper.AddGroupIntoScheme(group);
            return groupMapper.GetGroupBySchemeId(group.getScheme_id()).getGroup_id();
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
            for (int i = 0; i < team_departments.size(); i++) {
                Team_Department team_department = team_departments.get(i);
                team_department.setTeam_id(team_id1);
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
    public List<Team> GetTeamBySchemeIdAndTeamType(Integer scheme_id, String team_type) {
        return groupMapper.GetTeamBySchemeIdAndTeamType(scheme_id, team_type);
    }
}
