package com.ccnu.phdsic.entities;

/**
 * create by Shipeixin on 2019/11/21 14:52
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 *表2-1-2 研究生教育教学改革研究项目情况（时期）
 * 每位导师信息多条
 *
 */
@Setter@Getter@ToString
public class GraduateEducationTeachingReformResearchProject_2_1_2_shiqi {
    //导师唯一标识码
    private String tutorIdentificationCode;

    //项目名称
    private String projectName;

    //立项日期
    private String projectDate;

    //项目状态
    private String projectStatus;

    //结束日期
    private String endOfDate;

   // 项目等级
   private String projectLevel;

    //立项经费
    private String projectFunding;

    //经费来源
    private String sourcesOfFunding;

   // 本人角色
   private String role;


}
