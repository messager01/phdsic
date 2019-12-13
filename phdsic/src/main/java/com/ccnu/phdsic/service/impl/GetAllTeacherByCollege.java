package com.ccnu.phdsic.service.impl;

import com.ccnu.phdsic.entities.*;
import com.ccnu.phdsic.mapper.*;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by Shipeixin on 2019/11/26 19:19
 */

@Service
public class GetAllTeacherByCollege {


    @Autowired
    Mapper_1_1_1 mapper_1_1_1;

    @Autowired
    Mapper_1_1_1_xu1 mapper_1_1_1_xu1;

    @Autowired
    Mapper_1_1_1_xu2 mapper_1_1_1_xu2;
    @Autowired
    Mapper_1_1_2 mapper_1_1_2;
    @Autowired
    Mapper_1_2_1 mapper_1_2_1;
    @Autowired
    Mapper_2_1_1 mapper_2_1_1;
    @Autowired
    Mapper_2_1_2 mapper_2_1_2;
    @Autowired
    Mapper_2_1_3 mapper_2_1_3;
    @Autowired
    Mapper_2_1_4 mapper_2_1_4;
    @Autowired
    Mapper_2_1_5 mapper_2_1_5;
    @Autowired
    Mapper_2_2_1 mapper_2_2_1;
    @Autowired
    Mapper_2_2_2 mapper_2_2_2;
    @Autowired
    Mapper_2_2_3 mapper_2_2_3;
    @Autowired
    Mapper_2_2_4 mapper_2_2_4;
    @Autowired
    Mapper_2_2_5 mapper_2_2_5;
    @Autowired
    Mapper_2_2_6 mapper_2_2_6;
    @Autowired
    Mapper_2_2_7 mapper_2_2_7;

   public Map<String,List> getAllTeacherByCollege(String collegeName){

       Map<String,List> map = new HashMap();
       List<DoctorTutorInformation_1_1_1_shidian> infoByCollege111 = mapper_1_1_1.getInfoByCollege(collegeName);
       map.put("infoByCollege111",infoByCollege111);
       List<DoctorTutorInformation_1_1_1_xu1_shidian> infoByCollege111xu1 = mapper_1_1_1_xu1.getInfoByCollege(collegeName);
       map.put("infoByCollege111xu1",infoByCollege111xu1);
       List<DoctorTutorInformation_1_1_1_xu2_shidian> infoByCollege111xu2 = mapper_1_1_1_xu2.getInfoByCollege(collegeName);
        map.put("infoByCollege111xu2",infoByCollege111xu2);
       List<DoctorStudentInformation_1_1_2_shiqi> infoByCollege112 = mapper_1_1_2.getInfoByCollege(collegeName);
        map.put("infoByCollege112",infoByCollege112);
       List<ResearchProjectSituation_1_2_1_shiqi> infoByCollege121 = mapper_1_2_1.getInfoByCollege(collegeName);
       map.put("infoByCollege121",infoByCollege121);


       List<CourseStatus_2_1_1_shiqi> infoByCollege211 = mapper_2_1_1.getInfoByCollege(collegeName);
       map.put("infoByCollege211",infoByCollege211);
       List<GraduateEducationTeachingReformResearchProject_2_1_2_shiqi> infoByCollege212 = mapper_2_1_2.getInfoByCollege(collegeName);
       map.put("infoByCollege212",infoByCollege212);
       List<PublishingTextbookSituation_2_1_3shqi> infoByCollege213 = mapper_2_1_3.getInfoByCollege(collegeName);
       map.put("infoByCollege213",infoByCollege213);
       List<AwardsForGraduateTeachingAchievements_2_1_4_shiqi> infoByCollege214 = mapper_2_1_4.getInfoByCollege(collegeName);
       map.put("infoByCollege214",infoByCollege214);
       List<GuidedDoctoralStudentsAwards_2_1_5_shiqi> infoByCollege215 = mapper_2_1_5.getInfoByCollege(collegeName);
       map.put("infoByCollege215",infoByCollege215);


       List<ResearchPapers_2_2_1shiqi> infoByCollege221 = mapper_2_2_1.getInfoByCollege(collegeName);
       map.put("infoByCollege221",infoByCollege221);
       List<ResearchAwards_2_2_2_shiqi> infoByCollege222 = mapper_2_2_2.getInfoByCollege(collegeName);
       map.put("infoByCollege222",infoByCollege222);
       List<PublicationStatus_2_2_3_shiqi> infoByCollege223 = mapper_2_2_3.getInfoByCollege(collegeName);
       map.put("infoByCollege223",infoByCollege223);
       List<PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi> infoByCollege224 = mapper_2_2_4.getInfoByCollege(collegeName);
       map.put("infoByCollege224",infoByCollege224);
       List<ParticipationInternationalAcademicConferences_2_2_5_shiqi> infoByCollege225 = mapper_2_2_5.getInfoByCollege(collegeName);
       map.put("infoByCollege225",infoByCollege225);
       List<AcademicAppointment_2_2_6_shidian> infoByCollege226 = mapper_2_2_6.getInfoByCollege(collegeName);
       map.put("infoByCollege226",infoByCollege226);
       List<RelyingOnScientificResearchPlatform_2_2_7_shidian> infoByCollege227 = mapper_2_2_7.getInfoByCollege(collegeName);
       map.put("infoByCollege227",infoByCollege227);

       return map;


   }


}
