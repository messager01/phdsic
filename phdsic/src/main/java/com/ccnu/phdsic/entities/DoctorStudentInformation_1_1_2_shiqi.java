package com.ccnu.phdsic.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * create by Shipeixin on 2019/11/21 14:11
 */
/*
*
* 表1-1-2 博士生信息表（时期）
每位导师的信息多条
* */
@Setter@Getter@ToString
public class DoctorStudentInformation_1_1_2_shiqi {

    // 博士生唯一识别码
    private String doctoralStudentIdentificationCode;

    // 姓名
    private String name;

    // 博士导师唯一识别码
    private String tutorIdentificationCode;

    //合作指导导师唯一识别码
    private String cooperativeGuidanceTutorIdentificationCode;

    //学生类型
    private String studentType;

    // 学习方式
    private String wayOfLearning;

    // 国家（地区）
    private String country;

    // 民族
    private String nationality;

    // 学位类型
    private String degreeType;

    //  现所属一级学科
    private String firstLevelSubject;

    //  现所属二级学科
    private String secondLevelSubject;

    // 现所属专业学位类别
    private String currentProfessionalDegreeCategory;

    // 入学日期
    private String entryDate;

    // 是否存在学籍变动
    private String haveChangeInStudentStatus;

    // 学籍变动原因
    private String reasonsForChangesInStudentStatus;

    // 是否授予学位
    private String whetherToAwardDegree;

    // 学院
    private String college;


}
