package com.example.mappers;

import com.example.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EvaluateMapper {
    public List<Double> GetEvaluateNumbersBySchemeId(Integer scheme_id);
}
