package com.ccnu.phdsic.controller;

import com.ccnu.phdsic.entities.DoctorTutorInformation_1_1_1_shidian;
import com.ccnu.phdsic.entities.MSG;
import com.ccnu.phdsic.mapper.Mapper_1_1_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * create by Shipeixin on 2019/11/22 21:12
 */
@RestController
public class QueryController {


    @Autowired
    Mapper_1_1_1 mapper_1_1_1;

    @RequestMapping("/queryPHD")
    public MSG queryPHD(String idNum){
        MSG MSG = new MSG();
        DoctorTutorInformation_1_1_1_shidian phdNameAndCollege = mapper_1_1_1.getPHDNameAndCollege(idNum);
        if (phdNameAndCollege == null){
            // 失败
            MSG.setCode(0);
            Map<String, String> data = MSG.getData();
            data.put("name",null);
            data.put("college",null);
            MSG.setPath(null);
        }else {
                //成功
            MSG.setCode(1);
            Map<String, String> data = MSG.getData();
            data.put("name",phdNameAndCollege.getName());
            data.put("college",phdNameAndCollege.getCollege());
            MSG.setPath("101.132.159.57/file/downloadbyid?idNum="+idNum);
        }
        return MSG;
    }
}
