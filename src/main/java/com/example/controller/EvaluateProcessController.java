package com.example.controller;

import com.example.entity.*;
import com.example.service.EquipmentService;
import com.example.service.PeopleService;
import com.example.service.SchemeService;
import com.example.util.ExcelUtil;
import net.sf.cglib.beans.BeanMap;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/evaluate")
public class EvaluateProcessController {

    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private SchemeService schemeService;
    @Autowired
    private PeopleService peopleService;


    @GetMapping("process")
    public String evaluateProcess() {
        return "evaluate_process";
    }

    @ResponseBody
    @RequestMapping(value = "/GetItems",method = {RequestMethod.GET})
    public String GetEvaluateItems(){
        return "";
    }


}
