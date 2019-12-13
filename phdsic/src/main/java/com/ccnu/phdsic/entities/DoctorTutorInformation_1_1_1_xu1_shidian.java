package com.ccnu.phdsic.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * create by Shipeixin on 2019/11/21 14:31
 */
@Setter@Getter@ToString
public class DoctorTutorInformation_1_1_1_xu1_shidian {

    //导师唯一识别码
    private String tutorIdentificationCode;

    //参加工作日期
    private String participationDate;

    //首次具有博士生招生资格日期
    private String firstDateOfAdmissionToDoctoralStudents;

    //是否在编
    private String inTheStaff;

    //是否与填报单位签订聘用合同
    private String signContractWithInstitution;

    //聘用期限
    private String employmentPeriod;

    //是否于填报单位承担全职工作
    private String fullTimeJobInUnit;

    //全职工作单位
    private String fullTimeJobUnit;

    //是否为离退休人员
    private String isRetire;

    //聘任专业技术职务
    private String professionalAndTechnicalPositions;

    //岗位等级
    private String postRating;

    //党政职务
    private String partyAndGovernmentDuties;

    //海外研修（访学）经历
    private String overseasTrainingExperience;

    //入选人才项目名称及入选年份
    private String nameOfSelectedTalentProjectAndYearOfSelection;

    //是否具有其他行业技术职称
    private String haveOtherIndustryTechnicalTitles;

    //是否具有国内外学术兼职
    private String haveAcademicPartTimeAtHomeAndAbroad;



}
