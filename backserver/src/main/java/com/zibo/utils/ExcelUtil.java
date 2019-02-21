package com.zibo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Jimmy on 2017/3/20.
 */
public class ExcelUtil {

    public static String NO_DEFINE = "no_define";//未定义的字段

    public static String DEFAULT_DATE_PATTERN = "yyyy年MM月dd日";//默认日期格式

    public static int DEFAULT_COLOUMN_WIDTH = 17;

    /**
     * 导出Excel 97(.xls)格式 ，少量数据
     *
     * @param title       标题行
     * @param headMap     属性-列名
     * @param jsonArray   数据集
     * @param datePattern 日期格式，null则用默认日期格式
     * @param colWidth    列宽 默认 至少17个字节
     * @param out         输出流
     */
    public static void exportExcel(String title, Map<String, String> headMap, JSONArray jsonArray, String datePattern, Integer colWidth,
                                   OutputStream out) {

        //设置日期格式
        if (datePattern == null) {
            datePattern = DEFAULT_DATE_PATTERN;
        }

        if (colWidth == null) {
            colWidth = 17;
        }
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.createInformationProperties();
        SummaryInformation si = workbook.getSummaryInformation();
        si.setAuthor("mocar");  //填加xls文件作者信息
        si.setApplicationName("导出程序"); //填加xls文件创建程序信息
        si.setLastAuthor("最后保存者信息"); //填加xls文件最后保存者信息
        si.setComments("mocar"); //填加xls文件作者信息
        si.setTitle("POI导出Excel"); //填加xls文件标题信息
        si.setSubject("POI导出Excel");//填加文件主题信息
        si.setCreateDateTime(new Date());
        //表头样式
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setBoldweight((short) 700);
        titleStyle.setFont(titleFont);
        // 列头样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerStyle.setFont(headerFont);
        // 单元格样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        HSSFFont cellFont = workbook.createFont();
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);
        // 生成一个(带标题)表格
        HSSFSheet sheet = workbook.createSheet();
        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
                0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("mocar");
        //设置列宽
        int minBytes = colWidth < DEFAULT_COLOUMN_WIDTH ? DEFAULT_COLOUMN_WIDTH : colWidth;//至少字节数
        int[] arrColWidth = new int[headMap.size()];
        // 产生表格标题行,以及设置列宽
        String[] properties = new String[headMap.size()];
        String[] headers = new String[headMap.size()];
        int ii = 0;
        for (Iterator<String> iter = headMap.keySet().iterator(); iter.hasNext(); ) {
            String fieldName = iter.next();
            properties[ii] = fieldName;
            headers[ii] = fieldName;
            int bytes = fieldName.getBytes().length;
            arrColWidth[ii] = bytes < minBytes ? minBytes : bytes;
            sheet.setColumnWidth(ii, arrColWidth[ii] * 256);
            ii++;
        }
        // 遍历集合数据，产生数据行
        int rowIndex = 0;
        for (Object obj : jsonArray) {
            //如果数据超过了，则在第二页显示
            if (rowIndex == 65535 || rowIndex == 0) {
                if (rowIndex != 0) sheet = workbook.createSheet();
                //表头 rowIndex=0
                HSSFRow titleRow = sheet.createRow(0);
                titleRow.createCell(0).setCellValue(title);
                titleRow.getCell(0).setCellStyle(titleStyle);
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));

