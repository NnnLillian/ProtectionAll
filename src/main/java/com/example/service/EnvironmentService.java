package com.example.service;

import com.example.entity.Environment;
import com.example.entity.Special_Case;

import java.util.List;

public interface EnvironmentService {

    public List<Environment> GetEnvironment(Integer location_id);

    public List<Special_Case> GetSpecialCase(Special_Case special_case);
}
