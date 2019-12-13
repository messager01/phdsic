package com.ccnu.phdsic.controller;

import com.ccnu.phdsic.entities.Admin;
import com.ccnu.phdsic.entities.MSG;
import com.ccnu.phdsic.mapper.Mapper_1_1_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * create by Shipeixin on 2019/11/27 14:40
 */

@RestController
@RequestMapping("/check")
public class DownAndUpLoadCheck {

    @Autowired
    Mapper_1_1_1 mapper_1_1_1;

    @RequestMapping("/download")
    public MSG checkDownLoad(String unit,String name,String id){
        MSG msg = new MSG();
        HashMap<String, String> map = new HashMap<>();
        Admin admin = mapper_1_1_1.checkDownLoad(unit);
        // 认证成功
        if (admin != null &&name.equals(admin.getName()) && id.equals(admin.getId())){
            msg.setCode(1);
            msg.setData(map);
            msg.setPath("http://101.132.159.57/file/downloadbycollege?collegeName="+unit);
        }else {
            msg.setCode(0);
            map.put("data","身份认证失败，请确认身份信息");
            msg.setData(map);
        }

        return msg;
    }

    @RequestMapping("/upload")
    public MSG checkUpLoad(String name,String id){
        MSG msg = new MSG();
        HashMap<String, String> map = new HashMap<>();
        // 认证成功
        if ("ccnu".equals(name) && "123".equals(id)){
            msg.setCode(1);
            msg.setData(map);
            msg.setPath("http://101.132.159.57/file/upload");
        }else {
            msg.setCode(0);
            map.put("data","身份认证失败，请确认身份信息");
            msg.setData(map);
        }

        return msg;
    }
}