                //列头 rowIndex =1
                HSSFRow headerRow = sheet.createRow(1);
                for (int i = 0; i < headers.length; i++) {
                    headerRow.createCell(i).setCellValue(headers[i]);
                    headerRow.getCell(i).setCellStyle(headerStyle);
                }
                //数据内容从 rowIndex=2开始
                rowIndex = 2;
            }
            JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
            HSSFRow dataRow = sheet.createRow(rowIndex);
            for (int i = 0; i < properties.length; i++) {
                HSSFCell newCell = dataRow.createCell(i);
                Object o = jo.get(properties[i]);
                String cellValue = "";
                if (o == null) {
                    cellValue = "";
                } else if (o instanceof Date) {
                    cellValue = new SimpleDateFormat(datePattern).format(o);
                } else {
                    cellValue = o.toString();
                }
                newCell.setCellValue(cellValue);
                newCell.setCellStyle(cellStyle);
            }
            rowIndex++;
        }
        // 自动调整宽度
        /*for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }*/
        try {
            workbook.write(out);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出Excel OOXML (.xlsx)格式
     *
     * @param title       标题行
     * @param headMap     属性-列头
     * @param jsonArray   数据集
     * @param datePattern 日期格式，传null值则默认 年月日
     * @param colWidth    列宽 默认 至少17个字节
     * @param realPath    文件物理地址
     */
    public static String exportExcelX(String title, Map<String, String> headMap, JSONArray jsonArray, String datePattern, int colWidth, String realPath) {
        if (datePattern == null) datePattern = DEFAULT_DATE_PATTERN;
        // 声明一个工作薄
        SXSSFWorkbook workbook = new SXSSFWorkbook(1000);//缓存
        workbook.setCompressTempFiles(true);
        //表头样式
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        Font titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setBoldweight((short) 700);
        titleStyle.setFont(titleFont);
        // 列头样式
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerStyle.setFont(headerFont);
        // 单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        Font cellFont = workbook.createFont();
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);
        // 生成一个(带标题)表格
        SXSSFSheet sheet = workbook.createSheet();
        //设置列宽
        int minBytes = colWidth < DEFAULT_COLOUMN_WIDTH ? DEFAULT_COLOUMN_WIDTH : colWidth;//至少字节数
        int[] arrColWidth = new int[headMap.size()];
        // 产生表格标题行,以及设置列宽
        String[] properties = new String[headMap.size()];
        String[] headers = new String[headMap.size()];
        int ii = 0;
        for (Iterator<String> iter = headMap.keySet().iterator(); iter.hasNext(); ) {
            String fieldName = iter.next();
            properties[ii] = fieldName;
            headers[ii] = headMap.get(fieldName);
            int bytes = fieldName.getBytes().length;
            arrColWidth[ii] = bytes < minBytes ? minBytes : bytes;
            sheet.setColumnWidth(ii, arrColWidth[ii] * 256);
            ii++;
        }
        // 遍历集合数据，产生数据行
        int rowIndex = 0;
        for (Object obj : jsonArray) {
            if (obj == null) {
                continue;
            }
            if (rowIndex == 65535 || rowIndex == 0) {
                if (rowIndex != 0) {
                    sheet = workbook.createSheet();//如果数据超过了，则在第二页显示
                }
                SXSSFRow titleRow = sheet.createRow(0);//表头 rowIndex=0
                titleRow.createCell(0).setCellValue(title);
                titleRow.getCell(0).setCellStyle(titleStyle);
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));

                SXSSFRow headerRow = sheet.createRow(1); //列头 rowIndex =1
                for (int i = 0; i < headers.length; i++) {
                    headerRow.createCell(i).setCellValue(headers[i]);
                    headerRow.getCell(i).setCellStyle(headerStyle);
                }
                rowIndex = 2;//数据内容从 rowIndex=2开始
            }
            JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
            SXSSFRow dataRow = sheet.createRow(rowIndex);
            try {
                for (int i = 0; i < properties.length; i++) {
                    SXSSFCell newCell = dataRow.createCell(i);
                    Object o = jo.get(properties[i]);
                    String cellValue = "";
                    if (o == null) {
                        cellValue = "";
                    } else if (o instanceof Date) {
                        cellValue = new SimpleDateFormat(datePattern).format(o);
                    } else if (o instanceof Float || o instanceof Double) {
                        cellValue = new BigDecimal(o.toString()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
                    } else if (o instanceof Boolean) {
                        cellValue = (Boolean) o ? "1" : "0";
                    } else {
                        cellValue = o.toString();
                    }
                    newCell.setCellValue(cellValue);
                    newCell.setCellStyle(cellStyle);
                }
                rowIndex++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 自动调整宽度
        /*for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }*/
        try {
            String fileName = new Date().getTime() + ".xlsx";
            File file = new File(realPath + "/" + fileName);
            OutputStream out = new FileOutputStream(file);
            workbook.write(out);
            workbook.close();
            workbook.dispose();
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 输出到浏览器中
     */
    public static void exportToWeb(HttpServletResponse response, File tempExcelFile, String fileName) throws Exception {
        FileInputStream fin = null;
        try {
            response.reset();// 清空输出流
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));//设定输出文件头
//            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");//定义输出类型
            // 读取文件并且输出
            fin = new FileInputStream(tempExcelFile);
            byte[] tempBytes = new byte[2048];
//            while (fin.read(tempBytes) != -1) {
//                response.getOutputStream().write(tempBytes);UTF-8
//            }
            int len = 0;
            OutputStream out = response.getOutputStream();
            while ((len = fin.read(tempBytes)) > 0) {
                out.write(tempBytes, 0, len);//将缓冲区的数据输出到客户端浏览器
            }
            response.getOutputStream().close();
        } catch (Exception e) {
            throw new Exception();
        } finally {
            if (fin != null) {
                try {
                    fin.close(); // 关闭流
                } catch (IOException e) {
                    throw new Exception();
                }
            }
            tempExcelFile.delete();
        }
    }

    /**
     * excel(.xlsx)导入
     *
     * @param path     excel文件目录
     * @param keyValue 表头跟类属性对应的map
     * @param clz      返回的类
     * @return 成功返回list 失败返回null
     */
    public static List importExcelX(String path, Map<String, String> keyValue, Class clz) throws IllegalAccessException, InstantiationException {
        List<Map<String, String>> result = new ArrayList<>();
        //表头
        Map<String, String> key = new HashMap<>();

        try {
            /*读取文件*/
            File f = new File(path);
            InputStream in = new FileInputStream(f);

            XSSFWorkbook wb = new XSSFWorkbook(in);


            int count = wb.getActiveSheetIndex();
            System.out.print(count);
            XSSFSheet xssfSheet = wb.getSheetAt(0);
            XSSFRow firstRow = xssfSheet.getRow(1);

            //读取表头
            for (int cellCount = firstRow.getFirstCellNum(); cellCount < firstRow.getLastCellNum(); cellCount++) {
                XSSFCell cell = firstRow.getCell(cellCount);
                String value = cell.toString();
                key.put("" + cellCount, value);
            }

            //读取信息匹配表头
            for (int j = firstRow.getRowNum() + 1; j <= xssfSheet.getLastRowNum(); j++) {
                XSSFRow row = xssfSheet.getRow(j);
                HashMap<String, String> oneRow = new HashMap<>();
                boolean IsEmpty = true;
                for (int cellCount = row.getFirstCellNum(); cellCount < row.getLastCellNum(); cellCount++) {
                    XSSFCell cell = row.getCell(cellCount);
                    if (cell != null) {
                        String value = cell.toString();
                        if (value != null && !value.equals("")) {
                            oneRow.put(key.get(cellCount + ""), value);
                            IsEmpty = false;
                        }

                    }
                }
                if (!IsEmpty) {
                    result.add(oneRow);
                }

            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        List<Object> resultInstanceList = new ArrayList<>();
        List<Field> fields = Lists.newArrayList(clz.getDeclaredFields());//获得全部属性
        for (Map<String, String> map : result) {
            Object o = clz.newInstance();
            for (Field field : fields) {
                String filedName = field.getName();
                System.out.print(filedName + "\n");
                field.setAccessible(true);
                try {
                    String type = field.getType().toString();
                    String value = map.get(keyValue.get(filedName));
                    if (value == null)
                        continue;
                    if (type.endsWith("String"))
                        field.set(o, value.indexOf(".") > 0 ? value.substring(0, value.indexOf(".")) : value);
                    else if (type.endsWith("Integer"))
                        field.set(o, Integer.parseInt(value.substring(0, value.indexOf("."))));
                    else if (type.endsWith("BigDecimal"))
                        field.set(o, BigDecimal.valueOf(Double.parseDouble(value)));
                    else if (type.endsWith("Float"))
                        field.set(o, Float.valueOf(value));
                    else if (type.endsWith("Date")) {
                        if (value.length() == 10)
                            field.set(o, DateUtil.YYYY_MM_DD.parse(value));
                        else
                            field.set(o, DateUtil.YYYY_MM_DD_HH_MM_SS.parse(value));
                    } else if (type.endsWith("Boolean")) {
                        field.set(o, Boolean.valueOf(value));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            resultInstanceList.add(o);
        }

        return resultInstanceList;
    }

    public static List<Object> importExcel(String path, Map<String, String> keyValue, Class clz) throws IllegalAccessException, InstantiationException {
        List<Map<String, String>> result = new ArrayList<>();
        //表头
        Map<String, String> key = new HashMap<>();

        try {
            /*读取文件*/
            File f = new File(path);
            InputStream in = new FileInputStream(f);

            HSSFWorkbook wb = new HSSFWorkbook(in);


            int count = wb.getActiveSheetIndex();
            System.out.print(count);
            HSSFSheet xssfSheet = wb.getSheetAt(0);
            HSSFRow firstRow = xssfSheet.getRow(1);

            //读取表头
            for (int cellCount = firstRow.getFirstCellNum(); cellCount < firstRow.getLastCellNum(); cellCount++) {
                HSSFCell cell = firstRow.getCell(cellCount);
                String value = cell.toString();
                key.put("" + cellCount, value);
            }

            //读取信息匹配表头
            for (int j = firstRow.getRowNum() + 1; j <= xssfSheet.getLastRowNum(); j++) {
                HSSFRow row = xssfSheet.getRow(j);
                HashMap<String, String> oneRow = new HashMap<>();
                boolean IsEmpty = true;
                for (int cellCount = row.getFirstCellNum(); cellCount < row.getLastCellNum(); cellCount++) {
                    HSSFCell cell = row.getCell(cellCount);
                    if (cell != null) {
                        String value = cell.toString();
                        if (value != null && !value.equals("")) {
                            oneRow.put(key.get(cellCount + ""), value);
                            IsEmpty = false;
                        }

                    }
                }
                if (!IsEmpty) {
                    result.add(oneRow);
                }

            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        List<Object> resultInstanceList = new ArrayList<>();
        Field[] fields = clz.getDeclaredFields();//获得全部属性
        for (Map<String, String> map : result) {
            Object o = clz.newInstance();
            for (Field field : fields) {
                String filedName = field.getName();
                System.out.print(filedName + "\n");
                field.setAccessible(true);
                try {
                    String type = field.getType().toString();
                    String value = map.get(keyValue.get(filedName));
                    if (value == null)
                        continue;
                    if (type.endsWith("String"))
                        field.set(o, value.indexOf(".") > 0 ? value.substring(0, value.indexOf(".")) : value);
                    else if (type.endsWith("Integer"))
                        field.set(o, Integer.parseInt(value.substring(0, value.indexOf("."))));
                    else if (type.endsWith("BigDecimal"))
                        field.set(o, BigDecimal.valueOf(Double.parseDouble(value)));
                    else if (type.endsWith("Date")) {
                        if (value.length() == 10)
                            field.set(o, DateUtil.YYYY_MM_DD.parse(value));
                        else
                            field.set(o, DateUtil.YYYY_MM_DD_HH_MM_SS.parse(value));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            resultInstanceList.add(o);
        }

        return resultInstanceList;
    }
}

