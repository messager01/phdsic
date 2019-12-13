package com.ccnu.phdsic.entities;

/**
 * create by Shipeixin on 2019/11/21 14:47
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * 表1-1-1 博士导师信息表（续2）（时点）
 * 每位导师的信息一条
 *
 */

@Setter@Getter@ToString
public class DoctorTutorInformation_1_1_1_xu2_shidian {

    //导师唯一识别码
    private String tutorIdentificationCode;

    //导师类别
    private String tutorCategory;

    //是否有国际合作
    private String haveInternationalCooperation;

    //可指导博士生类型
    private String guideDoctoralStudents;

    //现所属一级学科
    private String firstLevelSubject;

    //现所属二级学科
    private String secondLevelSubject;

    //可指导专业学位类型
    private String guideProfessionalDegreeTypes;

    //所指导填报单位硕士生在读人数（人）
    private String numberOfMasterStudentsEnrolledInTheUnit;

}
