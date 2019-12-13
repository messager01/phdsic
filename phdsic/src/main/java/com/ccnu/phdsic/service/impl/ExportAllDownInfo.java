package com.ccnu.phdsic.service.impl;

import com.ccnu.phdsic.entities.*;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/24 13:39
 */

@Service
public class ExportAllDownInfo {

    /**
     *  表 1-1-1 下载
     *
     */
    public static void exportAll1_1_1(List<DoctorTutorInformation_1_1_1_shidian> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表1-1-1 博士导师信息（时点）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 17);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("姓名");
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



        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                DoctorTutorInformation_1_1_1_shidian o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getName());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getCollege());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getCountry());
                }else{
                    row.createCell(3).setCellValue("");
                }

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

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getSex());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getNationality());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getPoliticalStatus());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getHighestEducation());
                }else{
                    row.createCell(10).setCellValue("");
                }

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

                if(o1!=null){
                    row.createCell(14).setCellValue(o1.getHighestDegreeLevel());
                }else{
                    row.createCell(14).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(15).setCellValue(o1.getNameByHighestDegree());
                }else{
                    row.createCell(15).setCellValue("");
                }

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

    }


    /**
     *  表 1-1-1 续1 下载
     *
     */
    public static void exportAll1_1_1_xu1(List<DoctorTutorInformation_1_1_1_xu1_shidian> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表1-1-1博士导师信息（续1）（时点)");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 15);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("参加工作日期");
        rowx1.createCell(2).setCellValue("首次具有博士生招生资格日期");
        rowx1.createCell(3).setCellValue("是否在编");
        rowx1.createCell(4).setCellValue("是否与填报单位签订聘用合同");
        rowx1.createCell(5).setCellValue("聘用期限");
        rowx1.createCell(6).setCellValue("是否于填报单位承担全职工作");
        rowx1.createCell(7).setCellValue("全职工作单位");
        rowx1.createCell(8).setCellValue("是否为离退休人员");
        rowx1.createCell(9).setCellValue("聘任专业技术职务");
        rowx1.createCell(10).setCellValue("岗位等级");
        rowx1.createCell(11).setCellValue("党政职务");
        rowx1.createCell(12).setCellValue("海外研修（访学）经历");
        rowx1.createCell(13).setCellValue("入选人才项目名称及入选年份");
        rowx1.createCell(14).setCellValue("是否具有其他行业技术职称");
        rowx1.createCell(15).setCellValue("是否具有国内外学术兼职");




        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                DoctorTutorInformation_1_1_1_xu1_shidian o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getParticipationDate());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getFirstDateOfAdmissionToDoctoralStudents());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getInTheStaff());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getSignContractWithInstitution());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getEmploymentPeriod());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getFullTimeJobInUnit());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getFullTimeJobUnit());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getIsRetire());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getProfessionalAndTechnicalPositions());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getPostRating());
                }else{
                    row.createCell(10).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(11).setCellValue(o1.getPartyAndGovernmentDuties());
                }else{
                    row.createCell(11).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(12).setCellValue(o1.getOverseasTrainingExperience());
                }else{
                    row.createCell(12).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(13).setCellValue(o1.getNameOfSelectedTalentProjectAndYearOfSelection());
                }else{
                    row.createCell(13).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(14).setCellValue(o1.getHaveOtherIndustryTechnicalTitles());
                }else{
                    row.createCell(14).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(15).setCellValue(o1.getHaveAcademicPartTimeAtHomeAndAbroad());
                }else{
                    row.createCell(15).setCellValue("");
                }


            }

        }

    }



    /**
     *  表 1-1-1 续2 下载
     *
     */
    public static void exportAll1_1_1_xu2(List<DoctorTutorInformation_1_1_1_xu2_shidian> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表1-1-1 博士导师信息表（续2）（时点）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 7);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("导师类别");
        rowx1.createCell(2).setCellValue("是否有国际合作");
        rowx1.createCell(3).setCellValue("可指导博士生类型");
        rowx1.createCell(4).setCellValue("现所属一级学科");
        rowx1.createCell(5).setCellValue("现所属二级学科");
        rowx1.createCell(6).setCellValue("可指导专业学位类型");
        rowx1.createCell(7).setCellValue("所指导填报单位硕士生在读人数（人）");





        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                DoctorTutorInformation_1_1_1_xu2_shidian o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTutorCategory());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getHaveInternationalCooperation());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getGuideDoctoralStudents());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getFirstLevelSubject());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getSecondLevelSubject());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getGuideProfessionalDegreeTypes());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getNumberOfMasterStudentsEnrolledInTheUnit());
                }else{
                    row.createCell(7).setCellValue("");
                }

            }

        }

    }


    /**
     *  表 1-2-1 下载
     *
     */
    public static void exportAll1_1_2(List<DoctorStudentInformation_1_1_2_shiqi> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表1-1-2 博士生信息表（时期）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 15);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("博士生唯一识别码");
        rowx1.createCell(1).setCellValue("姓名");
        rowx1.createCell(2).setCellValue("博士导师唯一识别码");
        rowx1.createCell(3).setCellValue("合作指导导师唯一识别码");
        rowx1.createCell(4).setCellValue("学生类型");
        rowx1.createCell(5).setCellValue("学习方式");
        rowx1.createCell(6).setCellValue("国家（地区）");
        rowx1.createCell(7).setCellValue("民族");
        rowx1.createCell(8).setCellValue("学位类型");
        rowx1.createCell(9).setCellValue("现所属一级学科");
        rowx1.createCell(10).setCellValue("现所属二级学科");
        rowx1.createCell(11).setCellValue("现所属专业学位类别");
        rowx1.createCell(12).setCellValue("入学日期");
        rowx1.createCell(13).setCellValue("是否存在学籍变动");
        rowx1.createCell(14).setCellValue("学籍变动原因");
        rowx1.createCell(15).setCellValue("是否授予学位");





        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                DoctorStudentInformation_1_1_2_shiqi o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getDoctoralStudentIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getName());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getCooperativeGuidanceTutorIdentificationCode());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getStudentType());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getWayOfLearning());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getCountry());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getNationality());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getDegreeType());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getFirstLevelSubject());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getSecondLevelSubject());
                }else{
                    row.createCell(10).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(11).setCellValue(o1.getCurrentProfessionalDegreeCategory());
                }else{
                    row.createCell(11).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(12).setCellValue(o1.getEntryDate());
                }else{
                    row.createCell(12).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(13).setCellValue(o1.getHaveChangeInStudentStatus());
                }else{
                    row.createCell(13).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(14).setCellValue(o1.getReasonsForChangesInStudentStatus());
                }else{
                    row.createCell(14).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(15).setCellValue(o1.getWhetherToAwardDegree());
                }else{
                    row.createCell(15).setCellValue("");
                }

            }

        }

    }

    /**
     *  表 1-2-1 下载
     *
     */
    public static void exportAll1_2_1(List<ResearchProjectSituation_1_2_1_shiqi> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表1-2-1 科研项目情况（时期）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 15);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("项目名称");
        rowx1.createCell(2).setCellValue("立项日期");
        rowx1.createCell(3).setCellValue("立项编号");
        rowx1.createCell(4).setCellValue("项目类型");
        rowx1.createCell(5).setCellValue("纵向项目类别");
        rowx1.createCell(6).setCellValue("项目状态");
        rowx1.createCell(7).setCellValue("填表单位排序");
        rowx1.createCell(8).setCellValue("国内项目合同金额（万元）");
        rowx1.createCell(9).setCellValue("国际项目合同金额（万元）");
        rowx1.createCell(10).setCellValue("项目累积到款（万元）");
        rowx1.createCell(11).setCellValue("项目年度到款（万元）");
        rowx1.createCell(12).setCellValue("结题验收或鉴定时间");
        rowx1.createCell(13).setCellValue("本人角色");





        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                ResearchProjectSituation_1_2_1_shiqi o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getProjectName());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getProjectDate());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getProjectNumber());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getProjectType());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getVerticalProjectType());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getProjectStatus());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getSortUnitByFillInForm());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getDomesticProjectContractAmount());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getAbroadProjectContractAmount());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getAccumulatedItems());
                }else{
                    row.createCell(10).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(11).setCellValue(o1.getProjectYearToPayment());
                }else{
                    row.createCell(11).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(12).setCellValue(o1.getFinalAcceptanceOrIdentificationTime());
                }else{
                    row.createCell(12).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(13).setCellValue(o1.getRole());
                }else{
                    row.createCell(13).setCellValue("");
                }

            }

        }

    }


    /**
     *  表 2-1-1 下载
     *
     */
    public static void exportAll2_1_1(List<CourseStatus_2_1_1_shiqi> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表2-1-1 开课情况（时期）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 7);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("课程编号");
        rowx1.createCell(2).setCellValue("课程名称");
        rowx1.createCell(3).setCellValue("课程类别");
        rowx1.createCell(4).setCellValue("课程性质");
        rowx1.createCell(5).setCellValue("教学学时");
        rowx1.createCell(6).setCellValue("开课对象");
        rowx1.createCell(7).setCellValue("上课人数(人)");






        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                CourseStatus_2_1_1_shiqi o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getCourseNumber());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getCourseName());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getCourseType());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getCourseNature());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getTeachingHours());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getCourseObject());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getNumberOfStudents());
                }else{
                    row.createCell(7).setCellValue("");
                }

            }

        }

    }


    /**
     *  表 2-1-2 下载
     *
     */
    public static void exportAll2_1_2(List<GraduateEducationTeachingReformResearchProject_2_1_2_shiqi> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表2-1-2 研究生教育教学改革研究项目情况（时期）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 8);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("项目名称");
        rowx1.createCell(2).setCellValue("立项日期");
        rowx1.createCell(3).setCellValue("项目状态");
        rowx1.createCell(4).setCellValue("结束日期");
        rowx1.createCell(5).setCellValue("项目等级");
        rowx1.createCell(6).setCellValue("立项经费(万元)");
        rowx1.createCell(7).setCellValue("经费来源");
        rowx1.createCell(8).setCellValue("本人角色");






        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                GraduateEducationTeachingReformResearchProject_2_1_2_shiqi o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getProjectName());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getProjectDate());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getProjectStatus());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getEndOfDate());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getProjectLevel());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getProjectFunding());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getSourcesOfFunding());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getRole());
                }else{
                    row.createCell(8).setCellValue("");
                }

            }

        }

    }



    /**
     *  表 2-1-3 下载
     *
     */
    public static void exportAll2_1_3(List<PublishingTextbookSituation_2_1_3shqi> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表2-1-3 出版教材情况（时期）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 10);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("教材名称");
        rowx1.createCell(2).setCellValue("教材入选情况");
        rowx1.createCell(3).setCellValue("出版社");
        rowx1.createCell(4).setCellValue("出版社所在国家（地区）");
        rowx1.createCell(5).setCellValue("总字数(万字)");
        rowx1.createCell(6).setCellValue("发行数(册)");
        rowx1.createCell(7).setCellValue("出版日期");
        rowx1.createCell(8).setCellValue("书号（ISBN）");
        rowx1.createCell(9).setCellValue("出版语言");
        rowx1.createCell(10).setCellValue("本人角色");






        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                PublishingTextbookSituation_2_1_3shqi o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getTextbookName());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getSituationWithSelectedTextbooks());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getPublishingHouse());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getPublisherCountry());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getTotalNumberOfWords());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getNumberOfIssues());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getPublicationDate());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getBookNumber());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getPublishingLanguage());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getRole());
                }else{
                    row.createCell(10).setCellValue("");
                }

            }

        }

    }


    /**
     *  表 2-1-4 下载
     *
     */
    public static void exportAll2_1_4(List<AwardsForGraduateTeachingAchievements_2_1_4_shiqi> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表2-1-4 研究生教学成果获奖情况（时期）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 8);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("完成人序位");
        rowx1.createCell(2).setCellValue("奖项名称");
        rowx1.createCell(3).setCellValue("证书号");
        rowx1.createCell(4).setCellValue("第一获奖单位是否为填表单位");
        rowx1.createCell(5).setCellValue("获奖级别");
        rowx1.createCell(6).setCellValue("获奖等级");
        rowx1.createCell(7).setCellValue("获奖日期");
        rowx1.createCell(8).setCellValue("颁奖单位");







        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                AwardsForGraduateTeachingAchievements_2_1_4_shiqi o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getCompletionOrder());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getAwardName());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getCertificateNumber());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getWhetherFirstWinningUnitIsFillingUnit());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getAwardLevel());
                }else{
                    row.createCell(5).setCellValue("");
                }

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

            }

        }

    }


    /**
     *  表 2-1-5 下载
     *
     */
    public static void exportAll2_1_5(List<GuidedDoctoralStudentsAwards_2_1_5_shiqi> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表2-1-5 指导博士生获奖情况（时期）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 8);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("获奖题目");
        rowx1.createCell(2).setCellValue("奖项名称");
        rowx1.createCell(3).setCellValue("证书号");
        rowx1.createCell(4).setCellValue("获奖级别");
        rowx1.createCell(5).setCellValue("获奖等级");
        rowx1.createCell(6).setCellValue("颁奖单位");
        rowx1.createCell(7).setCellValue("获奖博士生唯一识别码");
        rowx1.createCell(8).setCellValue("指导教师序位");







        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                GuidedDoctoralStudentsAwards_2_1_5_shiqi o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getAwardTopic());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getAwardName());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getCertificateNumber());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getAwardLevel());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getAwardGrade());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getAwardingUnit());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getAwardDoctoralStudentIdentificationCode());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getInstructorOrder());
                }else{
                    row.createCell(8).setCellValue("");
                }

            }

        }

    }


    /**
     *  表 2-2-1 下载
     *
     */
    public static void exportAll2_2_1(List<ResearchPapers_2_2_1shiqi> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表2-2-1 科研论文情况（时期）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 10);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("论文名称");
        rowx1.createCell(2).setCellValue("论文类型");
        rowx1.createCell(3).setCellValue("期刊名称");
        rowx1.createCell(4).setCellValue("期刊号（ISSN）");
        rowx1.createCell(5).setCellValue("发表语言");
        rowx1.createCell(6).setCellValue("DOI");
        rowx1.createCell(7).setCellValue("是否ESI收录");
        rowx1.createCell(8).setCellValue("收录索引");
        rowx1.createCell(9).setCellValue("作者序位");
        rowx1.createCell(10).setCellValue("是否通讯作者");







        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                ResearchPapers_2_2_1shiqi o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getPaperName());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getPaperType());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getJournalName());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getIssueNumber());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getPublishingLanguage());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getDOI());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getWhetherEsIIsIncluded());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getIndex());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getAuthorOrder());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getWhetherCorrespondingAuthor());
                }else{
                    row.createCell(10).setCellValue("");
                }

            }

        }

    }


    /**
     *  表 2-2-2 下载
     *
     */
    public static void exportAll2_2_2(List<ResearchAwards_2_2_2_shiqi> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表2-2-2 科研获奖情况（时期）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 10);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("获奖级别");
        rowx1.createCell(2).setCellValue("奖项名称");
        rowx1.createCell(3).setCellValue("本单位是否为第一完成单位");
        rowx1.createCell(4).setCellValue("获奖类别");
        rowx1.createCell(5).setCellValue("获奖等级");
        rowx1.createCell(6).setCellValue("获奖日期");
        rowx1.createCell(7).setCellValue("颁奖单位");
        rowx1.createCell(8).setCellValue("获奖证书编号");
        rowx1.createCell(9).setCellValue("完成单位排名");
        rowx1.createCell(10).setCellValue("本人排序");







        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                ResearchAwards_2_2_2_shiqi o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getAwardLevel());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getAwardName());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getWhetherFirstCompletedUnit());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getAwardCategory());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getAwardGrade());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getAwardDate());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getAwardingUnit());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getAwardCertificateNumber());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getCompleteUnitRanking());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getSortByName());
                }else{
                    row.createCell(10).setCellValue("");
                }

            }

        }

    }

    /**
     *  表 2-2-3 下载
     *
     */
    public static void exportAll2_2_3(List<PublicationStatus_2_2_3_shiqi> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表2-2-3 出版著作情况（时期）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 10);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("著作名称");
        rowx1.createCell(2).setCellValue("著作类别");
        rowx1.createCell(3).setCellValue("出版社");
        rowx1.createCell(4).setCellValue("出版社所在国家（地区）");
        rowx1.createCell(5).setCellValue("总字数（万字）");
        rowx1.createCell(6).setCellValue("发行数（册）");
        rowx1.createCell(7).setCellValue("出版日期");
        rowx1.createCell(8).setCellValue("书号（ISBN）");
        rowx1.createCell(9).setCellValue("语种");
        rowx1.createCell(10).setCellValue("本人角色");







        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                PublicationStatus_2_2_3_shiqi o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getBookName());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getBookType());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getPublishingHouse());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getPublisherCountry());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getTotalNumberOfWords());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getNumberOfIssues());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getPublicationDate());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getBookNumber());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getLanguage());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getRole());
                }else{
                    row.createCell(10).setCellValue("");
                }

            }

        }

    }

    /**
     *  表 2-2-4 下载
     *
     */
    public static void exportAll2_2_4(List<PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表2-2-4  专利（著作权）授权情况（时期）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 7);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("专利（著作权）名称");
        rowx1.createCell(2).setCellValue("知识产权类别");
        rowx1.createCell(3).setCellValue("授权号");
        rowx1.createCell(4).setCellValue("获批日期");
        rowx1.createCell(5).setCellValue("本人排序");
        rowx1.createCell(6).setCellValue("本单位是否为第一申请单位");
        rowx1.createCell(7).setCellValue("是否行业联合专利（著作权）");







        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getPatentOrBookName());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getIntellectualPropertyCategory());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getAuthorizationNumber());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getApprovedDate());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getSortByMe());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getWhetherUnitIsFirstApplicationUnit());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getWhetherIndustryJointPatent());
                }else{
                    row.createCell(7).setCellValue("");
                }


            }

        }

    }


    /**
     *  表 2-2-5 下载
     *
     */
    public static void exportAll2_2_5(List<ParticipationInternationalAcademicConferences_2_2_5_shiqi> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表2-2-5 参加国际学术会议情况（时期）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 10);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("学术会议名");
        rowx1.createCell(2).setCellValue("主办单位");
        rowx1.createCell(3).setCellValue("会议举办所在国家/地区");
        rowx1.createCell(4).setCellValue("会议举办所在城市");
        rowx1.createCell(5).setCellValue("会议开幕日期");
        rowx1.createCell(6).setCellValue("是否为大会主席");
        rowx1.createCell(7).setCellValue("报告类型");
        rowx1.createCell(8).setCellValue("报告题目");
        rowx1.createCell(9).setCellValue("报告日期");
        rowx1.createCell(10).setCellValue("报告人");







        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                ParticipationInternationalAcademicConferences_2_2_5_shiqi o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getAcademicConferenceName());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getOrganizer());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getConferenceHeldCountryOrRegion());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getConferenceCity());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getOpeningDateOfMeeting());
                }else{
                    row.createCell(5).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(6).setCellValue(o1.getWhetherChairmanOfConference());
                }else{
                    row.createCell(6).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(7).setCellValue(o1.getReportType());
                }else{
                    row.createCell(7).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(8).setCellValue(o1.getReportName());
                }else{
                    row.createCell(8).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(9).setCellValue(o1.getReportDate());
                }else{
                    row.createCell(9).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(10).setCellValue(o1.getReporter());
                }else{
                    row.createCell(10).setCellValue("");
                }


            }

        }

    }


    /**
     *  表 2-2-6 下载
     *
     */
    public static void exportAll2_2_6(List<AcademicAppointment_2_2_6_shidian> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表2-2-6 学术任职情况（时点）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 5);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);



        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("职务名称");
        rowx1.createCell(2).setCellValue("职务级别");
        rowx1.createCell(3).setCellValue("任职组织");
        rowx1.createCell(4).setCellValue("组织类型");
        rowx1.createCell(5).setCellValue("开始任职年月");








        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                AcademicAppointment_2_2_6_shidian o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getJobTitle());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getJobLevel());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getEmploymentOrganization());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getOrganizationType());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getStartOfOffice());
                }else{
                    row.createCell(5).setCellValue("");
                }

            }

        }

    }

    /**
     *  表 2-2-7 下载
     *
     */
    public static void exportAll2_2_7(List<RelyingOnScientificResearchPlatform_2_2_7_shidian> list, Sheet sheet1, Workbook wbss){


        HSSFFont font = (HSSFFont) wbss.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font.setFontHeightInPoints((short) 16);  //字体大小

        CellStyle cellStyle = wbss.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 表头
        Row rowx0 = sheet1.createRow(0);
        rowx0.createCell(0).setCellValue("表2-2-7 依托科研平台情况（时点）");
        rowx0.getCell(0).setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 5);
        sheet1.addMergedRegion(range);


        //  第二行  字段行
        Row rowx1 = sheet1.createRow(1);


        rowx1.createCell(0).setCellValue("导师唯一识别码");
        rowx1.createCell(1).setCellValue("科研平台名称");
        rowx1.createCell(2).setCellValue("科研平台级别");
        rowx1.createCell(3).setCellValue("科研平台类别");
        rowx1.createCell(4).setCellValue("省部级主管部门");
        rowx1.createCell(5).setCellValue("任职");








        if(list!=null&&list.size()>0){
            for(int i= 0 ;i<list.size();i++){
                Row row = sheet1.createRow(i+2);

                RelyingOnScientificResearchPlatform_2_2_7_shidian o1=list.get(i);

                if(o1!=null){
                    row.createCell(0).setCellValue(o1.getTutorIdentificationCode());
                }else{
                    row.createCell(0).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(1).setCellValue(o1.getResearchPlatformName());
                }else{
                    row.createCell(1).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(2).setCellValue(o1.getResearchPlatformLevel());
                }else{
                    row.createCell(2).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(3).setCellValue(o1.getResearchPlatformCategory());
                }else{
                    row.createCell(3).setCellValue("");
                }

                if(o1!=null){
                    row.createCell(4).setCellValue(o1.getProvincialAndMinisterialAuthorities());
                }else{
                    row.createCell(4).setCellValue("");
                }
                if(o1!=null){
                    row.createCell(5).setCellValue(o1.getServe());
                }else{
                    row.createCell(5).setCellValue("");
                }

            }

        }

    }


}
