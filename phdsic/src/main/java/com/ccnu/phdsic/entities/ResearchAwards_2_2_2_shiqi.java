package com.ccnu.phdsic.entities;

/**
 * create by Shipeixin on 2019/11/21 20:53
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 表2-2-2 科研获奖情况（时期）
 * 每位导师多条信息
 *
 */

@Setter@Getter@ToString
public class ResearchAwards_2_2_2_shiqi {

    //导师唯一识别码
    private String tutorIdentificationCode;

    //获奖级别
    private String awardLevel;

    //获奖名称
    private String awardName;

    //本单位是否为第一完成单位
    private String whetherFirstCompletedUnit;

    //获奖类别
    private String awardCategory;

    //获奖等级
    private String awardGrade;

    //获奖日期
    private String awardDate;

    //颁奖单位
    private String awardingUnit;

    //获奖证书编号
    private String awardCertificateNumber;

    //完成单位排名
    private String completeUnitRanking;

    //本人排序
    private String sortByName;


}
