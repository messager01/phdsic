package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.DoctorTutorInformation_1_1_1_xu1_shidian;
import com.ccnu.phdsic.entities.DoctorTutorInformation_1_1_1_xu2_shidian;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_1_1_1_xu2 {


    DoctorTutorInformation_1_1_1_xu2_shidian getTable_1_1_1xu2(String phdId);

    void updateinfo_1_1_1_xu2(DoctorTutorInformation_1_1_1_xu2_shidian info_1_1_1_xu2);

    List<DoctorTutorInformation_1_1_1_xu2_shidian> getAll();

    List<DoctorTutorInformation_1_1_1_xu2_shidian> getInfoByCollege(String collegeName);

    void insertDoctorTutorInformation_1_1_1_xu2_shidian (DoctorTutorInformation_1_1_1_xu2_shidian info111xu2);

    void deleteAll();

    void deleteById(String id);
}
