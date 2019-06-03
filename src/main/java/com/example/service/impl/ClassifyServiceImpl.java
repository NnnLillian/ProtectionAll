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
    public boolean AddSpecialCase(Special_Case special_Case, int n) {
//        根据描述，进行分类，生成case_type
        Classify classify = new Classify();
        String type = classify.GetSpecialType(special_Case.getDescription(), n);
        special_Case.setCase_type(type);
        if (special_caseMapper.GetSpecialCase(special_Case).size()==0)
        {
            special_caseMapper.AddSpecialCase(special_Case);
            return true;
        }
        else
            return false;
    }
}
