package com.ccnu.phdsic.entities;

/**
 * create by Shipeixin on 2019/11/21 20:33
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * 表2-2-3 出版著作情况（时期）
 * 每位导师有多条信息
 *
 */

@Setter@Getter@ToString
public class PublicationStatus_2_2_3_shiqi {

    //导师唯一识别码
    private String tutorIdentificationCode;

    //著作名称
    private String bookName;

    //著作类别
    private String bookType;

    // 出版社
    private String publishingHouse;

    //出版社所在国家
    private String publisherCountry;

    // 总字数
    private String totalNumberOfWords;

    // 发行数
    private String numberOfIssues;

    // 出版日期
    private String publicationDate;

    // 书号（ISBN）
    private String bookNumber;

    //语种
    private String language;

    //本人角色
    private String role;


}
