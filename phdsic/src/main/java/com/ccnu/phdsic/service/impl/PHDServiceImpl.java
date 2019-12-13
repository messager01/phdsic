package com.ccnu.phdsic.service.impl;

import com.ccnu.phdsic.entities.*;
import com.ccnu.phdsic.mapper.*;
import com.ccnu.phdsic.service.PHDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * create by Shipeixin on 2019/11/22 11:22
 */
@Service
public class PHDServiceImpl implements PHDService {


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
    @Override
    public Map<String, List> getAllInformation(String idNum) {

        HashMap<String, List> map = new HashMap<>();


        //   获得   教工号


        DoctorTutorInformation_1_1_1_shidian table_1_1_1 = mapper_1_1_1.getTable_1_1_1(idNum);
        // 1-1-1 表的集合
        List<DoctorTutorInformation_1_1_1_shidian> Collection_1_1_1 = new ArrayList<>();
        Collection_1_1_1.add(table_1_1_1);

        map.put("Collection_1_1_1",Collection_1_1_1);
        //return Collection_1_1_1;

        // 1-1-1续1的集合
        DoctorTutorInformation_1_1_1_xu1_shidian table_1_1_1_xu1 = mapper_1_1_1_xu1.getTable_1_1_1xu1(idNum);
        List<DoctorTutorInformation_1_1_1_xu1_shidian> Collection_1_1_1_xu1 = new ArrayList<>();
        Collection_1_1_1_xu1.add(table_1_1_1_xu1);
        map.put("Collection_1_1_1_xu1",Collection_1_1_1_xu1);

        // 1-1-1续2的集合
        DoctorTutorInformation_1_1_1_xu2_shidian table_1_1_1_xu2 = mapper_1_1_1_xu2.getTable_1_1_1xu2(idNum);
        List<DoctorTutorInformation_1_1_1_xu2_shidian> Collection_1_1_1_xu2 = new ArrayList<>();
        Collection_1_1_1_xu2.add(table_1_1_1_xu2);
        map.put("Collection_1_1_1_xu2",Collection_1_1_1_xu2);


        // 1-1-2表的集合
        List<DoctorStudentInformation_1_1_2_shiqi> Collection_1_1_2 = mapper_1_1_2.getTable_1_1_2(idNum);
        map.put("Collection_1_1_2",Collection_1_1_2);

        // 1-2-1 表的集合
        List<ResearchProjectSituation_1_2_1_shiqi> Collection_1_2_1 = mapper_1_2_1.getTable_1_2_1(idNum);
        map.put("Collection_1_2_1",Collection_1_2_1);

        // 2-1-1 表的集合
        List<CourseStatus_2_1_1_shiqi> Collection_2_1_1 = mapper_2_1_1.getTable_2_1_1(idNum);
        map.put("Collection_2_1_1",Collection_2_1_1);

        // 2-1-2 表的集合
        List<GraduateEducationTeachingReformResearchProject_2_1_2_shiqi> Collection_2_1_2 = mapper_2_1_2.getTable_2_1_2(idNum);
        map.put("Collection_2_1_2",Collection_2_1_2);
        // 2-1-3 表的集合
        List<PublishingTextbookSituation_2_1_3shqi> Collection_2_1_3 = mapper_2_1_3.getTable_2_1_3(idNum);
        map.put("Collection_2_1_3",Collection_2_1_3);

        // 2-1-4 表的集合
        List<AwardsForGraduateTeachingAchievements_2_1_4_shiqi> Collection_2_1_4 = mapper_2_1_4.getTable_2_1_4(idNum);
        map.put("Collection_2_1_4",Collection_2_1_4);
        // 2-1-5 表的集合
        List<GuidedDoctoralStudentsAwards_2_1_5_shiqi> Collection_2_1_5 = mapper_2_1_5.getTable_2_1_5(idNum);
        map.put("Collection_2_1_5",Collection_2_1_5);
        // 2-2-1 表的集合
        List<ResearchPapers_2_2_1shiqi> Collection_2_2_1 = mapper_2_2_1.getTable_2_2_1(idNum);
        map.put("Collection_2_2_1",Collection_2_2_1);
        //2-2-2 表集合
        List<ResearchAwards_2_2_2_shiqi> Collection_2_2_2 = mapper_2_2_2.getTable_2_2_2(idNum);
        map.put("Collection_2_2_2",Collection_2_2_2);
        //2-2-3 表集合
        List<PublicationStatus_2_2_3_shiqi> Collection_2_2_3 = mapper_2_2_3.getTable_2_2_3(idNum);
        map.put("Collection_2_2_3",Collection_2_2_3);
        // 2-2-4 表集合
        List<PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi> Collection_2_2_4 = mapper_2_2_4.getTable_2_2_4(idNum);
        map.put("Collection_2_2_4",Collection_2_2_4);
        //2-2-5 表集合
        List<ParticipationInternationalAcademicConferences_2_2_5_shiqi> Collection_2_2_5 = mapper_2_2_5.getTable_2_2_5(idNum);
        map.put("Collection_2_2_5",Collection_2_2_5);
        // 2-2-6 表集合
        List<AcademicAppointment_2_2_6_shidian> Collection_2_2_6 = mapper_2_2_6.getTable_2_2_6(idNum);
        map.put("Collection_2_2_6",Collection_2_2_6);
        // 2-2-7 集合
        List<RelyingOnScientificResearchPlatform_2_2_7_shidian> Collection_2_2_7 = mapper_2_2_7.getTable_2_2_7(idNum);
        map.put("Collection_2_2_7",Collection_2_2_7);

        return map;

    }
}
