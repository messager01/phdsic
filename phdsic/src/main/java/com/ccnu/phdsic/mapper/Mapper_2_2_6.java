package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.AcademicAppointment_2_2_6_shidian;
import com.ccnu.phdsic.entities.ParticipationInternationalAcademicConferences_2_2_5_shiqi;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_2_2_6 {
   List<AcademicAppointment_2_2_6_shidian> getTable_2_2_6(String phdId);

   void updateinfo_2_2_6(AcademicAppointment_2_2_6_shidian info_2_2_6);

   List<AcademicAppointment_2_2_6_shidian> getAll();

   List<AcademicAppointment_2_2_6_shidian> getInfoByCollege(String collegeName);

   void delete226(String phdId);

   void insert226(AcademicAppointment_2_2_6_shidian info_2_2_6);

   void  deleteAll();

   void  deleteById(String id );
}
