package com.example.service;

import com.example.entity.Category_Case;
import com.example.entity.Environment;
import com.example.entity.Special_Case;

import java.util.List;

public interface EnvironmentService {

    public List<Environment> GetEnvironment(Integer location_id);

    public List<Environment> GetEnvironmentByCasePosition(String case_position);

    public List<Special_Case> GetSpecialCase(Special_Case special_case);

    public List<Category_Case> GetCategoryCase(Integer equipment_id, String case_position);
}
