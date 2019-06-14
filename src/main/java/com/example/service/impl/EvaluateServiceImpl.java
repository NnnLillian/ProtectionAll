package com.example.service.impl;

import com.example.entity.Evaluate;
import com.example.entity.Scheme;
import com.example.entity.Scheme_Evaluate;
import com.example.mappers.EvaluateMapper;
import com.example.mappers.SchemeMapper;
import com.example.service.EvaluateService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;
    @Autowired
    private SchemeMapper schemeMapper;

    @Override
    public List<Evaluate> RequestEvaluateItems(String MainType) {
        return evaluateMapper.RequestEvaluateItems(MainType);
    }

    @Override
    public List<Scheme_Evaluate> RequestSchemeToEvaluate(Integer proficientNumber) {
//        获得达到指定评估次数的schemeId
        List<Integer> schemeIds = evaluateMapper.GetSchemeIdWhereEvaluateCountMore(proficientNumber);
        List<Integer> allSchemeIds = schemeMapper.RequestSchemeId();
//        存储为集合，取他们的差集。
        Collection<Integer> A = new ArrayList<>(schemeIds);
        Collection<Integer> B = new ArrayList<>(allSchemeIds);
        B.removeAll(A);
        List<Scheme_Evaluate> schemeEvaluateList=new ArrayList<>();
        for (Integer schemeId:B){
            Scheme_Evaluate schemeEvaluate = new Scheme_Evaluate();
            Scheme scheme = schemeMapper.GetSchemeBySchemeID(schemeId);
            schemeEvaluate.setScheme_id(schemeId);
            schemeEvaluate.setScheme_name(scheme.getScheme_name());
            schemeEvaluate.setEvaluate_count(evaluateMapper.GetEvaluateCountsBySchemeId(schemeId));
            schemeEvaluate.setEvaluate_result(scheme.getEvaluate_result());
            schemeEvaluateList.add(schemeEvaluate);
        }

        return schemeEvaluateList;
    }

    @Override
    public Integer GetEvaluateCountsBySchemeId(Integer schemeId){
        return evaluateMapper.GetEvaluateCountsBySchemeId(schemeId);
    }
}
