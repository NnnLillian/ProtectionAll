package com.example.service.impl;

import com.example.entity.Category_Case;
import com.example.entity.Environment;
import com.example.entity.Special_Case;
import com.example.mappers.EnvironmentMapper;
import com.example.mappers.Special_CaseMapper;
import com.example.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Special_Case> GetSpecialCase(String type, Integer lowLevel, Integer highLevel) {
        return special_caseMapper.GetEnvironmentSpecialCase(type, lowLevel, highLevel);
    }


    @Override
    public List<Category_Case> GetCategoryCase(Integer equipment_id, String case_position) {

        return special_caseMapper.GetCategoryCase(equipment_id, case_position);
    }

    @Override
    public List<Double> GetResultByType(String type, List<Environment> environmentList) {
        List<Double> result = new ArrayList<>();
        for (Environment e : environmentList) {
            switch (type) {
                case "temperature":
                    result.add(e.getTemperature());
                    break;
                case "rainfall":
                    result.add(e.getRainfall());
                    break;
                case "snowfall":
                    result.add(e.getSnowfall());
                    break;
                case "sunshine":
                    result.add(e.getSunshine());
                    break;
                case "wind_level":
                    result.add(e.getWind_level());
                    break;
                case "pressure":
                    result.add(e.getPressure());
                    break;
                case "corrosion":
                    result.add(e.getCorrosion());
                    break;
                case "humidity":
                    result.add(e.getHumidity());
                    break;
                default:
                    System.out.println("缺少水文信息类型");
            }
        }

        return result;
    }

    @Override
    public List<Double> GetTypeStandard(String type){
        List<Double> standard = new ArrayList<>();
        switch (type) {
            case "temperature":
                standard.add(5.0);
                standard.add(12.0);
                break;
            case "rainfall":
                standard.add(0.1);
                standard.add(1.0);
                break;
            case "snowfall":
                standard.add(0.1);
                standard.add(1.1);
                break;
            case "sunshine":
                standard.add(6.0);
                standard.add(11.0);
                break;
            case "wind_level":
                standard.add(2.0);
                standard.add(3.0);
                break;
            case "pressure":
                standard.add(700.0);
                standard.add(900.0);
                break;
            case "corrosion":
                standard.add(20.0);
                standard.add(80.0);
                break;
            case "humidity":
                standard.add(0.20);
                standard.add(0.30);
                break;
            default:
                System.out.println("缺少水文信息类型");
        }
        return standard;
    }
}
