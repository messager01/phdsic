package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.CourseStatus_2_1_1_shiqi;
import com.ccnu.phdsic.entities.GraduateEducationTeachingReformResearchProject_2_1_2_shiqi;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_2_1_2 {
   List<GraduateEducationTeachingReformResearchProject_2_1_2_shiqi> getTable_2_1_2(String phdId);

   void updateinfo_2_1_2(GraduateEducationTeachingReformResearchProject_2_1_2_shiqi info_2_1_2);

   List<GraduateEducationTeachingReformResearchProject_2_1_2_shiqi> getAll();

   List<GraduateEducationTeachingReformResearchProject_2_1_2_shiqi> getInfoByCollege(String collegeName);

   void delete212(String phdId);

   void insert213(GraduateEducationTeachingReformResearchProject_2_1_2_shiqi info_2_1_2);

   void deleteAll();

   void deleteById(String id);
}
