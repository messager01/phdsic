package com.ccnu.phdsic.service.impl;

import com.ccnu.phdsic.entities.*;
import com.ccnu.phdsic.mapper.DictionaryMapper;
import com.ccnu.phdsic.util.DictionaryMoreUtil;
import com.ccnu.phdsic.util.DictionaryUtil;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
public class Export_2_1_ {


    @Autowired
    DictionaryMapper dictionaryMapper;

    /**
     *  表 2-1-1  下载
     */
    public  Integer exportByClass2_1_1(List<CourseStatus_2_1_1_shiqi> list, Sheet sheet3,Integer sheet3StartIndex,String nameByIdNum,Workbook wbss){



        Row rowIntroduction = sheet3.createRow(sheet3StartIndex++);

        String text="说明：\r\n1. 表2-1-1是指博导在统计时期内（2018年的9月1日至2019年的8月31日）实际开设的所有课程，包括本科生课程和研究生课程 。\r\n2. 表2-1-2是指博导在统计时期内（2018年的9月1日至2019年的8月31日）主持或参与的省部级及以上的教改项目。\r\n3. 表2-1-3是指博导在统计时期内（2018年的9月1日至2019年的8月31日）公开出版的教材情况，其中“教材入选情况”一栏请选填“国家级规划教材、省部级规划教材、国家级精品教材、省部级精品教材”。\r\n4. 表2-1-4是指博导在统计时期内（2018年的9月1日至2019年的8月31日）面向研究生教育的省部级及以上获奖情况。\r\n5. 表2-1-5是指博导在统计时期内（2018年的9月1日至2019年的8月31日）指导博士研究生获省部级及以上的奖励情况。";
        System.out.println(text);

        // 创建单元格
        rowIntroduction.createCell(0);
        rowIntroduction.getCell(0).setCellValue(text);


        //  合并单元格
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 8);
        sheet3.addMergedRegion(region);

        // 设置高度
        rowIntroduction.setHeight((short) (100*20));

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


        // 分隔  表开始位置
        Row rowx0 = sheet3.createRow(sheet3StartIndex++);
        // 表头
        Row rowx1 = sheet3.createRow(sheet3StartIndex++);

        /**
         *    加粗字端名
         */

        CellStyle fontcellStyle = wbss.createCellStyle();
        HSSFFont titleFont = (HSSFFont) wbss.createFont();
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        fontcellStyle.setFont(titleFont);

