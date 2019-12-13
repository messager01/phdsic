package com.ccnu.phdsic.entities;

/**
 * create by Shipeixin on 2019/11/21 15:17
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * 表2-2-4  专利（著作权）授权情况（时期）
 * 每位导师有多条信息
 *
 */
@Setter@Getter@ToString
public class PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi {
    //导师唯一标识码
    private String tutorIdentificationCode;

    //专利或著作名称
    private String patentOrBookName;

    //知识产权类别
    private String intellectualPropertyCategory;

    //授权号
    private String authorizationNumber;

    //授权日期
    private String approvedDate;

    //本人排序
    private String sortByMe;

    //本单位是否为第一申请单位
    private String whetherUnitIsFirstApplicationUnit;

    //是否行业联合专利
    private String whetherIndustryJointPatent;





}
