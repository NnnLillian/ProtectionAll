package com.example.service;

import com.example.entity.Evaluate;
import com.example.entity.Scheme_Evaluate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EvaluateService {
    List<Evaluate> RequestEvaluateItems(String MainType);

    List<Scheme_Evaluate> RequestSchemeToEvaluate(Integer proficientNumber);

    Integer GetEvaluateCountsBySchemeId(Integer schemeId);
}
