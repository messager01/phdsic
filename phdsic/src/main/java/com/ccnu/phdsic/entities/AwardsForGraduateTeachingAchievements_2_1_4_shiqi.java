package com.ccnu.phdsic.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * create by Shipeixin on 2019/11/21 13:58
 */
/*
*
* 表2-1-4 研究生教学成果获奖情况（时期）
每位导师信息多条
* */
@Setter@Getter@ToString
public class AwardsForGraduateTeachingAchievements_2_1_4_shiqi {

    // 导师唯一识别码
    private String tutorIdentificationCode;

    // 完成人序位
    private String completionOrder;

    //  奖项名称
    private String awardName;

    //证书号
    private String certificateNumber;

    // 第一获奖单位是否为填表代为
    private String whetherFirstWinningUnitIsFillingUnit;

    // 获奖级别
    private String awardLevel;

    // 获奖等级
    private String awardGrade;

    // 获奖日期
    private String awardDate;

    // 颁奖单位
    private String awardingUnit;




}
