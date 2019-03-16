package com.example.mappers;

import com.example.entity.Special_Case;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Special_CaseMapper {

    public List<Special_Case> GetSpecialCase(Special_Case special_case);

}
