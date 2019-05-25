package com.example.mappers;

import com.example.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Similar_SchemeMapper {
    //    选出作战任务相似的schemeId
    public List<Integer> GetSimilarActionSchemeId(@Param("combat_direction") String combat_direction, @Param("scheme_type") String scheme_type, @Param("scheme_begin_month") String scheme_begin_month, @Param("scheme_end_month") String scheme_end_month);

    //    选出保障任务相似的schemeId
    public List<Integer> GetSimilarSafeguardSchemeId(@Param("carry_method") Integer carry_method, @Param("safeguard_mode") Integer safeguard_mode);

    //    根据schemeId选出作战部队规模
    public Integer GetSchemeArmyCountBySchemeId(Integer scheme_id);

    //    在group_info中插入相似方案的group信息
    public void AddSchemeSimilarGroup(@Param("SimilarId") Integer SimilarId, @Param("scheme_id") Integer scheme_id);

    //    在department_info中插入相似方案的department信息
    public void AddSchemeSimilarDepartment(Integer SimilarDepartmentId);

    //    在team_department_info中插入相似方案的department信息
    public void AddSchemeSimilarTeamDepartment(@Param("similarDepartmentId") Integer similarDepartmentId,@Param("team_id") Integer team_id, @Param("department_id") Integer department_id);

    //    在team_category_info中插入相似方案的teamCategory信息
    public void AddSchemeSimilarTeamCategory(@Param("similarTeamId") Integer similarTeamId, @Param("team_id") Integer team_id);
}
