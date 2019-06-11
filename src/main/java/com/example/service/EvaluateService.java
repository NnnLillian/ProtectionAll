package com.example.service;

import com.example.entity.Evaluate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EvaluateService {
    List<Evaluate> RequestEvaluateItems(List<String> MainType);
}
