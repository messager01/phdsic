package com.ccnu.phdsic.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddressList;

public class DictionaryUtil {

	
	 public static HSSFSheet setHSSFValidation(HSSFSheet sheet,
                                               List<String> list,
                                               int startRow,int endRow,int startColunm,int endColumn) {

	    // 将传进来的list集合转成数组

        String[] textlist = new String[list.size()];
        list.toArray(textlist);
	        // 加载下拉列表内容  
	        DVConstraint constraint = DVConstraint  
	                .createExplicitListConstraint(textlist);  
	        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列  
	        CellRangeAddressList regions = new CellRangeAddressList(startRow,
                    endRow, startColunm, endColumn);
	        // 数据有效性对象  
	        HSSFDataValidation data_validation_list = new HSSFDataValidation(  
	                regions, constraint);  
	        sheet.addValidationData(data_validation_list);


	        return sheet;  
	    }

}
