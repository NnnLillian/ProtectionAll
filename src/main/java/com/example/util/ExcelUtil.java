package com.example.util;

import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.Map.Entry;

import com.example.entity.Category;
import com.example.entity.Device;
import com.example.entity.Element;
import com.example.entity.Equipment;
import net.sf.cglib.beans.BeanMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    /**
     * 根据文件路径，生成workbook实例
     *
     * @param filePath
     * @return
     */
    public static Workbook readExcel(String filePath) {
        Workbook workbook = null;
        if (filePath == null) return null;
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return workbook;
    }

    /**
     * 通过流获取workbook的实例
     *
     * @param in
     * @return
     */
    public static Workbook readExcel(InputStream in) {
        Workbook workbook = null;
        try {
            //这里仅仅解析的是xlsx类型的excel，如果是xls格式的new HSSFWorkbook(in)，大家可根据文件的后缀不同，自动适配
            workbook = new XSSFWorkbook(in);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return workbook;
    }

    public static List<Map<String, Object>> analysisWorkbook(Workbook workbook) {
        if (workbook == null) return null;
        List<Map<String, Object>> result = new ArrayList<>();
        //定义excel有哪些字段
//        String[] colunms = {"name","age","score"};
        String[] colunms;
        //获取第一个sheet
        Sheet firstSheet = workbook.getSheetAt(0);
        int rowNums = firstSheet.getPhysicalNumberOfRows();
        //获取第一行，即可定义excel有哪些字段
        Row row = firstSheet.getRow(0);
        //获取最大的列数
        int colunmNums = row.getPhysicalNumberOfCells();
        colunms = new String[colunmNums];
        for (int colunm = 0; colunm < colunmNums; colunm++) {
            colunms[colunm] = (String) getCellValue(row.getCell(colunm));
        }

        for (int i = 1; i < rowNums; i++) {
            row = firstSheet.getRow(i);
            Map<String, Object> cellMap = new HashMap<>();
            if (row != null) {
                for (int j = 0; j < colunmNums; j++) {
                    cellMap.put(colunms[j], getCellValue(row.getCell(j)));
                }
            }
            result.add(cellMap);
        }
        return result;
    }

    /**
     * 获取每一个excel表格中的value
     *
     * @param cell
     * @return ps: Cell 文档地址 http://poi.apache.org/apidocs/org/apache/poi/ss/usermodel/Cell.html
     */
    public static Object getCellValue(Cell cell) {
        Object result = null;
        if (cell == null) return null;
        switch (cell.getCellTypeEnum()) {
//            case Cell.CELL_TYPE_NUMERIC:
            case NUMERIC:
                //判断cell是否是日期格式
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    if (cell.getDateCellValue() != null)
                        result = sdf.format(cell.getDateCellValue());
                } else if (cell.getNumericCellValue() > 2147483647) {
                    if (cell.getNumericCellValue() != 0)
                        result = String.valueOf(cell.getNumericCellValue());
                } else {
                    if (cell.getNumericCellValue() != 0)
                        result = (int) cell.getNumericCellValue();
                }
                break;
            case FORMULA:
                //判断cell是否是日期格式
                if (DateUtil.isCellDateFormatted(cell)) {
                    if (cell.getDateCellValue() != null)
                        result = cell.getDateCellValue();
                } else {
                    if (cell.getNumericCellValue() != 0)
                        result = (int) cell.getNumericCellValue();
                }
                break;
            case STRING:
                if (cell.getRichStringCellValue() != null)
                    result = cell.getRichStringCellValue().getString().replace(" ", "");
                break;
            default:
                result = "";
                break;
        }
        return result;
    }

    public List<Device> GetDevice(String path) throws Exception {

        // 解析
        InputStream in = new FileInputStream(path);
        Workbook workbook = ExcelUtil.readExcel(in);
        List<Map<String, Object>> list = ExcelUtil.analysisWorkbook(workbook);
        List<Device> deviceList = new ArrayList<>();

        for (Map<String, Object> map : list) {
            Device device = new Device();
            MapToModel(map, device);
            deviceList.add(device);
        }
        return deviceList;
    }

    public List<Category> GetCategory(String path) throws Exception {

        InputStream in = new FileInputStream(path);
        Workbook workbook = ExcelUtil.readExcel(in);
        List<Map<String, Object>> list = ExcelUtil.analysisWorkbook(workbook);
        List<Category> categoryList = new ArrayList<>();

        for (Map<String, Object> map : list) {
            Category category = new Category();
            MapToModel(map, category);
            categoryList.add(category);
        }
        return categoryList;
    }

    public List<Element> GetElement(String path) throws Exception {

        InputStream in = new FileInputStream(path);
        Workbook workbook = ExcelUtil.readExcel(in);
        List<Map<String, Object>> list = ExcelUtil.analysisWorkbook(workbook);
        List<Element> elementList = new ArrayList<>();

        for (Map<String, Object> map : list) {
            Element element = new Element();
            MapToModel(map, element);
            elementList.add(element);
        }
        return elementList;
    }

    public List<Equipment> GetEquipment(String path) throws Exception {

        InputStream in = new FileInputStream(path);
        Workbook workbook = ExcelUtil.readExcel(in);
        List<Map<String, Object>> list = ExcelUtil.analysisWorkbook(workbook);
        List<Equipment> equipmentList = new ArrayList<>();

        for (Map<String, Object> map : list) {
            Equipment equipment = new Equipment();
            MapToModel(map, equipment);
            equipmentList.add(equipment);
        }
        return equipmentList;
    }

    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    public static Object MapToModel(Map<String, Object> map, Object o) throws Exception {
        if (!map.isEmpty()) {
            for (String k : map.keySet()) {
                Object v = null;
                if (!k.isEmpty()) {
                    v = map.get(k);
                }
                Field[] fields = o.getClass().getDeclaredFields();
                for (Field field : fields) {

                    if (field.getName().toUpperCase().equals(k.toUpperCase())) {
                        field.setAccessible(true);
                        String type = field.getType().toString();
                        if (type.endsWith("String")) {
                            if (v != null && v.toString() != null && v.toString() != "") {
                                v = v.toString();
                            } else {
                                v = "";
                            }
                        }
                        if (type.endsWith("Date")) {
                            if (v != null && v.toString() != null && v.toString() != "")
                                v = new Date(v.toString());
                            else
                                v = null;
                        }
                        if (type.endsWith("Boolean")) {
                            if (v != null && v.toString() != null && v.toString() != "")
                                v = Boolean.getBoolean(v.toString());
                            else
                                v = null;
                        }
                        if (type.endsWith("Integer")) {
                            if (v != null && v.toString() != null && v.toString() != "")
                                v = new Integer(v.toString());
                            else
                                v = 0;
                        }
                        if (type.endsWith("Long")) {
                            if (v != null && v.toString() != null && v.toString() != "")
                                v = new Long(v.toString());
                            else
                                v = 0;
                        }
                        if (type.endsWith("double")) {
                            if (v != null && v.toString() != null && v.toString() != "")
                                v = new Long(v.toString());
                            else
                                v = 0;
                        }
                        if (type.endsWith("float")) {
                            if (v != null && v.toString() != null && v.toString() != "")
                                v = new Float(v.toString());
                            else
                                v = 0;
                        }
                        //endregion
                        field.set(o, v);
                    }
                }
            }
        }
        return o;
    }

}
