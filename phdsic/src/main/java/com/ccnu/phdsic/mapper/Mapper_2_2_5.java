package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.ParticipationInternationalAcademicConferences_2_2_5_shiqi;
import com.ccnu.phdsic.entities.PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_2_2_5 {
   List<ParticipationInternationalAcademicConferences_2_2_5_shiqi> getTable_2_2_5(String phdId);

   void updateinfo_2_2_5(ParticipationInternationalAcademicConferences_2_2_5_shiqi info_2_2_5);

   List<ParticipationInternationalAcademicConferences_2_2_5_shiqi> getAll();
   List<ParticipationInternationalAcademicConferences_2_2_5_shiqi> getInfoByCollege(String collegeName);

   void delete225(String phdId);

   void insert225(ParticipationInternationalAcademicConferences_2_2_5_shiqi info_2_2_5);

   void deleteAll();

   void deleteById(String id);
}
