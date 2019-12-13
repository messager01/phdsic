package com.ccnu.phdsic.util;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddressList;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PageOrder;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * create by Shipeixin on 2019/11/29 19:07
 */
public class DictionaryMoreUtil {

    public static HSSFSheet setHSSFValidation(HSSFWorkbook wb, HSSFSheet sheet,
                                              List list, int firstRow, int endRow, int firstCol,
                                              int endCol) {

        String[] textlist = new String[list.size()];
        list.toArray(textlist);
        String hiddenSheet = "CAT"+new Date().getTime()+UUID.randomUUID().toString().substring(0,4);
        int cellNum=endCol;
        HSSFSheet category1Hidden = wb.createSheet(hiddenSheet);
        for (int i = 0; i < textlist.length; i++) { // 循环赋值（为了防止下拉框的行数与隐藏域的行数相对应来获取>=选中行数的数组，将隐藏域加到结束行之后）
            category1Hidden.createRow(endRow + i).createCell(cellNum).setCellValue(textlist[i]);
        }
        Name category1Name = wb.createName();
        category1Name.setNameName(hiddenSheet);
        category1Name.setRefersToFormula(hiddenSheet + "!A1:A" + (textlist.length + endRow));
        // 加载下拉列表内容
        DVConstraint constraint = DVConstraint
                .createFormulaListConstraint(hiddenSheet);
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow,
                endRow, firstCol, endCol);
        // 数据有效性对象
        HSSFDataValidation data_validation_list = new HSSFDataValidation(
                regions, constraint);

        sheet.addValidationData(data_validation_list);
        category1Name.setNameName("A"+UUID.randomUUID().toString());

        return sheet;
    }
}
