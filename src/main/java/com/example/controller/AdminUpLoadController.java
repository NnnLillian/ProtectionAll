package com.example.controller;

import com.example.entity.*;
import com.example.service.EquipmentService;
import com.example.service.PeopleService;
import com.example.service.SchemeService;
import com.example.util.ExcelUtil;
import com.example.util.JsonBuilder;
import com.example.util.JsonPaser;
import javafx.concurrent.Worker;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import net.sf.cglib.beans.BeanMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public String InputArmyMsg(Model model) {
        List<Platoon> platoon_list = schemeService.RequestPlatoon();
        model.addAttribute("platoon_list", platoon_list);
        return "admin_army";
    }

    @GetMapping("/people")
    public String InputPeopleMsg(Model model) {
        List<Platoon> platoon_list = schemeService.RequestPlatoon();
        model.addAttribute("platoon_list", platoon_list);
        return "admin_people";
    }

    @RequestMapping("/findArmyList")
    @ResponseBody
    public List<Army> findArmyList(@RequestParam("platoon_id") Integer platoon_id) {
        System.out.println("findarmy");
        List<Army> army_list = schemeService.RequestArmy(platoon_id);
        return army_list;
    }

    @GetMapping("/equipment")
    public String InputEquipmentMsg(Model model) {
        List<Platoon> platoon_list = schemeService.RequestPlatoon();
        model.addAttribute("platoon_list", platoon_list);
        List<Category> categoryActionList = equipmentService.RequestCategoryByType("action");
        List<Category> categoryProtectList = equipmentService.RequestCategoryByType("protect");
        categoryActionList.addAll(categoryProtectList);     //此时的categoryActionList包括了action和protect类型装备
        model.addAttribute("category_list", categoryActionList);
        return "admin_equipment";
    }

    @GetMapping("/device")
    public String InputDeviceMsg() {
        return "admin_device";
    }

    @GetMapping("/importFile")
    public String importFile() {
        return "importFile";
    }

    @GetMapping("/element")
    public String InputElementMsg(Model model) {
        List<Category> categoryActionList = equipmentService.RequestCategoryByType("action");
        List<Category> categoryProtectList = equipmentService.RequestCategoryByType("protect");
        categoryActionList.addAll(categoryProtectList);     //此时的categoryActionList包括了action和protect类型装备
        model.addAttribute("category_list", categoryActionList);
        return "admin_element";
    }

    @RequestMapping(value = "/importFile", method = {RequestMethod.POST})
    @ResponseBody
    public List<Map<String, Object>> UploadCategoryMsg(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
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
        List<Map<String, Object>> list = ExcelUtil.analysisWorkbook(workbook);
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
    public Integer IncreaseBase(@RequestBody String baseName) {
        Integer flag = peopleService.IncreaseBase(baseName);
        return flag;
    }

    @RequestMapping(value = "/IncreasePlatoonMsg", method = {RequestMethod.POST})
    @ResponseBody
    public Integer IncreasePlatoon(@RequestBody String platoonName) {
        Integer flag = peopleService.IncreasePlatoon(platoonName);
        return flag;
    }

    @RequestMapping(value = "/IncreaseArmyMsg", method = {RequestMethod.POST})
    @ResponseBody
    public Integer IncreaseArmy(@RequestBody Army army) {
        Integer flag = peopleService.IncreaseArmy(army);
        return flag;
    }

    @RequestMapping(value = "/IncreasePeopleMsg", method = {RequestMethod.POST})
    @ResponseBody
    public Integer IncreasePeople(@RequestBody List<People> people) {
        for (int i = 0; i < people.size(); i++) {
            Integer flag = peopleService.AddPeople(people.get(i));
            if (flag != 1) {
                return flag;
            }
        }
        return 1;
    }

    @RequestMapping(value = "/IncreaseEquipmentMsg", method = {RequestMethod.POST})
    @ResponseBody
    public Integer IncreaseEquipment(@RequestBody List<Equipment> equipment) {
        for (int i = 0; i < equipment.size(); i++) {
            Integer flag = equipmentService.IncreaseEquipment(equipment.get(i));
            if (flag != 1) {
                return flag;
            }
        }
        return 1;
    }

    @RequestMapping(value = "/IncreaseElementMsg", method = {RequestMethod.POST})
    @ResponseBody
    public Integer IncreaseElement(@RequestBody List<Element> elements) {
        System.out.println(elements);
        for (int i = 0; i < elements.size(); i++) {
            Integer flag = equipmentService.IncreaseElement(elements.get(i));
            if (flag != 1) {
                return flag;
            }
        }
        return 1;
    }

//   成功的
    @RequestMapping(value = "/importElementFile", method = {RequestMethod.POST})
    @ResponseBody
    public void UploadElementMsg(@RequestParam("file") MultipartFile file, @Param("category_id") Integer category_id, HttpServletRequest request) throws IOException {
        Element element = new Element();
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
        List<Map<String, Object>> list = ExcelUtil.analysisWorkbook(workbook);
        System.out.println(list);

        for (Map<String, Object> map : list) {
            map.put("category_id",category_id);
            mapToBean(map, element);
//            equipmentService.IncreaseElement(element);
        }
    }



    public static <T> T mapToBean(Map<String, Object> map,T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
}
