package com.example.controller;

import com.example.entity.Category;
import com.example.service.EquipmentService;
import com.example.util.ExcelUtil;
import javafx.concurrent.Worker;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class AdminUpLoadController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/category")
    public String InputCategoryMsg() {
        return "admin_form";
    }

    @RequestMapping(value = "/importFile", method = {RequestMethod.POST})
    public List<Map<String, String>> UploadCategoryMsg(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String contentPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println(contentPath);
        File excelFile = new File(contentPath + fileName);
        if (excelFile.exists()) {
            excelFile.delete();
        }
        file.transferTo(excelFile);
        // 解析
        InputStream in = new FileInputStream(excelFile);
        Workbook workbook = ExcelUtil.readExcel(in);
        List<Map<String, String>> list = ExcelUtil.analysisWorkbook(workbook);
        System.out.println(list);
        return list;
/////////////////////////////返回解析得到的list/////////////////////////////////////////////////
////////////////////////////再去加入已知数据/////////////////////////////////////
//        for (Map<String, String> map : list) {
//            map.put("platoon_id","1");
//            for (Map.Entry<String, String> entry : map.entrySet()) {
//                System.out.println(entry.getKey() + ":" + entry.getValue());
//            }
//        }
    }

    @RequestMapping(value = "/IncreaseCategoryMsg",method = {RequestMethod.POST})
    @ResponseBody
    public Integer IncreaseCategory(@RequestBody Category category){
        // flag:1表示成功；2表示失败；
        Integer flag = equipmentService.IncreaseCategory(category);
        return flag;
    }
}
