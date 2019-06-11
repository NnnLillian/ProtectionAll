package com.example.mappers;

import com.example.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateMapper {
    public List<Evaluate> GetEvaluateItemsByMainType(String evaluate_main_type);

    public List<Double> GetEvaluateNumbersBySchemeId(Integer scheme_id);

    List<Evaluate> RequestEvaluateItems(List<String> evaluate_main_type);
}
