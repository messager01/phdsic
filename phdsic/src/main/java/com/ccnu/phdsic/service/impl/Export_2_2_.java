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
public class Export_2_2_ {
    /**
     *  表 2-2-1  下载
     */
    @Autowired
    DictionaryMapper dictionaryMapper;

    public  Integer exportByClass2_2_1(List<ResearchPapers_2_2_1shiqi> list, Sheet sheet3, Integer sheet3StartIndex, String nameByIdNum, Workbook wbss){

        Row rowIntroduction = sheet3.createRow(sheet3StartIndex++);

        String text="说明：\r\n1. 表2-2-1是指博导在统计时期内（2018年的9月1日至2019年的8月31日）公开发表的科研论文信息。\r\n2. 表2-2-2是指博导在统计时期内（2018年的9月1日至2019年的8月31日）获省部级及以上科研奖励的情况。\r\n3. 表2-2-3是指博导在统计时期内（2018年的9月1日至2019年的8月31日）公开出版的著作情况。\r\n4. 表2-2-4是指博导在统计时期内（2018年的9月1日至2019年的8月31日）获授权专利（著作权）情况。\r\n5. 表2-2-5是指博导在统计时期内（2018年的9月1日至2019年的8月31日）发表国际学术会议报告情况。\r\n6. 表2-2-6是指博导在统计时点（2019年的8月31日）的学术任职情况。\r\n7. 表2-2-7是指博导在统计时点（2019年的8月31日）依托省部级及以上科研平台情况。";
        System.out.println(text);

        // 创建单元格
        rowIntroduction.createCell(0);
        rowIntroduction.getCell(0).setCellValue(text);


        //  合并单元格
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 10);
        sheet3.addMergedRegion(region);

        // 设置高度
        rowIntroduction.setHeight((short) (130*20));

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


