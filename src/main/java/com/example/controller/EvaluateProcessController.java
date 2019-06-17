package com.example.controller;

import com.example.entity.*;
import com.example.service.EquipmentService;
import com.example.service.EvaluateService;
import com.example.service.PeopleService;
import com.example.service.SchemeService;
import com.example.util.ExcelUtil;
import com.example.util.JsonBuilder;
import com.example.util.JsonPaser;
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
import java.util.ArrayList;
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
    @Autowired
    private EvaluateService evaluateService;

    private JsonBuilder jsonBuilder = new JsonBuilder();

    private JsonPaser jsonPaser = new JsonPaser();


    @GetMapping("/process/{schemeId}")
    public String evaluateProcess(@PathVariable("schemeId") Integer schemeId, Model model) {
        model.addAttribute("schemeId", schemeId);
        return "evaluate_process";
    }

    @GetMapping("/schemeList")
    public String evaluateSchemeList() {
        return "evaluate_schemeList";
    }

    @ResponseBody
    @RequestMapping(value = "/getItems", method = {RequestMethod.GET})
    public String GetEvaluateItems(@RequestParam("type") String type) {
        List<Evaluate> evaluateList = evaluateService.RequestEvaluateItems(type);

        return jsonBuilder.buildEvaluateItems(evaluateList);
    }

    @ResponseBody
    @RequestMapping(value = "/getSchemeList", method = {RequestMethod.GET})
    public String GetSchemeList() {
//        表示需要8位专家评估才算结束
        Integer number = 7;
        List<Scheme_Evaluate> schemeList = evaluateService.RequestSchemeToEvaluate(number);
        if (schemeList.size() != 0) {
            return jsonBuilder.buildSchemeEvaluate(schemeList);
        } else {
            return "{\"schemeEvaluate\":" + "\"null\"" + "}";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/AddResult", method = {RequestMethod.POST})
    public void AddEvaluateResult(@RequestBody String jsonStr) {
        System.out.println(jsonStr);
        Scheme_Evaluate schemeEvaluate = jsonPaser.ParseSchemeEvaluate(jsonStr);
        Double avgResult = schemeService.AddSchemeEvaluate(schemeEvaluate);
//        将平均值放入schemeInfo中
        Integer schemeId = schemeEvaluate.getScheme_id();
        schemeService.UpdateSchemeEvaluateResult(avgResult, schemeId);
    }


}
