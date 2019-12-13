package com.ccnu.phdsic.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * create by Shipeixin on 2019/11/21 21:01
 */

/**
 *
 * 表2-2-1 科研论文情况（时期）
 * 每位导师多条信息
 *
 */
@Setter@Getter@ToString
public class ResearchPapers_2_2_1shiqi {

    //导师唯一识别码
    private String tutorIdentificationCode;

    //论文名称
    private String paperName;

    //论文类型
    private String paperType;

    //期刊名称
    private String journalName;

    //期刊号ISSN
    private String issueNumber;

    //发表语言
    private String publishingLanguage;

   // DOI
    private String DOI;

   // 是否ESI收录
    private String whetherEsIIsIncluded;

    //收录索引
    private String index;

    //作者序位
    private String authorOrder;

    //是否通讯作者
    private String whetherCorrespondingAuthor;




}
