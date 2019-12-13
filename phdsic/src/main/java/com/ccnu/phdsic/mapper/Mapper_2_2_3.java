package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.PublicationStatus_2_2_3_shiqi;
import com.ccnu.phdsic.entities.ResearchAwards_2_2_2_shiqi;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_2_2_3 {
   List<PublicationStatus_2_2_3_shiqi> getTable_2_2_3(String phdId);

   void updateinfo_2_2_3(PublicationStatus_2_2_3_shiqi info_2_2_3);

   List<PublicationStatus_2_2_3_shiqi> getAll();

   List<PublicationStatus_2_2_3_shiqi> getInfoByCollege(String collegeName);

   void delete223(String phdId);

   void insert223(PublicationStatus_2_2_3_shiqi info_2_2_3);

   void deleteAll();

   void deleteById(String id);
}
