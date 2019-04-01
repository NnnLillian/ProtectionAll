package com.example.service.impl;

import com.example.entity.Category_Case;
import com.example.entity.Environment;
import com.example.entity.Special_Case;
import com.example.mappers.EnvironmentMapper;
import com.example.mappers.Special_CaseMapper;
import com.example.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnvironmentServiceImpl implements EnvironmentService {
    @Autowired
    private EnvironmentMapper environmentMapper;
    @Autowired
    private Special_CaseMapper special_caseMapper;
    @Override
    public List<Environment> GetEnvironment(Integer location_id) {

        return environmentMapper.GetEnvironment(location_id);
    }

    @Override
    public List<Environment> GetEnvironmentByCasePosition(String case_position) {
        return environmentMapper.GetEnvironmentByCasePosition(case_position);
    }

    @Override
    public List<Special_Case> GetSpecialCase(Special_Case special_case) {
        return special_caseMapper.GetSpecialCase(special_case);
    }


    @Override
    public List<Category_Case> GetCategoryCase(Integer equipment_id, String case_position) {

        return special_caseMapper.GetCategoryCase(equipment_id,case_position);
    }
}
