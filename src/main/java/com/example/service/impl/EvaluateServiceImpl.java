package com.example.service.impl;

import com.example.entity.Evaluate;
import com.example.mappers.EvaluateMapper;
import com.example.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public List<Evaluate> RequestEvaluateItems(String MainType) {
        return evaluateMapper.RequestEvaluateItems(MainType);
    }
}
