package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.AcademicAppointment_2_2_6_shidian;
import com.ccnu.phdsic.entities.RelyingOnScientificResearchPlatform_2_2_7_shidian;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_2_2_7 {
   List<RelyingOnScientificResearchPlatform_2_2_7_shidian> getTable_2_2_7(String phdId);

   void updateinfo_2_2_7(RelyingOnScientificResearchPlatform_2_2_7_shidian info_2_2_7);

   List<RelyingOnScientificResearchPlatform_2_2_7_shidian> getAll();

   List<RelyingOnScientificResearchPlatform_2_2_7_shidian> getInfoByCollege(String collegeName);

   void delete227(String phdId);

   void insert227(RelyingOnScientificResearchPlatform_2_2_7_shidian info_2_2_7);

   void deleteAll();

   void deleteById(String id);
}
