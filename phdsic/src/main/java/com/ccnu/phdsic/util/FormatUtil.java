package com.ccnu.phdsic.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;


public class FormatUtil {
	//学生excel


/**
 * 取EXL的值 里面多个种类型 取值不一样   所以写成统一的方法
 * 
 * @param row
 * @return Integer
 */
public static String getCellValue(Row row,int len) {
	if(null == row.getCell(len) || "".equals(row.getCell(len))){
	 return "";
	}
	//数字的时候
	if(row.getCell(len).getCellType() == Cell.CELL_TYPE_NUMERIC){	
		if (DateUtil.isCellDateFormatted(row.getCell(len))) {// 日期
            DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            return formater.format(row.getCell(len).getDateCellValue());
        } else {
        	DecimalFormat df = new DecimalFormat("0");  
			return df.format(row.getCell(len).getNumericCellValue()); 
        }
	}
	//字符串的时候
	if(row.getCell(len).getCellType() == Cell.CELL_TYPE_STRING){
		return row.getCell(len).getStringCellValue().trim();
	}
	//公式
	if(row.getCell(len).getCellType() == Cell.CELL_TYPE_FORMULA){
		return "";
	}
	//空白
	if(row.getCell(len).getCellType() == Cell.CELL_TYPE_BLANK){
		return ""; 
	}
	//Boolean
	if(row.getCell(len).getCellType() == Cell.CELL_TYPE_BOOLEAN){ 
		return String.valueOf(row.getCell(len).getBooleanCellValue());
	}
	//ERROR
	if(row.getCell(len).getCellType() == Cell.CELL_TYPE_ERROR){ 
		return String.valueOf(row.getCell(len).getErrorCellValue());
	}
	return "";
}

}