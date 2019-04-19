package com.example.mappers;

import com.example.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Similar_SchemeMapper {
    //    选出作战任务相似的schemeId
    public Integer GetSimilarActionSchemeId(@Param("combat_direction") Integer combat_direction, @Param("scheme_type") Integer scheme_type);

    //    选出保障任务相似的schemeId
    public Integer GetSimilarSafeguardSchemeId(@Param("combat_direction") Integer combat_direction, @Param("scheme_type") Integer scheme_type);

    //    根据schemeId选出作战部队规模
    public Integer GetSchemeArmyCountBySchemeId(Integer scheme_id);
}
