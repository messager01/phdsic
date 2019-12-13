package com.ccnu.phdsic.mapper;

import com.ccnu.phdsic.entities.Dictionary;

import java.util.List;

/**
 * create by Shipeixin on 2019/11/28 16:14
 */
public interface DictionaryMapper {

    // 根据字段名  查询  备选值


    List<String> getValueByFiledName(String FiledName);
}
