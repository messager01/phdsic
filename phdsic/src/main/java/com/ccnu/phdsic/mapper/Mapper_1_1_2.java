package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.DoctorStudentInformation_1_1_2_shiqi;
import com.ccnu.phdsic.entities.DoctorTutorInformation_1_1_1_xu2_shidian;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_1_1_2 {

   List<DoctorStudentInformation_1_1_2_shiqi> getTable_1_1_2(String phdId);

   void updateinfo_1_1_2(DoctorStudentInformation_1_1_2_shiqi info_1_1_2);

   List<DoctorStudentInformation_1_1_2_shiqi> getAll();

   List<DoctorStudentInformation_1_1_2_shiqi> getInfoByCollege(String collegeName);

   void  delete112(String phdId);

   void insert112(DoctorStudentInformation_1_1_2_shiqi info_1_1_2 );

   void deleteAll();

   void deleteById(String id);
}
