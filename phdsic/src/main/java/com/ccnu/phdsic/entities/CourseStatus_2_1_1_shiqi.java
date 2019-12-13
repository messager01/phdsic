package com.ccnu.phdsic.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * create by Shipeixin on 2019/11/21 14:06
 */

/*
*
* 表2-1-1 开课情况（时期）
每位导师信息多条
* */
@Setter@Getter@ToString
public class CourseStatus_2_1_1_shiqi {
    // 导师唯一识别码
    private String tutorIdentificationCode;

    //课程编号
    private String courseNumber;

    // 课程名称
    private String courseName;

    // 课程类别
    private String courseType;

    // 课程性质
    private String courseNature;

    //  教学学时
    private String teachingHours;

    // 开课对象
    private String courseObject;

    //上课人数
    private String numberOfStudents;



}
