package com.example.controller;

import com.example.entity.Army;
import com.example.entity.Category;
import com.example.entity.Platoon;
import com.example.service.EquipmentService;
import com.example.service.PeopleService;
import com.example.service.SchemeService;
import com.example.util.ExcelUtil;
import com.example.util.JsonBuilder;
import com.example.util.JsonPaser;
import javafx.concurrent.Worker;
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
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class AdminUpLoadController {

    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private SchemeService schemeService;
    @Autowired
    private PeopleService peopleService;

    @GetMapping("/category")
    public String InputCategoryMsg() {
        return "admin_form";
    }

    @GetMapping("/army")
    public String InputArmyMsg(Model model){
        List<Platoon> platoon_list = schemeService.RequestPlatoon();
        model.addAttribute("platoon_list", platoon_list);
        return "admin_army";
    }

    @GetMapping("/people")
    public String InputPeopleMsg(Model model){
        List<Platoon> platoon_list = schemeService.RequestPlatoon();
        model.addAttribute("platoon_list", platoon_list);
        return "admin_people";
    }

    @RequestMapping("/findArmyList")
    @ResponseBody
    public List<Army> findArmyList(@RequestParam("platoon_id") Integer platoon_id){
        System.out.println("findarmy");
        List<Army> army_list=schemeService.RequestArmy(platoon_id);
        return army_list;
    }

    @RequestMapping(value = "/importFile", method = {RequestMethod.POST})
    @ResponseBody
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
/////////////////////////////返回解析得到的list/////////////////////////////////////////////////////
////////////////////////////再去加入已知数据////////////////////////////////////////////////////////
////////////////////////////注释中为在后台加入已知数据///////////////////////////////////////////////
//        for (Map<String, String> map : list) {
//            map.put("platoon_id","1");
//            for (Map.Entry<String, String> entry : map.entrySet()) {
//                System.out.println(entry.getKey() + ":" + entry.getValue());
//            }
//        }
    }

    @RequestMapping(value = "/IncreaseCategoryMsg", method = {RequestMethod.POST})
    @ResponseBody
    public Integer IncreaseCategory(@RequestBody List<Category> category) {
        // flag:1表示成功；2表示失败；
        for (int i = 0; i < category.size(); i++) {
            Integer flag = equipmentService.IncreaseCategory(category.get(i));
            if (flag != 1) {
                return flag;
            }
        }
        return 1;
    }

    @RequestMapping(value = "/IncreaseBaseMsg", method = {RequestMethod.POST})
    @ResponseBody
    public Integer IncreaseBase(@RequestBody String baseName){
        Integer flag = peopleService.IncreaseBase(baseName);
        return flag;
    }

    @RequestMapping(value = "/IncreasePlatoonMsg", method = {RequestMethod.POST})
    @ResponseBody
    public Integer IncreasePlatoon(@RequestBody String platoonName){
        Integer flag = peopleService.IncreasePlatoon(platoonName);
        return flag;
    }

    @RequestMapping(value = "/IncreaseArmyMsg", method = {RequestMethod.POST})
    @ResponseBody
    public Integer IncreaseArmy(@RequestBody Army army){
        Integer flag = peopleService.IncreaseArmy(army);
        return flag;
    }
}
