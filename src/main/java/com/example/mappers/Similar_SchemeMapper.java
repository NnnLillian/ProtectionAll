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
}
