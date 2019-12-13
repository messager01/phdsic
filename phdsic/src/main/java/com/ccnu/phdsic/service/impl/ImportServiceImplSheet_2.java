package com.ccnu.phdsic.service.impl;

import com.ccnu.phdsic.entities.*;
import com.ccnu.phdsic.service.ImportService;
import com.ccnu.phdsic.util.FormatUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;

/**
 * create by Shipeixin on 2019/11/23 10:39
 */

@Service
public class ImportServiceImplSheet_2 implements ImportService {

    // 异常时回滚
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String, List> batchImport(String fileName, MultipartFile file) throws Exception {

        List<ResearchProjectSituation_1_2_1_shiqi> list_1_2_1 = new ArrayList<>();


        Map<String, List> sheet2Map = new HashMap<>();
        boolean notNull = false;
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception();
        }

        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }

        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }

        // 获得第2个sheet
        Sheet sheet2 = wb.getSheetAt(1);

        //  导入第一张表

        /**
         *     表  1-1-2
         */
        ResearchProjectSituation_1_2_1_shiqi info_1_2_1;
        for (int r = 3; r <= sheet2.getLastRowNum(); r++) {
            Row row = sheet2.getRow(r);
            //System.out.println(row.getCell(0));
            if (row != null && "结束".equals(row.getCell(0).getStringCellValue())) {
                break;

            }else if (row == null || "".equals(row.getCell(0).getStringCellValue())){
                continue;
            }else{


            info_1_2_1 = new ResearchProjectSituation_1_2_1_shiqi();

            String tutor_identification_code = FormatUtil.getCellValue(row,1);

            String project_name = FormatUtil.getCellValue(row,2);


            String project_date = FormatUtil.getCellValue(row,3);


            String project_number = FormatUtil.getCellValue(row,4);


            String project_type = FormatUtil.getCellValue(row,5);

            String vertical_project_type = FormatUtil.getCellValue(row,6);


            String project_status = FormatUtil.getCellValue(row,7);


            String sort_unit_by_fill_in_form = FormatUtil.getCellValue(row,8);


            String domestic_project_contract_amount = FormatUtil.getCellValue(row,9);


            String abroad_project_contract_amount = FormatUtil.getCellValue(row,10);


            String accumulated_items = FormatUtil.getCellValue(row,11);


            String project_year_to_payment = FormatUtil.getCellValue(row,12);


            String final_acceptance_or_identification_time = FormatUtil.getCellValue(row,13);


            String role = FormatUtil.getCellValue(row,14);

            info_1_2_1.setTutorIdentificationCode(tutor_identification_code);
            info_1_2_1.setProjectName(project_name);
            info_1_2_1.setProjectDate(project_date);
            info_1_2_1.setProjectNumber(project_number);
            info_1_2_1.setProjectType(project_type);
            info_1_2_1.setVerticalProjectType(vertical_project_type);
            info_1_2_1.setProjectStatus(project_status);
            info_1_2_1.setSortUnitByFillInForm(sort_unit_by_fill_in_form);
            info_1_2_1.setDomesticProjectContractAmount(domestic_project_contract_amount);
            info_1_2_1.setAbroadProjectContractAmount(abroad_project_contract_amount);
            info_1_2_1.setAccumulatedItems(accumulated_items);
            info_1_2_1.setProjectYearToPayment(project_year_to_payment);
            info_1_2_1.setFinalAcceptanceOrIdentificationTime(final_acceptance_or_identification_time);
            info_1_2_1.setRole(role);

            list_1_2_1.add(info_1_2_1);

            sheet2Map.put("list_1_2_1",list_1_2_1);
        }
        }
        return sheet2Map;
    }
}

