package com.example.mappers;

import com.example.entity.Category_Case;
import com.example.entity.Special_Case;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Special_CaseMapper {

    public List<Special_Case> GetSpecialCase(Special_Case special_case);

    public List<Category_Case> GetCategoryCase(@Param("equipment_id") Integer equipment_id, @Param("case_position") String case_position);

}
