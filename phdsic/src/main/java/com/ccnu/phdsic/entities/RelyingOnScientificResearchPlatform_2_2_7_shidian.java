package com.ccnu.phdsic.entities;

/**
 * create by Shipeixin on 2019/11/21 20:49
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 表2-2-7 依托科研平台情况（时点）
 * 每位导师多条信息
 */
@Setter@Getter@ToString
public class RelyingOnScientificResearchPlatform_2_2_7_shidian {

    //导师唯一识别码
    private String tutorIdentificationCode;

    //科研平台名称
    private String researchPlatformName;

    //科研平台级别
    private String researchPlatformLevel;

    //科研平台类别
    private String researchPlatformCategory;

    //省部级主管部门
    private String provincialAndMinisterialAuthorities;

    //任职
    private String serve;



}
