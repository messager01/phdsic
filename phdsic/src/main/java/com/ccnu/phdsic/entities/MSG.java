package com.ccnu.phdsic.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by Shipeixin on 2019/11/22 21:13
 */

@Setter@Getter@ToString
public class MSG {

    private Map<String,String> data = new HashMap<>();
    private Integer code;
    private String path;

}
