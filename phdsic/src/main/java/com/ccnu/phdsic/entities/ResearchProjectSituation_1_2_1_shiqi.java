package com.ccnu.phdsic.entities;

/**
 * create by Shipeixin on 2019/11/21 21:10
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * 表1-2-1 科研项目情况（时期）
 * 每位导师的信息多条
 *
 */
@Setter@Getter@ToString
public class ResearchProjectSituation_1_2_1_shiqi {
   // 导师唯一识别码
    private String tutorIdentificationCode;

   // 项目名称
    private String projectName;

    //立项日期
    private String projectDate;

    //立项编号
    private String projectNumber;

    //项目类型
    private String projectType;

    //纵向项目类型
    private String verticalProjectType;

    //项目状态
    private String projectStatus;

   // 填表单位排序
    private String sortUnitByFillInForm;

   // 国内项目合同金额
    private String domesticProjectContractAmount;

   // 国外项目合同金额
    private String abroadProjectContractAmount;

    //项目累计到款
    private String accumulatedItems;

    //项目年度到款
    private String projectYearToPayment;

    //结题验收或鉴定时间

    private String finalAcceptanceOrIdentificationTime;

    //角色
    private String role;




}
