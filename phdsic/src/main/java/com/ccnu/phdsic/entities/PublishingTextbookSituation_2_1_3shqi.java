package com.ccnu.phdsic.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.ISBN;

import javax.websocket.server.ServerEndpoint;

/**
 * create by Shipeixin on 2019/11/21 20:41
 *
 * 表2-2-7 依托科研平台情况（时点）
 * 每位导师多条信息
 */
@Getter
@Setter@ToString
public class PublishingTextbookSituation_2_1_3shqi {
    // 导师唯一识别码
    private String tutorIdentificationCode;

    //教材名称
    private String textbookName;

    //教材入选情况
    private String situationWithSelectedTextbooks;

    //出版社
    private String publishingHouse;

    //出版社所在国家
    private String publisherCountry;

    //总字数
    private String totalNumberOfWords;

    //发行数
    private String numberOfIssues;

    //出版日期
    private String publicationDate;

    //书号（ISBN）
    private String bookNumber;

    //出版语言
    private String publishingLanguage;

    //本人角色
    private String role;




}
