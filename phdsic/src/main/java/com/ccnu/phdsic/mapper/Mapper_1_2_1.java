package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.DoctorStudentInformation_1_1_2_shiqi;
import com.ccnu.phdsic.entities.ResearchProjectSituation_1_2_1_shiqi;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_1_2_1 {
   List<ResearchProjectSituation_1_2_1_shiqi> getTable_1_2_1(String phdId);

   void updateinfo_1_2_1(ResearchProjectSituation_1_2_1_shiqi info_1_2_1);

   List<ResearchProjectSituation_1_2_1_shiqi> getAll();

   List<ResearchProjectSituation_1_2_1_shiqi> getInfoByCollege(String collegeName);

   void delete121(String phdId);

   void insert121(ResearchProjectSituation_1_2_1_shiqi info_1_2_1);

   void deleteAll();

   void deleteById(String id);
}
