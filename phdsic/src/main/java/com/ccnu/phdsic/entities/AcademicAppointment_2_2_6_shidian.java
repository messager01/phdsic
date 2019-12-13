package com.ccnu.phdsic.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * create by Shipeixin on 2019/11/21 13:45
 */

/*
表2-2-6 学术任职情况（时点）
        每位导师多条信息
        */
@Setter
@Getter
@ToString
public class AcademicAppointment_2_2_6_shidian {
    // 导师唯一识别吗
    private String tutorIdentificationCode;

    //  职务名称
    private String jobTitle;

    // 职务级别
    private String jobLevel;

    //  任职组织
    private String employmentOrganization;

    // 组织类型
    private String organizationType;

    //  开始任职年月
    private String startOfOffice;

}
