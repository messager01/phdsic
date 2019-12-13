package com.ccnu.phdsic.entities;

/**
 * create by Shipeixin on 2019/11/21 15:01
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * 表2-1-5 指导博士生获奖情况（时期）
 * 每位导师信息多条
 *
 */
@Setter@Getter@ToString
public class GuidedDoctoralStudentsAwards_2_1_5_shiqi {
    //导师唯一识别码
    private String tutorIdentificationCode;

    //获奖题目
    private String awardTopic;

    //奖项名称
    private String awardName;

    //证书号
    private String certificateNumber;

    //获奖级别
    private String awardLevel;

    //获奖等级
    private String awardGrade;

    //颁奖单位
    private String awardingUnit;

    //获奖博士生唯一标识码
    private String awardDoctoralStudentIdentificationCode;

    //指导教师序位
    private String instructorOrder;


}
