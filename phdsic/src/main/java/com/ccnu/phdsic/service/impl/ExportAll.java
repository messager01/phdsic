package com.ccnu.phdsic.service.impl;

import com.ccnu.phdsic.entities.*;
import com.ccnu.phdsic.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by Shipeixin on 2019/11/24 11:33
 */
@Service
public class ExportAll implements com.ccnu.phdsic.service.ExportAll {

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


    public Map<String, List> getAllInfo() {
        HashMap<String, List> allInfoMap = new HashMap<>();

        List<DoctorTutorInformation_1_1_1_shidian> info_1_1_1 = mapper_1_1_1.getAll();
        List<DoctorTutorInformation_1_1_1_xu1_shidian> info_1_1_1_xu1 = mapper_1_1_1_xu1.getAll();
        List<DoctorTutorInformation_1_1_1_xu2_shidian> info_1_1_1_xu2 = mapper_1_1_1_xu2.getAll();
        List<DoctorStudentInformation_1_1_2_shiqi> info_1_1_2 = mapper_1_1_2.getAll();
        List<ResearchProjectSituation_1_2_1_shiqi> info_1_2_1 = mapper_1_2_1.getAll();
        List<CourseStatus_2_1_1_shiqi> info_2_1_1 = mapper_2_1_1.getAll();
        List<GraduateEducationTeachingReformResearchProject_2_1_2_shiqi> info_2_1_2 = mapper_2_1_2.getAll();
        List<PublishingTextbookSituation_2_1_3shqi> info_2_1_3 = mapper_2_1_3.getAll();
        List<AwardsForGraduateTeachingAchievements_2_1_4_shiqi> info_2_1_4 = mapper_2_1_4.getAll();
        List<GuidedDoctoralStudentsAwards_2_1_5_shiqi> info_2_1_5 = mapper_2_1_5.getAll();
        List<ResearchPapers_2_2_1shiqi> info_2_2_1 = mapper_2_2_1.getAll();
        List<ResearchAwards_2_2_2_shiqi> info_2_2_2 = mapper_2_2_2.getAll();
        List<PublicationStatus_2_2_3_shiqi> info_2_2_3 = mapper_2_2_3.getAll();
        List<PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi> info_2_2_4 = mapper_2_2_4.getAll();
        List<ParticipationInternationalAcademicConferences_2_2_5_shiqi> info_2_2_5 = mapper_2_2_5.getAll();
        List<AcademicAppointment_2_2_6_shidian> info_2_2_6 = mapper_2_2_6.getAll();
        List<RelyingOnScientificResearchPlatform_2_2_7_shidian> info_2_2_7 = mapper_2_2_7.getAll();

        allInfoMap.put("info_1_1_1",info_1_1_1);
        allInfoMap.put("info_1_1_1_xu1",info_1_1_1_xu1);
        allInfoMap.put("info_1_1_1_xu2",info_1_1_1_xu2);
        allInfoMap.put("info_1_1_2",info_1_1_2);
        allInfoMap.put("info_1_2_1",info_1_2_1);
        allInfoMap.put("info_2_1_1",info_2_1_1);
        allInfoMap.put("info_2_1_2",info_2_1_2);
        allInfoMap.put("info_2_1_3",info_2_1_3);
        allInfoMap.put("info_2_1_4",info_2_1_4);
        allInfoMap.put("info_2_1_5",info_2_1_5);
        allInfoMap.put("info_2_2_1",info_2_2_1);
        allInfoMap.put("info_2_2_2",info_2_2_2);
        allInfoMap.put("info_2_2_3",info_2_2_3);
        allInfoMap.put("info_2_2_4",info_2_2_4);
        allInfoMap.put("info_2_2_5",info_2_2_5);
        allInfoMap.put("info_2_2_6",info_2_2_6);
        allInfoMap.put("info_2_2_7",info_2_2_7);



        return allInfoMap;
    }
}
