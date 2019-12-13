package com.ccnu.phdsic.service.impl;

import com.ccnu.phdsic.entities.DoctorStudentInformation_1_1_2_shiqi;
import com.ccnu.phdsic.entities.DoctorTutorInformation_1_1_1_shidian;
import com.ccnu.phdsic.entities.DoctorTutorInformation_1_1_1_xu1_shidian;
import com.ccnu.phdsic.entities.DoctorTutorInformation_1_1_1_xu2_shidian;
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
public class Export_1_1_ {



    @Autowired
    DictionaryMapper dictionaryMapper;


    /**
     *   1.1  基础信息下载
     */


    /**
     *  表 1-1-1 下载
     *
     */
    public  Integer exportByClass1_1_1(List<DoctorTutorInformation_1_1_1_shidian> list, Sheet sheet,Integer sheet1StartIndex,Workbook wbss){

        Row rowIntroduction = sheet.createRow(sheet1StartIndex++);

        String text="说明：\r\n1. 统计时点：是指统计数据的调查截止时间（2019年的8月31日）。\r\n2. 统计时期：是指统计数据的调查区间时间（2018年的9月1日至2019年的8月31日）。 \r\n3. 表1-1-2（博士生信息表）是指统计时期内导师所指导的博士生（含留学生、港澳台学生），包括在统计期间内已毕业的博士生和2019级入学的博士新生。\r\n4. 表格中的现有数据为研究生院学位办整合相关职能部门的基础数据后填入，请相关研究生培养单位根据实际情况进一步补充、完善、修正，再发给导师个人完善、校对。";
        System.out.println(text);

        // 创建单元格
        rowIntroduction.createCell(0);
        rowIntroduction.getCell(0).setCellValue(text);


        //  合并单元格
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 6);
        sheet.addMergedRegion(region);

        // 设置高度
        rowIntroduction.setHeight((short) (90*20));

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
        Row rowx0 = sheet.createRow(sheet1StartIndex++);
        // 表头
        Row rowx1 = sheet.createRow(sheet1StartIndex++);


        rowx0.createCell(0).setCellValue("表1-1-1 博士导师信息（时点）");

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
        rowx1.createCell(2).setCellValue("所属学院(单位)");
        rowx1.createCell(3).setCellValue("国家(地区)");
        rowx1.createCell(4).setCellValue("证件类型");
        rowx1.createCell(5).setCellValue("证件号码");
        rowx1.createCell(6).setCellValue("出生日期");
        rowx1.createCell(7).setCellValue("性别");
        rowx1.createCell(8).setCellValue("民族");
        rowx1.createCell(9).setCellValue("政治面貌");
        rowx1.createCell(10).setCellValue("最高学历");
        rowx1.createCell(11).setCellValue("获得最高学历的国家(地区)");
        rowx1.createCell(12).setCellValue("获得最高学历的院校或机构");
        rowx1.createCell(13).setCellValue("获最高学历所学专业");
        rowx1.createCell(14).setCellValue("最高学位层次");
        rowx1.createCell(15).setCellValue("最高学位名称");
        rowx1.createCell(16).setCellValue("获最高学位的国家(地区)");
        rowx1.createCell(17).setCellValue("获最高学位的院校或机构");

