package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.AwardsForGraduateTeachingAchievements_2_1_4_shiqi;
import com.ccnu.phdsic.entities.PublishingTextbookSituation_2_1_3shqi;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_2_1_4 {
   List<AwardsForGraduateTeachingAchievements_2_1_4_shiqi> getTable_2_1_4(String phdId);

   void updateinfo_2_1_4(AwardsForGraduateTeachingAchievements_2_1_4_shiqi info_2_1_4);

   List<AwardsForGraduateTeachingAchievements_2_1_4_shiqi> getAll();

   List<AwardsForGraduateTeachingAchievements_2_1_4_shiqi> getInfoByCollege(String collegeName);

   void delete214(String phdId);

   void insert214(AwardsForGraduateTeachingAchievements_2_1_4_shiqi info_2_1_4);

   void deleteAll();

   void deleteById(String id);
}
