package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.ResearchAwards_2_2_2_shiqi;
import com.ccnu.phdsic.entities.ResearchPapers_2_2_1shiqi;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_2_2_2 {
   List<ResearchAwards_2_2_2_shiqi> getTable_2_2_2(String phdId);

   void updateinfo_2_2_2(ResearchAwards_2_2_2_shiqi info_2_2_2);

   List<ResearchAwards_2_2_2_shiqi> getAll();

   List<ResearchAwards_2_2_2_shiqi> getInfoByCollege(String collegeName);

   void  delete222(String phdId);

   void insert222(ResearchAwards_2_2_2_shiqi info_2_2_2);

   void deleteAll();

   void deleteById(String id);
}
