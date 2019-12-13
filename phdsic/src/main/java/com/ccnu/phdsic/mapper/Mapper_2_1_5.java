package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.AwardsForGraduateTeachingAchievements_2_1_4_shiqi;
import com.ccnu.phdsic.entities.GuidedDoctoralStudentsAwards_2_1_5_shiqi;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_2_1_5 {
   List<GuidedDoctoralStudentsAwards_2_1_5_shiqi> getTable_2_1_5(String phdId);

   void updateinfo_2_1_5(GuidedDoctoralStudentsAwards_2_1_5_shiqi info_2_1_5);

   List<GuidedDoctoralStudentsAwards_2_1_5_shiqi> getAll();

   List<GuidedDoctoralStudentsAwards_2_1_5_shiqi> getInfoByCollege(String collegeName);

   void delete215(String phdId);

   void insert215(GuidedDoctoralStudentsAwards_2_1_5_shiqi info_2_1_5);

   void deleteAll();

   void deleteById(String id);
}
