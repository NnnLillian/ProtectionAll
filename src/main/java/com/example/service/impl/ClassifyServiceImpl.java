package com.example.service.impl;

import com.example.entity.Special_Case;
import com.example.mappers.Special_CaseMapper;
import com.example.service.ClassifyService;
import com.example.util.Classify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private Special_CaseMapper special_caseMapper;

    @Override
    public Integer AddSpecialCase(Special_Case special_Case, int n) {
//        根据描述，进行分类，生成case_type
        Classify classify = new Classify();
        String type = classify.GetSpecialType(special_Case.getDescription(), n);
        special_Case.setCase_type(type);
        if (special_caseMapper.GetSpecialCase(special_Case).size() == 0) {
            special_caseMapper.AddSpecialCase(special_Case);
            Integer caseId = special_Case.getCase_id();
            return caseId;
        } else
            return 0;
    }

    @Override
    public void AddEnvironmentSpecialCase(Special_Case special_case) {
//        根据描述，进行分类，得到关于环境水文信息的caseType
        Classify classify = new Classify();
        String caseContent = special_case.getDescription();
        String environmentType = classify.GetSpecialType(caseContent);
        String caseLevelStr = classify.GetSpecialIntensity(caseContent);
        System.out.println(caseLevelStr);
        Integer caseLevel = Integer.parseInt(caseLevelStr);
        Integer caseId = special_case.getCase_id();
        if (special_caseMapper.GetEnvironmentCaseByCaseId(caseId) == null) {
            special_caseMapper.AddEnvironmentCase(environmentType, caseId, caseLevel);
        }
    }
}
