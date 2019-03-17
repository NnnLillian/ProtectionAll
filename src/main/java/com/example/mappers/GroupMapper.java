package com.example.mappers;

import com.example.entity.Group;
import com.example.entity.Team;
import com.example.entity.Team_Category;
import com.example.entity.Team_Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMapper {
    public Group GetGroupByGroupId(Integer group_id);

    public Group GetGroupBySchemeId(Integer scheme_id);

    public void AddTeam(Team team);

    public void AddTeamDepartment(Team_Department team_department);

    public void AddTeamCategory(Team_Category team_category);

    public Integer GetTeamId(Team team);

    public void DeleteTeam(Integer team_id);

    public void DeleteTeamDepartment(Integer team_id);

    public void DeleteTeamCategory(Integer team_id);
}
