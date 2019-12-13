package com.ccnu.phdsic.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


/**
 * create by Shipeixin on 2019/11/20 14:34
 */
public interface ImportService {

    Map<String,List> batchImport(String fileName, MultipartFile file) throws Exception;
}
