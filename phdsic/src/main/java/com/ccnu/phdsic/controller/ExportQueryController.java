package com.ccnu.phdsic.controller;

import com.ccnu.phdsic.entities.MSG;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * create by Shipeixin on 2019/11/24 20:57
 */

@RestController
public class ExportQueryController {


    @RequestMapping("/queryExport")
    public MSG exportQuery(){
        MSG msg = new MSG();

        HashMap<String, String> map = new HashMap<>();
        map.put("token","CCNUadmin");
        map.put("path","101.132.159.57/file/export");
        msg.setData(map);
        //  成功
        msg.setCode(1);
        return msg;
    }
}
