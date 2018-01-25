package online.qsx.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Poi4Excel {
    /**
     * Excel导出方法，将 List 转换成 Workbook 对象
     *
     * @params fileName 导入文件名称 fileType 导入文件后缀名  list 联系人信息
     */
    public static Workbook writer(String fileName, String fileType, ArrayList<ArrayList<Object>> list) throws IOException {
        //创建工作文档对象
        Workbook workbook = null;
        if (fileType.equals("xls")) {
            workbook = new HSSFWorkbook();
        } else if (fileType.equals("xlsx")) {
            workbook = new XSSFWorkbook();
        } else {
            return workbook;
        }
        // 创建sheet对象
        Sheet sheet = (Sheet) workbook.createSheet("sheet1");
        if (null != list && list.size() > 0) {
            // 遍历数据
            for (int i = 0; i < list.size(); i++) {
                ArrayList<Object> list1 = list.get(i);
                // 获取行对象
                Row row = (Row) sheet.createRow(i);
                for (int j = 0; j < list1.size(); j++) {
                    // 获取单元格对象
                    Cell cell = row.createCell(j);
                    // 给单元格设值
                    cell.setCellValue((String) list1.get(j));
                }
            }
        }
        // 返回工作文档对象
        return workbook;
    }
}
