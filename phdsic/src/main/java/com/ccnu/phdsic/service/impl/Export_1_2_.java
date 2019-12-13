package com.ccnu.phdsic.service.impl;

import com.ccnu.phdsic.entities.*;
import com.ccnu.phdsic.mapper.DictionaryMapper;
import com.ccnu.phdsic.util.DictionaryUtil;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/22 15:57
 */
@Service
public class Export_1_2_ {


    @Autowired
    DictionaryMapper dictionaryMapper;

    /**
     *  表 1-2-1  下载
     */
    public void exportByClass1_2_1(List<ResearchProjectSituation_1_2_1_shiqi> list,Sheet sheet2,String nameByIdNum,Workbook wbss){


        Row rowIntroduction = sheet2.createRow(0);

        String text="说明：\r\n1. 表1-2-1（科研项目情况）是指在统计时期内（2018年的9月1日至2019年的8月31日）博导所主持的处于“在研”状态或完成“结题”的科研项目。\r\n2. 本表统计的纵向项目仅限于省部级及以上项目。\r\n3. 表格中的现有数据为研究生院学位办整合社科处、科研处提供的基础数据后填入，请相关研究生培养单位根据实际情况进一步补充、完善、修正，再发给导师个人完善、校对。";
        System.out.println(text);

        // 创建单元格
        rowIntroduction.createCell(0);
        rowIntroduction.getCell(0).setCellValue(text);


        //  合并单元格
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 11);
        sheet2.addMergedRegion(region);

        // 设置高度
        rowIntroduction.setHeight((short) (70*20));

        Font introductionFont = wbss.createFont();
        introductionFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        //  设置为蓝色
        introductionFont.setColor(HSSFColor.BLUE.index);
        introductionFont.setFontHeightInPoints((short) 12);
        CellStyle introductionFontCellStyle = wbss.createCellStyle();
        //  设置居中对齐
        introductionFontCellStyle.setAlignment(HSSFCellStyle.VERTICAL_CENTER);
        introductionFontCellStyle.setWrapText(true);
        introductionFontCellStyle.setFont(introductionFont);
        rowIntroduction.getCell(0).setCellStyle(introductionFontCellStyle);


        System.out.println(list);

        //  分隔符
        Row row0 = sheet2.createRow(1);
        row0.createCell(0).setCellValue("表1-2-1 科研项目情况（时期）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        row0.getCell(0).setCellStyle(cellStyle);
        Row rowx1 = sheet2.createRow(2);
        /**
         *    加粗字端名
         */

        CellStyle fontcellStyle = wbss.createCellStyle();
        HSSFFont titleFont = (HSSFFont) wbss.createFont();
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        fontcellStyle.setFont(titleFont);

        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("项目名称");
        rowx1.createCell(3).setCellValue("立项日期");
        rowx1.createCell(4).setCellValue("立项编号");
        rowx1.createCell(5).setCellValue("项目类型");
        rowx1.createCell(6).setCellValue("纵向项目类别");
        rowx1.createCell(7).setCellValue("项目状态");
        rowx1.createCell(8).setCellValue("填表单位排序");
        rowx1.createCell(9).setCellValue("国内项目合同金额（万元）");
        rowx1.createCell(10).setCellValue("国际项目合同金额（万元）");
        rowx1.createCell(11).setCellValue("项目累积到款（万元）");
        rowx1.createCell(12).setCellValue("项目年度到款（万元）");
        rowx1.createCell(13).setCellValue("结题验收或鉴定时间");
        rowx1.createCell(14).setCellValue("本人角色");

        for (int i = 0;  i <= 14; i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }

        int currentRow = 2;

        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++,currentRow++){
                Row row = sheet2.createRow(i+3);
                row.createCell(0).setCellValue(nameByIdNum);
                ResearchProjectSituation_1_2_1_shiqi o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getProjectName());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getProjectDate());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getProjectNumber());
                }else{
                    row.createCell(4).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("项目类型"),row.getRowNum(),row.getRowNum(),5,5);
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getProjectType());
                }else{
                    row.createCell(5).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("纵向项目类别"),row.getRowNum(),row.getRowNum(),6,6);
                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getVerticalProjectType());
                }else{
                    row.createCell(6).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("项目状态"),row.getRowNum(),row.getRowNum(),7,7);
                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getProjectStatus());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getSortUnitByFillInForm());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getDomesticProjectContractAmount());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getAbroadProjectContractAmount());
                }else{
                    row.createCell(10).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(11).setCellValue(o1.getAccumulatedItems());
                }else{
                    row.createCell(11).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(12).setCellValue(o1.getProjectYearToPayment());
                }else{
                    row.createCell(12).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(13).setCellValue(o1.getFinalAcceptanceOrIdentificationTime());
                }else{
                    row.createCell(13).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("科研项目情况本人角色"),row.getRowNum(),row.getRowNum(),14,14);
                if(o1!=null){
                    row.createCell(14).setCellValue(o1.getRole());
                }else{
                    row.createCell(14).setCellValue("");
                }

            }

/*
            System.out.println(currentRow);
            Row gap1 = sheet2.createRow(currentRow++);
            gap1.createCell(0).setCellValue("");

            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("项目类型"),gap1.getRowNum(),gap1.getRowNum(),5,5);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("纵向项目类别"),gap1.getRowNum(),gap1.getRowNum(),6,6);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("项目状态"),gap1.getRowNum(),gap1.getRowNum(),7,7);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("科研项目情况本人角色"),gap1.getRowNum(),gap1.getRowNum(),14,14);


            Row gap2 = sheet2.createRow(currentRow++);
            gap2.createCell(0).setCellValue("");

            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("项目类型"),gap2.getRowNum(),gap2.getRowNum(),5,5);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("纵向项目类别"),gap2.getRowNum(),gap2.getRowNum(),6,6);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("项目状态"),gap2.getRowNum(),gap2.getRowNum(),7,7);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("科研项目情况本人角色"),gap2.getRowNum(),gap2.getRowNum(),14,14);

            Row gap3 = sheet2.createRow(currentRow++);
            gap3.createCell(0).setCellValue("");

            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("项目类型"),gap3.getRowNum(),gap3.getRowNum(),5,5);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("纵向项目类别"),gap3.getRowNum(),gap3.getRowNum(),6,6);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("项目状态"),gap3.getRowNum(),gap3.getRowNum(),7,7);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet2,dictionaryMapper.getValueByFiledName("科研项目情况本人角色"),gap3.getRowNum(),gap3.getRowNum(),14,14);*/
        }

    }


}
