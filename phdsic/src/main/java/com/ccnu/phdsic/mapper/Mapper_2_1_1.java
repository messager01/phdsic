package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.CourseStatus_2_1_1_shiqi;
import com.ccnu.phdsic.entities.ResearchProjectSituation_1_2_1_shiqi;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_2_1_1 {
   List<CourseStatus_2_1_1_shiqi> getTable_2_1_1(String phdId);

   void updateinfo_2_1_1(CourseStatus_2_1_1_shiqi info_2_1_1);

   List<CourseStatus_2_1_1_shiqi> getAll();

   List<CourseStatus_2_1_1_shiqi> getInfoByCollege(String collegeName);

   void delete211(String phdId);

   void insert211(CourseStatus_2_1_1_shiqi info_2_1_1);

   void deleteAll();

   void deleteById(String id);
}
