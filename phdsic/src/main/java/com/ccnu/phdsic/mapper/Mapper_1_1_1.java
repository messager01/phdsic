package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.Admin;
import com.ccnu.phdsic.entities.DoctorTutorInformation_1_1_1_shidian;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/21 21:20
 */

public interface Mapper_1_1_1 {

    String getPHDIdByIdNum(String idNum);

    String getNameByIdNum(String idNum);

    DoctorTutorInformation_1_1_1_shidian getTable_1_1_1(String phdId);

    DoctorTutorInformation_1_1_1_shidian getPHDNameAndCollege(String idNum);

    void updateinfo_1_1_1(DoctorTutorInformation_1_1_1_shidian info_1_1_1);

    List<DoctorTutorInformation_1_1_1_shidian> getAll();


    // 根据学院名称查询
    List<DoctorTutorInformation_1_1_1_shidian> getInfoByCollege(String collegeName);



    // 根据学院名称查询id
    List<String> getIdByCollege(String collegeName);


    // 下载检查
    Admin checkDownLoad(String unit);


    // 上传检查
    Admin checkUpLoad(String id);

    //  插入
    void insertDoctorTutorInformation_1_1_1_shidian(DoctorTutorInformation_1_1_1_shidian info111);




    //  清空表

    void  deleteAll();


    //  删除某一位

    void deleteById(String id);

}
