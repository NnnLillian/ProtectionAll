package com.example.mappers;

import com.example.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMapper {
    public Group GetGroupByGroupId(Integer group_id);

    public Group GetSchemeGroupBySchemeIdAndGroupType(@Param("scheme_id") Integer scheme_id, @Param("group_type") String group_type);

    public List<Team> GetTeamBySchemeIdAndTeamType(@Param("scheme_id") Integer scheme_id, @Param("team_type") String team_type);

    public List<Team_Department> GetTeamByTeamId(Integer team_id);

    public void AddTeam(Team team);

    public void AddDepartment(Department department);

    public void AddTeamDepartment(Team_Department team_department);

    public Integer GetDepartmentLastItem();

    public Department GetDepartmentById(Integer department_id);

    public void AddTeamCategory(Team_Category team_category);

    public Integer GetTeamId(Team team);

    public List<Team> GetTeamByGroupId(Integer group_id);

    public void DeleteTeam(Integer team_id);

    public void DeleteTeamDepartment(Integer team_id);

    public void DeleteTeamCategory(Integer team_id);
}
