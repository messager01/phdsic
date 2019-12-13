package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi;
import com.ccnu.phdsic.entities.PublicationStatus_2_2_3_shiqi;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_2_2_4 {
   List<PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi> getTable_2_2_4(String phdId);

   void updateinfo_2_2_4(PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi info_2_2_4);

   List<PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi> getAll();

   List<PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi> getInfoByCollege(String collegeName);

   void delete224(String phdId);

   void insert224(PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi info_2_2_4);

   void deleteAll();

   void deleteById(String id);
}
