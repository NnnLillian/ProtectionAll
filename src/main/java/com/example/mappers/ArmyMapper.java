package com.example.mappers;

import com.example.entity.Army;
import com.example.entity.Platoon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArmyMapper {
    public List<Platoon> GetPlatoon();
    public List<Army> GetArmyByPlatoonId(@Param("platoon_id") Integer platoon_id);
    public List<Army> GetArmyBySchemeId(@Param("scheme_id") Integer scheme_id);
}
