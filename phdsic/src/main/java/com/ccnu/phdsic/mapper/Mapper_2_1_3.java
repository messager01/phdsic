package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.GraduateEducationTeachingReformResearchProject_2_1_2_shiqi;
import com.ccnu.phdsic.entities.PublishingTextbookSituation_2_1_3shqi;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_2_1_3 {
   List<PublishingTextbookSituation_2_1_3shqi> getTable_2_1_3(String phdId);

   void updateinfo_2_1_3(PublishingTextbookSituation_2_1_3shqi info_2_1_3);

   List<PublishingTextbookSituation_2_1_3shqi> getAll();

   List<PublishingTextbookSituation_2_1_3shqi> getInfoByCollege(String collegeName);

   void delete213(String phdId);

   void insert213(PublishingTextbookSituation_2_1_3shqi info_2_1_3);

   void deleteAll();

   void deleteById(String id);
}
