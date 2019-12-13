package com.ccnu.phdsic.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * create by Shipeixin on 2019/11/21 14:20
 */
/*
*
* 表1-1-1 博士导师信息（时点）
每位导师信息一条
* */
@Setter@Getter@ToString
public class DoctorTutorInformation_1_1_1_shidian {

    // 导师唯一标识码
    private String tutorIdentificationCode;

    // 姓名
    private String name;

    // 所属学院（单位）
    private String college;

    //  国家（地区）
    private String country;

    // 证件类型
    private String typeOfCertificate;

    //  证件号码
    private String certificateNumber;

    //  出生日期
    private String birthday;

    // 性别
    private String sex;

    //  民族
    private String nationality;

    //政治面貌
    private String politicalStatus;

    //最高学历
    private String highestEducation;

    //获得最高学历国家
    private String obtainHighestEducationCountry;

    //获得最高学历的院校或机构
    private String institutionWithHighestDegree;

    //获最高学历所学专业
    private String majorHighestDegree;

    //最高学位层次
    private String highestDegreeLevel;

    //最高学位名称
    private String nameByHighestDegree;

    //获最高学位的国家(地区)
    private String countryWithTheHighestDegree;

    //获最高学位的院校或机构
    private String highestDegreeInstitution;





}