        for (int i = 0 ; i <= 17 ;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }



        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet.createRow(sheet1StartIndex++);
                DoctorTutorInformation_1_1_1_shidian o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getName());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getCollege());
                }else{
                    row.createCell(2).setCellValue("");
                }

                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),row.getRowNum(),row.getRowNum(),3,3);
                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getCountry());
                }else{
                    row.createCell(3).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("证件类型"),row.getRowNum(),row.getRowNum(),4,4);

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getTypeOfCertificate());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getCertificateNumber());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getBirthday());
                }else{
                    row.createCell(6).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("性别"),row.getRowNum(),row.getRowNum(),7,7);
                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getSex());
                }else{
                    row.createCell(7).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("民族"),row.getRowNum(),row.getRowNum(),8,8);
                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getNationality());
                }else{
                    row.createCell(8).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("政治面貌"),row.getRowNum(),row.getRowNum(),9,9);
                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getPoliticalStatus());
                }else{
                    row.createCell(9).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("最高学历"),row.getRowNum(),row.getRowNum(),10,10);
                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getHighestEducation());
                }else{
                    row.createCell(10).setCellValue("");
                }

                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),row.getRowNum(),row.getRowNum(),11,11);
                if(o1!=null){
                    row.createCell(11).setCellValue(o1.getObtainHighestEducationCountry());
                }else{
                    row.createCell(11).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(12).setCellValue(o1.getInstitutionWithHighestDegree());
                }else{
                    row.createCell(12).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(13).setCellValue(o1.getMajorHighestDegree());
                }else{
                    row.createCell(13).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("最高学位层次"),row.getRowNum(),row.getRowNum(),14,14);
                if(o1!=null){
                    row.createCell(14).setCellValue(o1.getHighestDegreeLevel());
                }else{
                    row.createCell(14).setCellValue("");
                }

                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("最高学位名称"),row.getRowNum(),row.getRowNum(),15,15);
                if(o1!=null){
                    row.createCell(15).setCellValue(o1.getNameByHighestDegree());
                }else{
                    row.createCell(15).setCellValue("");
                }
                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),row.getRowNum(),row.getRowNum(),16,16);
                if(o1!=null){
                    row.createCell(16).setCellValue(o1.getCountryWithTheHighestDegree());
                }else{
                    row.createCell(16).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(17).setCellValue(o1.getHighestDegreeInstitution());
                }else{
                    row.createCell(17).setCellValue("");
                }

            }

        }



        //   空格分隔
        Row gap1 = sheet.createRow(sheet1StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),gap1.getRowNum(),gap1.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("证件类型"),gap1.getRowNum(),gap1.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("性别"),gap1.getRowNum(),gap1.getRowNum(),7,7);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("民族"),gap1.getRowNum(),gap1.getRowNum(),8,8);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("政治面貌"),gap1.getRowNum(),gap1.getRowNum(),9,9);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("最高学历"),gap1.getRowNum(),gap1.getRowNum(),10,10);
       DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),gap1.getRowNum(),gap1.getRowNum(),11,11);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("最高学位层次"),gap1.getRowNum(),gap1.getRowNum(),14,14);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("最高学位名称"),gap1.getRowNum(),gap1.getRowNum(),15,15);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),gap1.getRowNum(),gap1.getRowNum(),16,16);


        Row gap2 = sheet.createRow(sheet1StartIndex++);
        gap2.createCell(0).setCellValue("");
       DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),gap2.getRowNum(),gap2.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("证件类型"),gap2.getRowNum(),gap2.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("性别"),gap2.getRowNum(),gap2.getRowNum(),7,7);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("民族"),gap2.getRowNum(),gap2.getRowNum(),8,8);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("政治面貌"),gap2.getRowNum(),gap2.getRowNum(),9,9);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("最高学历"),gap2.getRowNum(),gap2.getRowNum(),10,10);
       DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),gap2.getRowNum(),gap2.getRowNum(),11,11);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("最高学位层次"),gap2.getRowNum(),gap2.getRowNum(),14,14);
       DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("最高学位名称"),gap2.getRowNum(),gap2.getRowNum(),15,15);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),gap2.getRowNum(),gap2.getRowNum(),16,16);



        Row gap3 = sheet.createRow(sheet1StartIndex++);
        gap3.createCell(0).setCellValue("");

       DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),gap3.getRowNum(),gap3.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("证件类型"),gap3.getRowNum(),gap3.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("性别"),gap3.getRowNum(),gap3.getRowNum(),7,7);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("民族"),gap3.getRowNum(),gap3.getRowNum(),8,8);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("政治面貌"),gap3.getRowNum(),gap3.getRowNum(),9,9);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("最高学历"),gap3.getRowNum(),gap3.getRowNum(),10,10);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),gap3.getRowNum(),gap3.getRowNum(),11,11);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("最高学位层次"),gap3.getRowNum(),gap3.getRowNum(),14,14);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("最高学位名称"),gap3.getRowNum(),gap3.getRowNum(),15,15);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),gap3.getRowNum(),gap3.getRowNum(),16,16);

        return sheet1StartIndex;
    }

    /**
     *  表 1-1-1 (续1)  下载
     */


        public  Integer exportByClass1_1_1_xu1(List<DoctorTutorInformation_1_1_1_xu1_shidian> list, Sheet sheet,Integer sheet1StartIndex,String nameByIdNum,Workbook wbss){

            //  分隔符
            Row row0 = sheet.createRow((sheet1StartIndex++));
            row0.createCell(0).setCellValue("表1-1-1博士导师信息（续1）（时点)");
            HSSFFont font = (HSSFFont) wbss.createFont();
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
            font.setColor(Font.COLOR_RED);
            CellStyle cellStyle = wbss.createCellStyle();
            cellStyle.setFont(font);
            row0.getCell(0).setCellStyle(cellStyle);


            /**
             *    加粗字端名
             */

            CellStyle fontcellStyle = wbss.createCellStyle();
            HSSFFont titleFont = (HSSFFont) wbss.createFont();
            titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
            fontcellStyle.setFont(titleFont);
            // 表头
            Row rowx1 = sheet.createRow(sheet1StartIndex++);


            rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");

        rowx1.createCell(2).setCellValue("参加工作日期");
        rowx1.createCell(3).setCellValue("首次具有博士生招生资格日期");
        rowx1.createCell(4).setCellValue("是否在编");
        rowx1.createCell(5).setCellValue("是否与填报单位签订聘用合同");
        rowx1.createCell(6).setCellValue("聘用期限");
        rowx1.createCell(7).setCellValue("是否于填报单位承担全职工作");
        rowx1.createCell(8).setCellValue("全职工作单位");
        rowx1.createCell(9).setCellValue("是否为离退休人员");
        rowx1.createCell(10).setCellValue("聘任专业技术职务");
        rowx1.createCell(11).setCellValue("岗位等级");
        rowx1.createCell(12).setCellValue("党政职务");
        rowx1.createCell(13).setCellValue("海外研修（访学）经历");

        rowx1.createCell(14).setCellValue("入选人才项目名称及入选年份");
        rowx1.createCell(15).setCellValue("是否具有其他行业技术职称");
        rowx1.createCell(16).setCellValue("是否具有国内外学术兼职");

        for (int i = 0; i<=16;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }



        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet.createRow(sheet1StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                DoctorTutorInformation_1_1_1_xu1_shidian o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getParticipationDate());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getFirstDateOfAdmissionToDoctoralStudents());
                }else{
                    row.createCell(3).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否在编"),row.getRowNum(),row.getRowNum(),4,4);
                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getInTheStaff());
                }else{
                    row.createCell(4).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否与填报单位签订聘用合同"),row.getRowNum(),row.getRowNum(),5,5);
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getSignContractWithInstitution());
                }else{
                    row.createCell(5).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("聘用期限"),row.getRowNum(),row.getRowNum(),6,6);
                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getEmploymentPeriod());
                }else{
                    row.createCell(6).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否于填报单位承担全职工作"),row.getRowNum(),row.getRowNum(),7,7);
                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getFullTimeJobInUnit());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getFullTimeJobUnit());
                }else{
                    row.createCell(8).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否为离退休人员"),row.getRowNum(),row.getRowNum(),9,9);
                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getIsRetire());
                }else{
                    row.createCell(9).setCellValue("");
                }

                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("聘任专业技术职务"),row.getRowNum(),row.getRowNum(),10,10);
                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getProfessionalAndTechnicalPositions());
                }else{
                    row.createCell(10).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("岗位等级"),row.getRowNum(),row.getRowNum(),11,11);
                if(o1!=null){
                    row.createCell(11).setCellValue(o1.getPostRating());
                }else{
                    row.createCell(11).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("党政职务"),row.getRowNum(),row.getRowNum(),12,12);
                if(o1!=null){
                    row.createCell(12).setCellValue(o1.getPartyAndGovernmentDuties());
                }else{
                    row.createCell(12).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("海外研修（访学）经历"),row.getRowNum(),row.getRowNum(),13,13);
                if(o1!=null){
                    row.createCell(13).setCellValue(o1.getOverseasTrainingExperience());
                }else{
                    row.createCell(13).setCellValue("");
                }

                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("入选人才项目名称及入选年份"),row.getRowNum(),row.getRowNum(),14,14);
                if(o1!=null){
                    row.createCell(14).setCellValue(o1.getNameOfSelectedTalentProjectAndYearOfSelection());
                }else{
                    row.createCell(14).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否具有其他行业技术职称"),row.getRowNum(),row.getRowNum(),15,15);
                if(o1!=null){
                    row.createCell(15).setCellValue(o1.getHaveOtherIndustryTechnicalTitles());
                }else{
                    row.createCell(15).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否具有国内外学术兼职"),row.getRowNum(),row.getRowNum(),16,16);
                if(o1!=null){
                    row.createCell(16).setCellValue(o1.getHaveAcademicPartTimeAtHomeAndAbroad());
                }else{
                    row.createCell(16).setCellValue("");
                }

            }


        }

            //   空格分隔
            Row gap1 = sheet.createRow(sheet1StartIndex++);
            gap1.createCell(0).setCellValue("");


            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否在编"),gap1.getRowNum(),gap1.getRowNum(),4,4);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否与填报单位签订聘用合同"),gap1.getRowNum(),gap1.getRowNum(),5,5);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("聘用期限"),gap1.getRowNum(),gap1.getRowNum(),6,6);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否于填报单位承担全职工作"),gap1.getRowNum(),gap1.getRowNum(),7,7);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否为离退休人员"),gap1.getRowNum(),gap1.getRowNum(),9,9);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("岗位等级"),gap1.getRowNum(),gap1.getRowNum(),11,11);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("党政职务"),gap1.getRowNum(),gap1.getRowNum(),12,12);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("海外研修（访学）经历"),gap1.getRowNum(),gap1.getRowNum(),13,13);
            DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("入选人才项目名称及入选年份"),gap1.getRowNum(),gap1.getRowNum(),14,14);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否具有其他行业技术职称"),gap1.getRowNum(),gap1.getRowNum(),15,15);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否具有国内外学术兼职"),gap1.getRowNum(),gap1.getRowNum(),16,16);
            DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("聘任专业技术职务"),gap1.getRowNum(),gap1.getRowNum(),10,10);




            Row gap2 = sheet.createRow(sheet1StartIndex++);
            gap2.createCell(0).setCellValue("");


            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否在编"),gap2.getRowNum(),gap2.getRowNum(),4,4);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否与填报单位签订聘用合同"),gap2.getRowNum(),gap2.getRowNum(),5,5);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("聘用期限"),gap2.getRowNum(),gap2.getRowNum(),6,6);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否于填报单位承担全职工作"),gap2.getRowNum(),gap2.getRowNum(),7,7);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否为离退休人员"),gap2.getRowNum(),gap2.getRowNum(),9,9);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("岗位等级"),gap2.getRowNum(),gap2.getRowNum(),11,11);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("党政职务"),gap2.getRowNum(),gap2.getRowNum(),12,12);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("海外研修（访学）经历"),gap2.getRowNum(),gap2.getRowNum(),13,13);
            DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("入选人才项目名称及入选年份"),gap2.getRowNum(),gap2.getRowNum(),14,14);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否具有其他行业技术职称"),gap2.getRowNum(),gap2.getRowNum(),15,15);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否具有国内外学术兼职"),gap2.getRowNum(),gap2.getRowNum(),16,16);
            DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("聘任专业技术职务"),gap2.getRowNum(),gap2.getRowNum(),10,10);



            Row gap3 = sheet.createRow(sheet1StartIndex++);
            gap3.createCell(0).setCellValue("");

            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否在编"),gap3.getRowNum(),gap3.getRowNum(),4,4);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否与填报单位签订聘用合同"),gap3.getRowNum(),gap3.getRowNum(),5,5);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("聘用期限"),gap3.getRowNum(),gap3.getRowNum(),6,6);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否于填报单位承担全职工作"),gap3.getRowNum(),gap3.getRowNum(),7,7);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否为离退休人员"),gap3.getRowNum(),gap3.getRowNum(),9,9);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("岗位等级"),gap3.getRowNum(),gap3.getRowNum(),11,11);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("党政职务"),gap3.getRowNum(),gap3.getRowNum(),12,12);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("海外研修（访学）经历"),gap3.getRowNum(),gap3.getRowNum(),13,13);
           DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("入选人才项目名称及入选年份"),gap3.getRowNum(),gap3.getRowNum(),14,14);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否具有其他行业技术职称"),gap3.getRowNum(),gap3.getRowNum(),15,15);
            DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否具有国内外学术兼职"),gap3.getRowNum(),gap3.getRowNum(),16,16);
            DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("聘任专业技术职务"),gap3.getRowNum(),gap3.getRowNum(),10,10);



            return sheet1StartIndex;
    }

    /**
     *  表 1-1-1 (续2)  下载
     */
    public  Integer exportByClass1_1_1_xu2(List<DoctorTutorInformation_1_1_1_xu2_shidian> list, Sheet sheet,Integer sheet1StartIndex,String nameByIdNum,Workbook wbss){
        //  分隔符
        Row row0 = sheet.createRow((sheet1StartIndex++));
        row0.createCell(0).setCellValue("表1-1-1 博士导师信息表（续2）（时点）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        row0.getCell(0).setCellStyle(cellStyle);

        // 表头
        Row rowx1 = sheet.createRow(sheet1StartIndex++);

        /**
         *    加粗字端名
         */

        CellStyle fontcellStyle = wbss.createCellStyle();
        HSSFFont titleFont = (HSSFFont) wbss.createFont();
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        fontcellStyle.setFont(titleFont);

        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("导师类别");
        rowx1.createCell(3).setCellValue("是否有国际合作");
        rowx1.createCell(4).setCellValue("可指导博士生类型");
        rowx1.createCell(5).setCellValue("现所属一级学科");
        rowx1.createCell(6).setCellValue("现所属二级学科");
        rowx1.createCell(7).setCellValue("可指导专业学位类型");
        rowx1.createCell(8).setCellValue("所指导填报单位硕士生在读人数（人）");

        for (int i = 0 ; i <= 8;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }





        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet.createRow(sheet1StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                DoctorTutorInformation_1_1_1_xu2_shidian o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("导师类别"),row.getRowNum(),row.getRowNum(),2,2);
                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getTutorCategory());
                }else{
                    row.createCell(2).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否有国际合作"),row.getRowNum(),row.getRowNum(),3,3);
                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getHaveInternationalCooperation());
                }else{
                    row.createCell(3).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("可指导博士生类型"),row.getRowNum(),row.getRowNum(),4,4);
                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getGuideDoctoralStudents());
                }else{
                    row.createCell(4).setCellValue("");
                }
                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属一级学科"),row.getRowNum(),row.getRowNum(),5,5);
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getFirstLevelSubject());
                }else{
                    row.createCell(5).setCellValue("");
                }
                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属二级学科"),row.getRowNum(),row.getRowNum(),6,6);
                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getSecondLevelSubject());
                }else{
                    row.createCell(6).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("可指导专业学位类型"),row.getRowNum(),row.getRowNum(),7,7);

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getGuideProfessionalDegreeTypes());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getNumberOfMasterStudentsEnrolledInTheUnit());
                }else{
                    row.createCell(8).setCellValue("");
                }
            }

        }

        //   空格分隔
        Row gap1 = sheet.createRow(sheet1StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("导师类别"),gap1.getRowNum(),gap1.getRowNum(),2,2);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否有国际合作"),gap1.getRowNum(),gap1.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("可指导博士生类型"),gap1.getRowNum(),gap1.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("可指导专业学位类型"),gap1.getRowNum(),gap1.getRowNum(),7,7);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属一级学科"),gap1.getRowNum(),gap1.getRowNum(),5,5);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属二级学科"),gap1.getRowNum(),gap1.getRowNum(),6,6);



        Row gap2 = sheet.createRow(sheet1StartIndex++);
        gap2.createCell(0).setCellValue("");

        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("导师类别"),gap2.getRowNum(),gap2.getRowNum(),2,2);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否有国际合作"),gap2.getRowNum(),gap2.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("可指导博士生类型"),gap2.getRowNum(),gap2.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("可指导专业学位类型"),gap2.getRowNum(),gap2.getRowNum(),7,7);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属一级学科"),gap2.getRowNum(),gap2.getRowNum(),5,5);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属二级学科"),gap2.getRowNum(),gap2.getRowNum(),6,6);



        Row gap3 = sheet.createRow(sheet1StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("导师类别"),gap3.getRowNum(),gap3.getRowNum(),2,2);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否有国际合作"),gap3.getRowNum(),gap3.getRowNum(),3,3);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("可指导博士生类型"),gap3.getRowNum(),gap3.getRowNum(),4,4);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("可指导专业学位类型"),gap3.getRowNum(),gap3.getRowNum(),7,7);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属一级学科"),gap3.getRowNum(),gap3.getRowNum(),5,5);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属二级学科"),gap3.getRowNum(),gap3.getRowNum(),6,6);


        return sheet1StartIndex;
    }


    /**
     *  表 1-1-2   下载
     */

    public  Integer exportByClass1_1_2(List<DoctorStudentInformation_1_1_2_shiqi> list, Sheet sheet,Integer sheet1StartIndex,String nameByIdNum,Workbook wbss){

        //  分隔符
        Row row0 = sheet.createRow((sheet1StartIndex++));
        row0.createCell(0).setCellValue("表1-1-2 博士生信息表（时期）");
        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setColor(Font.COLOR_RED);
        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        row0.getCell(0).setCellStyle(cellStyle);

        /**
         *    加粗字端名
         */

        CellStyle fontcellStyle = wbss.createCellStyle();
        HSSFFont titleFont = (HSSFFont) wbss.createFont();
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        fontcellStyle.setFont(titleFont);

        // 表头
        Row rowx1 = sheet.createRow(sheet1StartIndex++);

        rowx1.createCell(0).setCellValue("导师姓名");
        rowx1.createCell(1).setCellValue("导师信息门户号");
        rowx1.createCell(2).setCellValue("学号");
        rowx1.createCell(3).setCellValue("学生姓名");
        rowx1.createCell(4).setCellValue("院系");
        rowx1.createCell(5).setCellValue("学生类型");
        rowx1.createCell(6).setCellValue("学习方式");
        rowx1.createCell(7).setCellValue("国家（地区）");
        rowx1.createCell(8).setCellValue("民族");
        rowx1.createCell(9).setCellValue("学位类型");
        rowx1.createCell(10).setCellValue("现所属一级学科");
        rowx1.createCell(11).setCellValue("现所属二级学科");
        rowx1.createCell(12).setCellValue("现所属专业学位类别");
        rowx1.createCell(13).setCellValue("入学日期");
        rowx1.createCell(14).setCellValue("是否存在学籍变动");
        rowx1.createCell(15).setCellValue("学籍变动原因");
        rowx1.createCell(16).setCellValue("是否授予学位");



        for (int i = 0 ; i <= 16;i++){
            rowx1.getCell(i).setCellStyle(fontcellStyle);
        }


        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                Row row = sheet.createRow(sheet1StartIndex++);
                row.createCell(0).setCellValue(nameByIdNum);
                DoctorStudentInformation_1_1_2_shiqi o1=list.get(i);
                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getDoctoralStudentIdentificationCode());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getName());
                }else{
                    row.createCell(3).setCellValue("");
                }


                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getCollege());
                }else{
                    row.createCell(4).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学生类型"),row.getRowNum(),row.getRowNum(),5,5);
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getStudentType());
                }else{
                    row.createCell(5).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学习方式"),row.getRowNum(),row.getRowNum(),6,6);

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getWayOfLearning());
                }else{
                    row.createCell(6).setCellValue("");
                }
                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),row.getRowNum(),row.getRowNum(),7,7);
                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getCountry());
                }else{
                    row.createCell(7).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("民族"),row.getRowNum(),row.getRowNum(),8,8);

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getNationality());
                }else{
                    row.createCell(8).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学位类型"),row.getRowNum(),row.getRowNum(),9,9);
                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getDegreeType());
                }else{
                    row.createCell(9).setCellValue("");
                }
                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属一级学科"),row.getRowNum(),row.getRowNum(),10,10);
                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getFirstLevelSubject());
                }else{
                    row.createCell(10).setCellValue("");
                }
                DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属二级学科"),row.getRowNum(),row.getRowNum(),11,11);
                if(o1!=null){
                    row.createCell(11).setCellValue(o1.getSecondLevelSubject());
                }else{
                    row.createCell(11).setCellValue("");
                }
                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("可指导专业学位类型"),row.getRowNum(),row.getRowNum(),12,12);
                if(o1!=null){
                    row.createCell(12).setCellValue(o1.getCurrentProfessionalDegreeCategory());
                }else{
                    row.createCell(12).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(13).setCellValue(o1.getEntryDate());
                }else{
                    row.createCell(13).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否存在学籍变动"),row.getRowNum(),row.getRowNum(),14,14);
                if(o1!=null){
                    row.createCell(14).setCellValue(o1.getHaveChangeInStudentStatus());
                }else{
                    row.createCell(14).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学籍变动原因"),row.getRowNum(),row.getRowNum(),15,15);
                if(o1!=null){
                    row.createCell(15).setCellValue(o1.getReasonsForChangesInStudentStatus());
                }else{
                    row.createCell(15).setCellValue("");
                }

                DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否授予学位"),row.getRowNum(),row.getRowNum(),16,16);
                if(o1!=null){
                    row.createCell(16).setCellValue(o1.getWhetherToAwardDegree());
                }else{
                    row.createCell(16).setCellValue("");
                }

            }

        }

        //   空格分隔
        /*Row gap1 = sheet.createRow(sheet1StartIndex++);
        gap1.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学生类型"),gap1.getRowNum(),gap1.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学习方式"),gap1.getRowNum(),gap1.getRowNum(),6,6);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("民族"),gap1.getRowNum(),gap1.getRowNum(),8,8);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学位类型"),gap1.getRowNum(),gap1.getRowNum(),9,9);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("可指导专业学位类型"),gap1.getRowNum(),gap1.getRowNum(),12,12);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否存在学籍变动"),gap1.getRowNum(),gap1.getRowNum(),14,14);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学籍变动原因"),gap1.getRowNum(),gap1.getRowNum(),15,15);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否授予学位"),gap1.getRowNum(),gap1.getRowNum(),16,16);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),gap1.getRowNum(),gap1.getRowNum(),7,7);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属一级学科"),gap1.getRowNum(),gap1.getRowNum(),10,10);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属二级学科"),gap1.getRowNum(),gap1.getRowNum(),11,11);

        Row gap2 = sheet.createRow(sheet1StartIndex++);
        gap2.createCell(0).setCellValue("");

        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学生类型"),gap2.getRowNum(),gap2.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学习方式"),gap2.getRowNum(),gap2.getRowNum(),6,6);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("民族"),gap2.getRowNum(),gap2.getRowNum(),8,8);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学位类型"),gap2.getRowNum(),gap2.getRowNum(),9,9);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("可指导专业学位类型"),gap2.getRowNum(),gap2.getRowNum(),12,12);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否存在学籍变动"),gap2.getRowNum(),gap2.getRowNum(),14,14);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学籍变动原因"),gap2.getRowNum(),gap2.getRowNum(),15,15);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否授予学位"),gap2.getRowNum(),gap2.getRowNum(),16,16);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),gap2.getRowNum(),gap2.getRowNum(),7,7);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属一级学科"),gap2.getRowNum(),gap2.getRowNum(),10,10);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属二级学科"),gap2.getRowNum(),gap2.getRowNum(),11,11);

        Row gap3 = sheet.createRow(sheet1StartIndex++);
        gap3.createCell(0).setCellValue("");
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学生类型"),gap3.getRowNum(),gap3.getRowNum(),5,5);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学习方式"),gap3.getRowNum(),gap3.getRowNum(),6,6);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("民族"),gap3.getRowNum(),gap3.getRowNum(),8,8);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学位类型"),gap3.getRowNum(),gap3.getRowNum(),9,9);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("可指导专业学位类型"),gap3.getRowNum(),gap3.getRowNum(),12,12);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否存在学籍变动"),gap3.getRowNum(),gap3.getRowNum(),14,14);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("学籍变动原因"),gap3.getRowNum(),gap3.getRowNum(),15,15);
        DictionaryUtil.setHSSFValidation((HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("是否授予学位"),gap3.getRowNum(),gap3.getRowNum(),16,16);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("国家"),gap3.getRowNum(),gap3.getRowNum(),7,7);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属一级学科"),gap3.getRowNum(),gap3.getRowNum(),10,10);
        DictionaryMoreUtil.setHSSFValidation((HSSFWorkbook) wbss,(HSSFSheet)sheet,dictionaryMapper.getValueByFiledName("现所属二级学科"),gap3.getRowNum(),gap3.getRowNum(),11,11);*/
        return sheet1StartIndex;
    }

}
