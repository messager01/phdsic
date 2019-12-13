package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.GuidedDoctoralStudentsAwards_2_1_5_shiqi;
import com.ccnu.phdsic.entities.ResearchPapers_2_2_1shiqi;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_2_2_1 {
   List<ResearchPapers_2_2_1shiqi> getTable_2_2_1(String phdId);

   void updateinfo_2_2_1(ResearchPapers_2_2_1shiqi info_2_2_1);

   List<ResearchPapers_2_2_1shiqi> getAll();

   List<ResearchPapers_2_2_1shiqi> getInfoByCollege(String collegeName);

   void delete221(String phdId);

   void insert221(ResearchPapers_2_2_1shiqi info_2_2_1);

   void deleteAll();

   void deleteById(String id);
}
