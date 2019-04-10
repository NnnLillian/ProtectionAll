package com.example.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    /**
     * 根据文件路径，生成workbook实例
     * @param filePath
     * @return
     */
    public static Workbook readExcel(String filePath) {
        Workbook workbook = null;
        if(filePath == null) return null;
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

    public static List<Map<String, Object>> analysisWorkbook(Workbook workbook){
        if(workbook == null) return null;
        List<Map<String,Object>> result = new ArrayList<>();
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
        colunms = new  String[colunmNums];
        for (int colunm= 0;colunm<colunmNums;colunm++){
            colunms[colunm]=(String)getCellValue( row.getCell(colunm));
        }

        for(int i=1;i<rowNums;i++) {
            row = firstSheet.getRow(i);
            Map<String,Object> cellMap = new HashMap<>();
            if(row!=null) {
                for(int j=0;j<colunmNums;j++) {
                    cellMap.put(colunms[j], getCellValue(row.getCell(j)));
                }
            }
            result.add(cellMap);
        }
        return result;
    }

    /**
     * 获取每一个excel表格中的value
     * @param cell
     * @return
     *  ps: Cell 文档地址 http://poi.apache.org/apidocs/org/apache/poi/ss/usermodel/Cell.html
     */
    public static Object getCellValue(Cell cell) {
        Object result = null;
        if(cell == null) return null;
        switch (cell.getCellTypeEnum()) {
//            case Cell.CELL_TYPE_NUMERIC:
            case NUMERIC :
                //判断cell是否是日期格式
                if(DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String stringDate = sdf.format(cell.getDateCellValue());
                    result = stringDate;
                }else {
                    result = (int)cell.getNumericCellValue();
                }
                break;
            case FORMULA:
                //判断cell是否是日期格式
                if(DateUtil.isCellDateFormatted(cell)) {
                    result = cell.getDateCellValue();
                }else {
                    result = (int)cell.getNumericCellValue();
                }
                break;
            case STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            default:
                result="";
                break;
        }
        return result;
    }

//    switch (cell.getCellType()){
//        case Cell.CELL_TYPE_NUMERIC: //数字
//            cellValue = stringDateProcess(cell);
//            break;
//        case Cell.CELL_TYPE_STRING: //字符串
//            cellValue = String.valueOf(cell.getStringCellValue());
//            break;
//        case Cell.CELL_TYPE_BOOLEAN: //Boolean
//            cellValue = String.valueOf(cell.getBooleanCellValue());
//            break;
//        case Cell.CELL_TYPE_FORMULA: //公式
//            cellValue = String.valueOf(cell.getCellFormula());
//            break;
//        case Cell.CELL_TYPE_BLANK: //空值
//            cellValue = "";
//            break;
//        case Cell.CELL_TYPE_ERROR: //故障
//            cellValue = "非法字符";
//            break;
//        default:
//            cellValue = "未知类型";
//            break;
//    }
}