        rowx0.createCell(0).setCellValue("表2-2-1 科研论文情况（时期）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        rowx0.getCell(0).setCellStyle(cellStyle);

        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("论文名称");
        rowx1.createCell(3).setCellValue("论文类型");
        rowx1.createCell(4).setCellValue("期刊名称");
        rowx1.createCell(5).setCellValue("期刊号（ISSN）");
        rowx1.createCell(6).setCellValue("发表语言");
        rowx1.createCell(7).setCellValue("DOI");
        rowx1.createCell(8).setCellValue("是否ESI收录");
        rowx1.createCell(9).setCellValue("收录索引");
        rowx1.createCell(10).setCellValue("作者序位");
        rowx1.createCell(11).setCellValue("是否通讯作者");

        for (int i = 0; i <= 11;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }


        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet3.createRow(sheet3StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                ResearchPapers_2_2_1shiqi o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getPaperName());
                }else{
                    row.createCell(2).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("论文类型"),row.getRowNum(),row.getRowNum(),3,3);
                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getPaperType());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getJournalName());
                }else{
                    row.createCell(4).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getIssueNumber());
                }else{
                    row.createCell(5).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("发表语言"),row.getRowNum(),row.getRowNum(),6,6);
                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getPublishingLanguage());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getDOI());
                }else{
                    row.createCell(7).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否ESI收录"),row.getRowNum(),row.getRowNum(),8,8);
                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getWhetherEsIIsIncluded());
                }else{
                    row.createCell(8).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("收录索引"),row.getRowNum(),row.getRowNum(),9,9);
                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getIndex());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getAuthorOrder());
                }else{
                    row.createCell(10).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否通讯作者"),row.getRowNum(),row.getRowNum(),9,9);
                if(o1!=null){
                    row.createCell(11).setCellValue(o1.getWhetherCorrespondingAuthor());
                }else{
                    row.createCell(11).setCellValue("");
                }
            }

        }

        //   空格分隔
        Row gap1 = sheet3.createRow(sheet3StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("论文类型"),gap1.getRowNum(),gap1.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("发表语言"),gap1.getRowNum(),gap1.getRowNum(),6,6);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否ESI收录"),gap1.getRowNum(),gap1.getRowNum(),8,8);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("收录索引"),gap1.getRowNum(),gap1.getRowNum(),9,9);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否通讯作者"),gap1.getRowNum(),gap1.getRowNum(),9,9);

        Row gap2 = sheet3.createRow(sheet3StartIndex++);
        gap2.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("论文类型"),gap2.getRowNum(),gap2.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("发表语言"),gap2.getRowNum(),gap2.getRowNum(),6,6);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否ESI收录"),gap2.getRowNum(),gap2.getRowNum(),8,8);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("收录索引"),gap2.getRowNum(),gap2.getRowNum(),9,9);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否通讯作者"),gap2.getRowNum(),gap2.getRowNum(),9,9);


        Row gap3 = sheet3.createRow(sheet3StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("论文类型"),gap3.getRowNum(),gap3.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("发表语言"),gap3.getRowNum(),gap3.getRowNum(),6,6);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否ESI收录"),gap3.getRowNum(),gap3.getRowNum(),8,8);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("收录索引"),gap3.getRowNum(),gap3.getRowNum(),9,9);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否通讯作者"),gap3.getRowNum(),gap3.getRowNum(),9,9);

        return sheet3StartIndex;
    }

    /**
     *  表2-2-2 下载
     */

    public  Integer exportByClass2_2_2(List<ResearchAwards_2_2_2_shiqi> list, Sheet sheet3,Integer sheet3StartIndex,String nameByIdNum,Workbook wbss){
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

        rowx0.createCell(0).setCellValue("表2-2-2 科研获奖情况（时期）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        rowx0.getCell(0).setCellStyle(cellStyle);

        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("获奖级别");
        rowx1.createCell(3).setCellValue("奖项名称");
        rowx1.createCell(4).setCellValue("本单位是否为第一完成单位");
        rowx1.createCell(5).setCellValue("获奖类别");
        rowx1.createCell(6).setCellValue("获奖等级");
        rowx1.createCell(7).setCellValue("获奖日期");
        rowx1.createCell(8).setCellValue("颁奖单位");
        rowx1.createCell(9).setCellValue("获奖证书编号");
        rowx1.createCell(10).setCellValue("完成单位排名");
        rowx1.createCell(11).setCellValue("本人排序");


        for (int i = 0 ; i<=11;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }

        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet3.createRow(sheet3StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                ResearchAwards_2_2_2_shiqi o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖级别"),row.getRowNum(),row.getRowNum(),2,2);
                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getAwardLevel());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getAwardName());
                }else{
                    row.createCell(3).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("本单位是否为第一完成单位"),row.getRowNum(),row.getRowNum(),4,4);
                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getWhetherFirstCompletedUnit());
                }else{
                    row.createCell(4).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖类别"),row.getRowNum(),row.getRowNum(),5,5);
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getAwardCategory());
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
                    row.createCell(7).setCellValue(o1.getAwardDate());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getAwardingUnit());
                }else{
                    row.createCell(8).setCellValue("");
                }


                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getAwardCertificateNumber());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getCompleteUnitRanking());
                }else{
                    row.createCell(10).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(11).setCellValue(o1.getSortByName());
                }else{
                    row.createCell(11).setCellValue("");
                }
            }


        }


        //   空格分隔
        Row gap1 = sheet3.createRow(sheet3StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖级别"),gap1.getRowNum(),gap1.getRowNum(),2,2);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("本单位是否为第一完成单位"),gap1.getRowNum(),gap1.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖类别"),gap1.getRowNum(),gap1.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖等级"),gap1.getRowNum(),gap1.getRowNum(),6,6);


        Row gap2 = sheet3.createRow(sheet3StartIndex++);
        gap2.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖级别"),gap2.getRowNum(),gap2.getRowNum(),2,2);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("本单位是否为第一完成单位"),gap2.getRowNum(),gap2.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖类别"),gap2.getRowNum(),gap2.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖等级"),gap2.getRowNum(),gap2.getRowNum(),6,6);


        Row gap3 = sheet3.createRow(sheet3StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖级别"),gap3.getRowNum(),gap3.getRowNum(),2,2);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("本单位是否为第一完成单位"),gap3.getRowNum(),gap3.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖类别"),gap3.getRowNum(),gap3.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("获奖等级"),gap3.getRowNum(),gap3.getRowNum(),6,6);

        return sheet3StartIndex;
    }


    /**
     *  表2-2-3 下载
     */

    public  Integer exportByClass2_2_3(List<PublicationStatus_2_2_3_shiqi> list, Sheet sheet3,Integer sheet3StartIndex,String nameByIdNum,Workbook wbss){
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


        rowx0.createCell(0).setCellValue("表2-2-3 出版著作情况（时期）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        rowx0.getCell(0).setCellStyle(cellStyle);


        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("著作名称");
        rowx1.createCell(3).setCellValue("著作类别");
        rowx1.createCell(4).setCellValue("出版社");
        rowx1.createCell(5).setCellValue("出版社所在国家（地区）");
        rowx1.createCell(6).setCellValue("总字数（万字）");
        rowx1.createCell(7).setCellValue("发行数（册）");
        rowx1.createCell(8).setCellValue("出版日期");
        rowx1.createCell(9).setCellValue("书号（ISBN）");
        rowx1.createCell(10).setCellValue("语种");
        rowx1.createCell(11).setCellValue("本人角色");

        for (int i = 0; i<=11;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }


        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet3.createRow(sheet3StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                PublicationStatus_2_2_3_shiqi o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getBookName());
                }else{
                    row.createCell(2).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("著作类别"),row.getRowNum(),row.getRowNum(),3,3);
                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getBookType());
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
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("语种"),row.getRowNum(),row.getRowNum(),10,10);
                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getLanguage());
                }else{
                    row.createCell(10).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("出版著作情况本人角色"),row.getRowNum(),row.getRowNum(),11,11);
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
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("著作类别"),gap1.getRowNum(),gap1.getRowNum(),3,3);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("国家"),gap1.getRowNum(),gap1.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("语种"),gap1.getRowNum(),gap1.getRowNum(),10,10);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("出版著作情况本人角色"),gap1.getRowNum(),gap1.getRowNum(),11,11);



        Row gap2 = sheet3.createRow(sheet3StartIndex++);
        gap2.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("著作类别"),gap2.getRowNum(),gap2.getRowNum(),3,3);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("国家"),gap2.getRowNum(),gap2.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("语种"),gap2.getRowNum(),gap2.getRowNum(),10,10);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("出版著作情况本人角色"),gap2.getRowNum(),gap2.getRowNum(),11,11);



        Row gap3 = sheet3.createRow(sheet3StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("著作类别"),gap3.getRowNum(),gap3.getRowNum(),3,3);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("国家"),gap3.getRowNum(),gap3.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("语种"),gap3.getRowNum(),gap3.getRowNum(),10,10);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("出版著作情况本人角色"),gap3.getRowNum(),gap3.getRowNum(),11,11);



        return sheet3StartIndex;
    }

    /**
     *  表2-2-4 下载
     */

    public  Integer exportByClass2_2_4(List<PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi> list, Sheet sheet3,Integer sheet3StartIndex,String nameByIdNum,Workbook wbss){
        // 分隔  表开始位置
        Row rowx0 = sheet3.createRow(sheet3StartIndex++);
        // 表头
        Row rowx1 = sheet3.createRow(sheet3StartIndex++);


        rowx0.createCell(0).setCellValue("表2-2-4  专利（著作权）授权情况（时期）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        rowx0.getCell(0).setCellStyle(cellStyle);



        /**
         *    加粗字端名
         */

        CellStyle fontcellStyle = wbss.createCellStyle();
        HSSFFont titleFont = (HSSFFont) wbss.createFont();
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        fontcellStyle.setFont(titleFont);


        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("专利（著作权）名称");
        rowx1.createCell(3).setCellValue("知识产权类别");
        rowx1.createCell(4).setCellValue("授权号");
        rowx1.createCell(5).setCellValue("获批日期");
        rowx1.createCell(6).setCellValue("本人排序");
        rowx1.createCell(7).setCellValue("本单位是否为第一申请单位");
        rowx1.createCell(8).setCellValue("是否行业联合专利（著作权）");

        for (int i = 0; i<=8;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }


        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet3.createRow(sheet3StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getPatentOrBookName());
                }else{
                    row.createCell(2).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("知识产权类别"),row.getRowNum(),row.getRowNum(),3,3);
                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getIntellectualPropertyCategory());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getAuthorizationNumber());
                }else{
                    row.createCell(4).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getApprovedDate());
                }else{
                    row.createCell(5).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getSortByMe());
                }else{
                    row.createCell(6).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("本单位是否为第一申请单位"),row.getRowNum(),row.getRowNum(),7,7);
                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getWhetherUnitIsFirstApplicationUnit());
                }else{
                    row.createCell(7).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否行业联合专利"),row.getRowNum(),row.getRowNum(),8,8);
                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getWhetherIndustryJointPatent());
                }else{
                    row.createCell(8).setCellValue("");
                }
            }


        }

        //   空格分隔
        Row gap1 = sheet3.createRow(sheet3StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("知识产权类别"),gap1.getRowNum(),gap1.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("本单位是否为第一申请单位"),gap1.getRowNum(),gap1.getRowNum(),7,7);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否行业联合专利"),gap1.getRowNum(),gap1.getRowNum(),8,8);



        Row gap2 = sheet3.createRow(sheet3StartIndex++);
        gap2.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("知识产权类别"),gap2.getRowNum(),gap2.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("本单位是否为第一申请单位"),gap2.getRowNum(),gap2.getRowNum(),7,7);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否行业联合专利"),gap2.getRowNum(),gap2.getRowNum(),8,8);

        Row gap3 = sheet3.createRow(sheet3StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("知识产权类别"),gap3.getRowNum(),gap3.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("本单位是否为第一申请单位"),gap3.getRowNum(),gap3.getRowNum(),7,7);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否行业联合专利"),gap3.getRowNum(),gap3.getRowNum(),8,8);


        return sheet3StartIndex;
    }



    /**
     *  表2-2-5 下载
     */

    public  Integer exportByClass2_2_5(List<ParticipationInternationalAcademicConferences_2_2_5_shiqi> list, Sheet sheet3,Integer sheet3StartIndex,String nameByIdNum,Workbook wbss){
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


        rowx0.createCell(0).setCellValue("表2-2-5 参加国际学术会议情况（时期）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        rowx0.getCell(0).setCellStyle(cellStyle);


        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("学术会议名");
        rowx1.createCell(3).setCellValue("主办单位");
        rowx1.createCell(4).setCellValue("会议举办所在国家/地区");
        rowx1.createCell(5).setCellValue("会议举办所在城市");
        rowx1.createCell(6).setCellValue("会议开幕日期");
        rowx1.createCell(7).setCellValue("是否为大会主席");
        rowx1.createCell(8).setCellValue("报告类型");
        rowx1.createCell(9).setCellValue("报告题目");
        rowx1.createCell(10).setCellValue("报告日期");
        rowx1.createCell(11).setCellValue("报告人");


        for (int i = 0 ; i<= 11;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }


        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet3.createRow(sheet3StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                ParticipationInternationalAcademicConferences_2_2_5_shiqi o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getAcademicConferenceName());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getOrganizer());
                }else{
                    row.createCell(3).setCellValue("");
                }
                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("国家"),row.getRowNum(),row.getRowNum(),4,4);
                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getConferenceHeldCountryOrRegion());
                }else{
                    row.createCell(4).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getConferenceCity());
                }else{
                    row.createCell(5).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getOpeningDateOfMeeting());
                }else{
                    row.createCell(6).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否为大会主席"),row.getRowNum(),row.getRowNum(),7,7);
                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getWhetherChairmanOfConference());
                }else{
                    row.createCell(7).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("报告类型"),row.getRowNum(),row.getRowNum(),8,8);

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getReportType());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getReportName());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getReportDate());
                }else{
                    row.createCell(10).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(11).setCellValue(o1.getReporter());
                }else{
                    row.createCell(11).setCellValue("");
                }
            }


        }

        //   空格分隔
        Row gap1 = sheet3.createRow(sheet3StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("国家"),gap1.getRowNum(),gap1.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否为大会主席"),gap1.getRowNum(),gap1.getRowNum(),7,7);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("报告类型"),gap1.getRowNum(),gap1.getRowNum(),8,8);



        Row gap2 = sheet3.createRow(sheet3StartIndex++);
        gap2.createCell(0).setCellValue("");
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("国家"),gap2.getRowNum(),gap2.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否为大会主席"),gap2.getRowNum(),gap2.getRowNum(),7,7);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("报告类型"),gap2.getRowNum(),gap2.getRowNum(),8,8);



        Row gap3 = sheet3.createRow(sheet3StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("国家"),gap3.getRowNum(),gap3.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("是否为大会主席"),gap3.getRowNum(),gap3.getRowNum(),7,7);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("报告类型"),gap3.getRowNum(),gap3.getRowNum(),8,8);



        return sheet3StartIndex;
    }





    /**
     *  表2-2-6 下载
     */

    public  Integer exportByClass2_2_6(List<AcademicAppointment_2_2_6_shidian> list, Sheet sheet3,Integer sheet3StartIndex,String nameByIdNum,Workbook wbss){
        // 分隔  表开始位置
        Row rowx0 = sheet3.createRow(sheet3StartIndex++);
        // 表头
        Row rowx1 = sheet3.createRow(sheet3StartIndex++);


        rowx0.createCell(0).setCellValue("表2-2-6 学术任职情况（时点）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        rowx0.getCell(0).setCellStyle(cellStyle);

        /**
         *    加粗字端名
         */

        CellStyle fontcellStyle = wbss.createCellStyle();
        HSSFFont titleFont = (HSSFFont) wbss.createFont();
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        fontcellStyle.setFont(titleFont);



        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("职务名称");
        rowx1.createCell(3).setCellValue("职务级别");
        rowx1.createCell(4).setCellValue("任职组织");
        rowx1.createCell(5).setCellValue("组织类型");
        rowx1.createCell(6).setCellValue("开始任职年月");

        for (int i = 0 ;i <=6;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }


        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet3.createRow(sheet3StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                AcademicAppointment_2_2_6_shidian o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getJobTitle());
                }else{
                    row.createCell(2).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("职务级别"),row.getRowNum(),row.getRowNum(),3,3);
                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getJobLevel());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getEmploymentOrganization());
                }else{
                    row.createCell(4).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("组织类型"),row.getRowNum(),row.getRowNum(),5,5);
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getOrganizationType());
                }else{
                    row.createCell(5).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getStartOfOffice());
                }else{
                    row.createCell(6).setCellValue("");
                }

            }


        }


        //   空格分隔
        Row gap1 = sheet3.createRow(sheet3StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("职务级别"),gap1.getRowNum(),gap1.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("组织类型"),gap1.getRowNum(),gap1.getRowNum(),5,5);


        Row gap2 = sheet3.createRow(sheet3StartIndex++);
        gap2.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("职务级别"),gap2.getRowNum(),gap2.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("组织类型"),gap2.getRowNum(),gap2.getRowNum(),5,5);



        Row gap3 = sheet3.createRow(sheet3StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("职务级别"),gap3.getRowNum(),gap3.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("组织类型"),gap3.getRowNum(),gap3.getRowNum(),5,5);



        return sheet3StartIndex;
    }


    /**
     *  表2-2-7 下载
     */

    public  Integer exportByClass2_2_7(List<RelyingOnScientificResearchPlatform_2_2_7_shidian> list, Sheet sheet3,Integer sheet3StartIndex,String nameByIdNum,Workbook wbss){
        // 分隔  表开始位置
        Row rowx0 = sheet3.createRow(sheet3StartIndex++);
        // 表头
        Row rowx1 = sheet3.createRow(sheet3StartIndex++);


        rowx0.createCell(0).setCellValue("表2-2-7 依托科研平台情况（时点）");

        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        rowx0.getCell(0).setCellStyle(cellStyle);


        /**
         *    加粗字端名
         */

        CellStyle fontcellStyle = wbss.createCellStyle();
        HSSFFont titleFont = (HSSFFont) wbss.createFont();
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        fontcellStyle.setFont(titleFont);

        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("科研平台名称");
        rowx1.createCell(3).setCellValue("科研平台级别");
        rowx1.createCell(4).setCellValue("科研平台类别");
        rowx1.createCell(5).setCellValue("省部级主管部门");
        rowx1.createCell(6).setCellValue("任职");


        for (int i = 0; i <= 6;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }

        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet3.createRow(sheet3StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                RelyingOnScientificResearchPlatform_2_2_7_shidian o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getResearchPlatformName());
                }else{
                    row.createCell(2).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("科研平台级别"),row.getRowNum(),row.getRowNum(),3,3);
                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getResearchPlatformLevel());
                }else{
                    row.createCell(3).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("科研平台类别"),row.getRowNum(),row.getRowNum(),4,4);
                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getResearchPlatformCategory());
                }else{
                    row.createCell(4).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getProvincialAndMinisterialAuthorities());
                }else{
                    row.createCell(5).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("任职"),row.getRowNum(),row.getRowNum(),6,6);
                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getServe());
                }else{
                    row.createCell(6).setCellValue("");
                }

            }


        }

/*
        Row gap1 = sheet3.createRow(sheet3StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("科研平台级别"),gap1.getRowNum(),gap1.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("科研平台类别"),gap1.getRowNum(),gap1.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("任职"),gap1.getRowNum(),gap1.getRowNum(),6,6);

        Row gap2 = sheet3.createRow(sheet3StartIndex++);
        gap2.createCell(0).setCellValue("");

        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("科研平台级别"),gap2.getRowNum(),gap2.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("科研平台类别"),gap2.getRowNum(),gap2.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("任职"),gap2.getRowNum(),gap2.getRowNum(),6,6);


        Row gap3 = sheet3.createRow(sheet3StartIndex++);
        gap3.createCell(0).setCellValue("");

        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("科研平台级别"),gap3.getRowNum(),gap3.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("科研平台类别"),gap3.getRowNum(),gap3.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet3,dictionaryMapper.getValueByFiledName("任职"),gap3.getRowNum(),gap3.getRowNum(),6,6);*/
        return sheet3StartIndex;
    }

}
