package com.ccnu.phdsic.entities;

/**
 * create by Shipeixin on 2019/11/21 15:10
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * 表2-2-5 参加国际学术会议情况（时期）
 * 每条导师多条信息
 *
 */
@Setter@Getter@ToString
public class ParticipationInternationalAcademicConferences_2_2_5_shiqi {
    //导师唯一识别码
    private String tutorIdentificationCode;

    //学术会议名称
    private String academicConferenceName;

    //主办单位
    private String organizer;

    //会议举办所在国家/地区
    private String conferenceHeldCountryOrRegion;

    //会议举办所在城市
    private String conferenceCity;

    //会议开幕日期
    private String openingDateOfMeeting;

    //是否为大会主席
    private String whetherChairmanOfConference;

    //报告类型
    private String reportType;

    //报告题目
    private String reportName;

    //报告日期
    private String reportDate;

    //报告人
    private String reporter;



}