        rowx0.createCell(0).setCellValue("表2-1-1 开课情况（时期）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        rowx0.getCell(0).setCellStyle(cellStyle);

        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("课程编号");
        rowx1.createCell(3).setCellValue("课程名称");
        rowx1.createCell(4).setCellValue("课程类别");
        rowx1.createCell(5).setCellValue("课程性质");
        rowx1.createCell(6).setCellValue("教学学时");
        rowx1.createCell(7).setCellValue("开课对象");
        rowx1.createCell(8).setCellValue("上课人数(人)");
        for (int i = 0; i <= 8;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }

        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet3.createRow(sheet3StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                CourseStatus_2_1_1_shiqi o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getCourseNumber());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getCourseName());
                }else{
                    row.createCell(3).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("课程类别"),row.getRowNum(),row.getRowNum(),4,4);
                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getCourseType());
                }else{
                    row.createCell(4).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("课程性质"),row.getRowNum(),row.getRowNum(),5,5);
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getCourseNature());
                }else{
                    row.createCell(5).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getTeachingHours());
                }else{
                    row.createCell(6).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("开课对象"),row.getRowNum(),row.getRowNum(),7,7);
                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getCourseObject());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getNumberOfStudents());
                }else{
                    row.createCell(8).setCellValue("");
                }

            }

        }


        //   空格分隔
        Row gap1 = sheet3.createRow(sheet3StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("课程类别"),gap1.getRowNum(),gap1.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("课程性质"),gap1.getRowNum(),gap1.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("开课对象"),gap1.getRowNum(),gap1.getRowNum(),7,7);



        Row gap2 = sheet3.createRow(sheet3StartIndex++);
        gap2.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("课程类别"),gap2.getRowNum(),gap2.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("课程性质"),gap2.getRowNum(),gap2.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("开课对象"),gap2.getRowNum(),gap2.getRowNum(),7,7);


        Row gap3 = sheet3.createRow(sheet3StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("课程类别"),gap3.getRowNum(),gap3.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("课程性质"),gap3.getRowNum(),gap3.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("开课对象"),gap3.getRowNum(),gap3.getRowNum(),7,7);


        return sheet3StartIndex;
    }

    /**
     *  表 2-1-2  下载
     */

    public Integer exportByClass2_1_2(List<GraduateEducationTeachingReformResearchProject_2_1_2_shiqi> list,Sheet sheet3,Integer sheet3StartIndex,String nameByIdNum,Workbook wbss){

        // 分隔  表开始位置
        Row rowx0 = sheet3.createRow(sheet3StartIndex++);
        // 表头
        Row rowx1 = sheet3.createRow(sheet3StartIndex++);

        /**
         *    加粗字端名
         */

        CellStyle fontcellStyle = wbss.createCellStyle();
        HSSFFont titleFont = (HSSFFont) wbss.createFont();
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        fontcellStyle.setFont(titleFont);



        rowx0.createCell(0).setCellValue("表2-1-2 研究生教育教学改革研究项目情况（时期）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        rowx0.getCell(0).setCellStyle(cellStyle);

        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("项目名称");
        rowx1.createCell(3).setCellValue("立项日期");
        rowx1.createCell(4).setCellValue("项目状态");
        rowx1.createCell(5).setCellValue("结束日期");
        rowx1.createCell(6).setCellValue("项目等级");
        rowx1.createCell(7).setCellValue("立项经费(万元)");
        rowx1.createCell(8).setCellValue("经费来源");
        rowx1.createCell(9).setCellValue("本人角色");


        for (int i = 0; i <= 9;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }

        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet3.createRow(sheet3StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                GraduateEducationTeachingReformResearchProject_2_1_2_shiqi o1=list.get(i);
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
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("项目状态"),row.getRowNum(),row.getRowNum(),4,4);
                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getProjectStatus());
                }else{
                    row.createCell(4).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getEndOfDate());
                }else{
                    row.createCell(5).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("项目等级"),row.getRowNum(),row.getRowNum(),6,6);
                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getProjectLevel());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getProjectFunding());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getSourcesOfFunding());
                }else{
                    row.createCell(8).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("研究生教育教学改革研究项目情况本人角色"),row.getRowNum(),row.getRowNum(),9,9);
                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getRole());
                }else{
                    row.createCell(9).setCellValue("");
                }
            }

        }


        //   空格分隔
        Row gap1 = sheet3.createRow(sheet3StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("项目状态"),gap1.getRowNum(),gap1.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("项目等级"),gap1.getRowNum(),gap1.getRowNum(),6,6);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("研究生教育教学改革研究项目情况本人角色"),gap1.getRowNum(),gap1.getRowNum(),9,9);


        Row gap2 = sheet3.createRow(sheet3StartIndex++);
        gap2.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("项目状态"),gap2.getRowNum(),gap2.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("项目等级"),gap2.getRowNum(),gap2.getRowNum(),6,6);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("研究生教育教学改革研究项目情况本人角色"),gap2.getRowNum(),gap2.getRowNum(),9,9);


        Row gap3 = sheet3.createRow(sheet3StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("项目状态"),gap3.getRowNum(),gap3.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("项目等级"),gap3.getRowNum(),gap3.getRowNum(),6,6);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("研究生教育教学改革研究项目情况本人角色"),gap3.getRowNum(),gap3.getRowNum(),9,9);

        return sheet3StartIndex;
    }

    /**
     *
     *    表  2-1-3  下载
     */
    public  Integer exportByClass2_1_3(List<PublishingTextbookSituation_2_1_3shqi> list, Sheet sheet3, Integer sheet3StartIndex,String nameByIdNum,Workbook wbss){

        // 分隔  表开始位置
        Row rowx0 = sheet3.createRow(sheet3StartIndex++);
        // 表头
        Row rowx1 = sheet3.createRow(sheet3StartIndex++);


        /**
         *    加粗字端名
         */

        CellStyle fontcellStyle = wbss.createCellStyle();
        HSSFFont titleFont = (HSSFFont) wbss.createFont();
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        fontcellStyle.setFont(titleFont);

        rowx0.createCell(0).setCellValue("表2-1-3 出版教材情况（时期）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        rowx0.getCell(0).setCellStyle(cellStyle);

        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("教材名称");
        rowx1.createCell(3).setCellValue("教材入选情况");
        rowx1.createCell(4).setCellValue("出版社");
        rowx1.createCell(5).setCellValue("出版社所在国家（地区）");
        rowx1.createCell(6).setCellValue("总字数(万字)");
        rowx1.createCell(7).setCellValue("发行数(册)");
        rowx1.createCell(8).setCellValue("出版日期");
        rowx1.createCell(9).setCellValue("书号（ISBN）");
        rowx1.createCell(10).setCellValue("出版语言");
        rowx1.createCell(11).setCellValue("本人角色");

        for (int i  = 0; i <= 11;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }

        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet3.createRow(sheet3StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                PublishingTextbookSituation_2_1_3shqi o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getTextbookName());
                }else{
                    row.createCell(2).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("教材入选情况"),row.getRowNum(),row.getRowNum(),3,3);
                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getSituationWithSelectedTextbooks());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getPublishingHouse());
                }else{
                    row.createCell(4).setCellValue("");
                }
                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("国家"),row.getRowNum(),row.getRowNum(),5,5);
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getPublisherCountry());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getTotalNumberOfWords());
                }else{
                    row.createCell(6).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getNumberOfIssues());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getPublicationDate());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getBookNumber());
                }else{
                    row.createCell(9).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("出版语言"),row.getRowNum(),row.getRowNum(),10,10);
                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getPublishingLanguage());
                }else{
                    row.createCell(10).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("出版教材情况本人角色"),row.getRowNum(),row.getRowNum(),11,11);
                if(o1!=null){
                    row.createCell(11).setCellValue(o1.getRole());
                }else{
                    row.createCell(11).setCellValue("");
                }
            }




        }


        //   空格分隔
        Row gap1 = sheet3.createRow(sheet3StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("教材入选情况"),gap1.getRowNum(),gap1.getRowNum(),3,3);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("国家"),gap1.getRowNum(),gap1.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("出版语言"),gap1.getRowNum(),gap1.getRowNum(),10,10);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("出版教材情况本人角色"),gap1.getRowNum(),gap1.getRowNum(),11,11);



        Row gap2 = sheet3.createRow(sheet3StartIndex++);
        gap2.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("教材入选情况"),gap2.getRowNum(),gap2.getRowNum(),3,3);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("国家"),gap2.getRowNum(),gap2.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("出版语言"),gap2.getRowNum(),gap2.getRowNum(),10,10);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("出版教材情况本人角色"),gap2.getRowNum(),gap2.getRowNum(),11,11);


        Row gap3 = sheet3.createRow(sheet3StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("教材入选情况"),gap3.getRowNum(),gap3.getRowNum(),3,3);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("国家"),gap3.getRowNum(),gap3.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("出版语言"),gap3.getRowNum(),gap3.getRowNum(),10,10);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("出版教材情况本人角色"),gap3.getRowNum(),gap3.getRowNum(),11,11);

        return sheet3StartIndex;
    }

    /**
     *
     *    表  2-1-4  下载
     */
    public  Integer exportByClass2_1_4(List<AwardsForGraduateTeachingAchievements_2_1_4_shiqi> list, Sheet sheet3, Integer sheet3StartIndex,String nameByIdNum,Workbook wbss){

        // 分隔  表开始位置
        Row rowx0 = sheet3.createRow(sheet3StartIndex++);
        // 表头
        Row rowx1 = sheet3.createRow(sheet3StartIndex++);
        /**
         *    加粗字端名
         */

        CellStyle fontcellStyle = wbss.createCellStyle();
        HSSFFont titleFont = (HSSFFont) wbss.createFont();
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        fontcellStyle.setFont(titleFont);

        rowx0.createCell(0).setCellValue("表2-1-4 研究生教学成果获奖情况（时期）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        rowx0.getCell(0).setCellStyle(cellStyle);

        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("完成人序位");
        rowx1.createCell(3).setCellValue("奖项名称");
        rowx1.createCell(4).setCellValue("证书号");
        rowx1.createCell(5).setCellValue("第一获奖单位是否为填表单位");
        rowx1.createCell(6).setCellValue("获奖级别");
        rowx1.createCell(7).setCellValue("获奖等级");
        rowx1.createCell(8).setCellValue("获奖日期");
        rowx1.createCell(9).setCellValue("颁奖单位");

        for (int i = 0 ; i <= 9;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }


        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet3.createRow(sheet3StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                AwardsForGraduateTeachingAchievements_2_1_4_shiqi o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getCompletionOrder());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getAwardName());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getCertificateNumber());
                }else{
                    row.createCell(4).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖情况第一获奖单位是否为填表单位"),row.getRowNum(),row.getRowNum(),5,5);
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getWhetherFirstWinningUnitIsFillingUnit());
                }else{
                    row.createCell(5).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖级别"),row.getRowNum(),row.getRowNum(),6,6);
                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getAwardLevel());
                }else{
                    row.createCell(6).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖等级"),row.getRowNum(),row.getRowNum(),7,7);
                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getAwardGrade());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getAwardDate());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getAwardingUnit());
                }else{
                    row.createCell(9).setCellValue("");
                }

            }

        }


        //   空格分隔
        Row gap1 = sheet3.createRow(sheet3StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖情况第一获奖单位是否为填表单位"),gap1.getRowNum(),gap1.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖级别"),gap1.getRowNum(),gap1.getRowNum(),6,6);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖等级"),gap1.getRowNum(),gap1.getRowNum(),7,7);



        Row gap2 = sheet3.createRow(sheet3StartIndex++);
        gap2.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖情况第一获奖单位是否为填表单位"),gap2.getRowNum(),gap2.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖级别"),gap2.getRowNum(),gap2.getRowNum(),6,6);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖等级"),gap2.getRowNum(),gap2.getRowNum(),7,7);



        Row gap3 = sheet3.createRow(sheet3StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖情况第一获奖单位是否为填表单位"),gap3.getRowNum(),gap3.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖级别"),gap3.getRowNum(),gap3.getRowNum(),6,6);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖等级"),gap3.getRowNum(),gap3.getRowNum(),7,7);

        return sheet3StartIndex;
    }

    /**
     *
     *    表  2-1-5  下载
     */
    public  Integer exportByClass2_1_5(List<GuidedDoctoralStudentsAwards_2_1_5_shiqi> list, Sheet sheet3, Integer sheet3StartIndex,String nameByIdNum,Workbook wbss){

        // 分隔  表开始位置
        Row rowx0 = sheet3.createRow(sheet3StartIndex++);
        // 表头
        Row rowx1 = sheet3.createRow(sheet3StartIndex++);



        /**
         *    加粗字端名
         */

        CellStyle fontcellStyle = wbss.createCellStyle();
        HSSFFont titleFont = (HSSFFont) wbss.createFont();
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        fontcellStyle.setFont(titleFont);


        rowx0.createCell(0).setCellValue("表2-1-5 指导博士生获奖情况（时期）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        rowx0.getCell(0).setCellStyle(cellStyle);

        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("获奖题目");
        rowx1.createCell(3).setCellValue("奖项名称");
        rowx1.createCell(4).setCellValue("证书号");
        rowx1.createCell(5).setCellValue("获奖级别");
        rowx1.createCell(6).setCellValue("获奖等级");
        rowx1.createCell(7).setCellValue("颁奖单位");
        rowx1.createCell(8).setCellValue("获奖博士生唯一识别码");
        rowx1.createCell(9).setCellValue("指导教师序位");

        for (int i = 0 ; i <= 9;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }


        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet3.createRow(sheet3StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                GuidedDoctoralStudentsAwards_2_1_5_shiqi o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getAwardTopic());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getAwardName());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getCertificateNumber());
                }else{
                    row.createCell(4).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖级别"),row.getRowNum(),row.getRowNum(),5,5);
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getAwardLevel());
                }else{
                    row.createCell(5).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖等级"),row.getRowNum(),row.getRowNum(),6,6);
                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getAwardGrade());
                }else{
                    row.createCell(6).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getAwardingUnit());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getAwardDoctoralStudentIdentificationCode());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getInstructorOrder());
                }else{
                    row.createCell(9).setCellValue("");
                }

            }

        }

/*
        Row gap1 = sheet3.createRow(sheet3StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖级别"),gap1.getRowNum(),gap1.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖等级"),gap1.getRowNum(),gap1.getRowNum(),6,6);


        Row gap2 = sheet3.createRow(sheet3StartIndex++);
        gap2.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖级别"),gap2.getRowNum(),gap2.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖等级"),gap2.getRowNum(),gap2.getRowNum(),6,6);


        Row gap3 = sheet3.createRow(sheet3StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖级别"),gap3.getRowNum(),gap3.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖等级"),gap3.getRowNum(),gap3.getRowNum(),6,6);*/
        return sheet3StartIndex;
    }
}
