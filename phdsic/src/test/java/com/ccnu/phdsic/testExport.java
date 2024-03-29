package com.ccnu.phdsic;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddressList;

public class testExport {
	
	public static void main(String[] args) throws IOException {  
        HSSFWorkbook wb = new HSSFWorkbook();// excel文件对象  
        HSSFSheet sheetlist = wb.createSheet("sheetlist");// 工作表对象  
  
        FileOutputStream out = new FileOutputStream("d:\\success.xls");  
        String[] textlist = {};
  
        sheetlist = setHSSFValidation(sheetlist, textlist, 0, 5, 0, 0);// 第一列的前6行都设置为选择列表形式.  
        // sheetlist = setHSSFPrompt(sheetlist, "promt Title", "prompt Content",  
        // 0, 500, 1, 1);// 第二列的前501行都设置提示.  
  
        wb.write(out);  
        out.close();  
    } 
	
	 public static HSSFSheet setHSSFValidation(HSSFSheet sheet,  
	            String[] textlist, int firstRow, int endRow, int firstCol,  
	            int endCol) {  
	        // 加载下拉列表内容  
	        DVConstraint constraint = DVConstraint  
	                .createExplicitListConstraint(textlist);  
	        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列  
	        CellRangeAddressList regions = new CellRangeAddressList(firstRow,  
	                endRow, firstCol, endCol);  
	        // 数据有效性对象  
	        HSSFDataValidation data_validation_list = new HSSFDataValidation(  
	                regions, constraint);  
	        sheet.addValidationData(data_validation_list);  
	        return sheet;  
	    }
	
/*	 public static HSSFSheet setHSSFPrompt(HSSFSheet sheet, String promptTitle,  
	            String promptContent, int firstRow, int endRow, int firstCol,  
	            int endCol) {  
	        // 构造constraint对象  
	        DVConstraint constraint = DVConstraint  
	                .createCustomFormulaConstraint("BB1");  
	        // 四个参数分别是：起始行、终止行、起始列、终止列  
	        CellRangeAddressList regions = new CellRangeAddressList(firstRow,  
	                endRow, firstCol, endCol);  
	        // 数据有效性对象  
	        HSSFDataValidation data_validation_view = new HSSFDataValidation(  
	                regions, constraint);  
	        data_validation_view.createPromptBox(promptTitle, promptContent);  
	        sheet.addValidationData(data_validation_view);  
	        return sheet;  
	    } */
}
