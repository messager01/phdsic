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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by Shipeixin on 2019/11/23 10:39
 */

@Service
public class ImportServiceImplSheet_3 implements ImportService {

    // 异常时回滚
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String,List> batchImport(String fileName, MultipartFile file) throws Exception {

        List<CourseStatus_2_1_1_shiqi> list_2_1_1 = new ArrayList<>();
        List<GraduateEducationTeachingReformResearchProject_2_1_2_shiqi> list_2_1_2 = new ArrayList<>();
        List<PublishingTextbookSituation_2_1_3shqi> list_2_1_3 = new ArrayList<>();
        List<AwardsForGraduateTeachingAchievements_2_1_4_shiqi> list_2_1_4 = new ArrayList<>();
        List<GuidedDoctoralStudentsAwards_2_1_5_shiqi> list_2_1_5 = new ArrayList<>();

        Map<String, List> sheet3Map = new HashMap<>();
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

        // 获得第一个sheet
        Sheet sheet3 = wb.getSheetAt(2);


        for (int r = 0; r <= sheet3.getLastRowNum(); r++) {
            Row row = sheet3.getRow(r);
            //  导入第一张表

            /**
             *     表  2-1-1
             */
            if (row != null && "表2-1-1 开课情况（时期）".equals(row.getCell(0).getStringCellValue())) {

                CourseStatus_2_1_1_shiqi info_2_1_1;

                // 找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet3.getRow(i);
                    if (currentRow != null && "表2-1-2 研究生教育教学改革研究项目情况（时期）".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }else {
                        // 继续导入数据
                        info_2_1_1 = new CourseStatus_2_1_1_shiqi();

                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);


                        String course_number = FormatUtil.getCellValue(currentRow,2);


                        String course_name = FormatUtil.getCellValue(currentRow,3);



                        String course_type = FormatUtil.getCellValue(currentRow,4);


                        String course_nature = FormatUtil.getCellValue(currentRow,5);


                        String teaching_hours = FormatUtil.getCellValue(currentRow,6);



                        String course_object = FormatUtil.getCellValue(currentRow,7);



                        String number_of_students = FormatUtil.getCellValue(currentRow,8);


                        info_2_1_1.setTutorIdentificationCode(tutor_identification_code);
                        info_2_1_1.setCourseNumber(course_number);
                        info_2_1_1.setCourseName(course_name);
                        info_2_1_1.setCourseType(course_type);
                        info_2_1_1.setCourseNature(course_nature);
                        info_2_1_1.setTeachingHours(teaching_hours);
                        info_2_1_1.setCourseObject(course_object);
                        info_2_1_1.setNumberOfStudents(number_of_students);


                        list_2_1_1.add(info_2_1_1);
                        sheet3Map.put("list_2_1_1", list_2_1_1);
                        //System.out.println(list_1_1_1);
                    }
                }

/**
 *     表  2-1-2 续1
 */
            } else if (row != null && "表2-1-2 研究生教育教学改革研究项目情况（时期）".equals(row.getCell(0).getStringCellValue())) {
                GraduateEducationTeachingReformResearchProject_2_1_2_shiqi info_2_1_2;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet3.getRow(i);
                    if (currentRow != null && "表2-1-3 出版教材情况（时期）".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    }else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    } else {
                        info_2_1_2 = new GraduateEducationTeachingReformResearchProject_2_1_2_shiqi();
                        // 继续导入数据

                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);


                        String project_name = FormatUtil.getCellValue(currentRow,2);


                        String project_date = FormatUtil.getCellValue(currentRow,3);



                        String project_status = FormatUtil.getCellValue(currentRow,4);


                        String end_of_date = FormatUtil.getCellValue(currentRow,5);


                        String project_level = FormatUtil.getCellValue(currentRow,6);



                        String project_funding = FormatUtil.getCellValue(currentRow,7);



                        String sources_of_funding = FormatUtil.getCellValue(currentRow,8);


                        String role = FormatUtil.getCellValue(currentRow,9);


                        info_2_1_2.setTutorIdentificationCode(tutor_identification_code);
                        info_2_1_2.setProjectName(project_name);
                        info_2_1_2.setProjectDate(project_date);
                        info_2_1_2.setProjectStatus(project_status);
                        info_2_1_2.setEndOfDate(end_of_date);
                        info_2_1_2.setProjectLevel(project_level);
                        info_2_1_2.setProjectFunding(project_funding);
                        info_2_1_2.setSourcesOfFunding(sources_of_funding);
                        info_2_1_2.setRole(role);


                        list_2_1_2.add(info_2_1_2);
                        sheet3Map.put("list_2_1_2", list_2_1_2);
                    }

/**
 *     表  2-1-3
 */
                }
            } else if (row != null && "表2-1-3 出版教材情况（时期）".equals(row.getCell(0).getStringCellValue())) {
                PublishingTextbookSituation_2_1_3shqi info_2_1_3;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet3.getRow(i);
                    if (currentRow != null && "表2-1-4 研究生教学成果获奖情况（时期）".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }else {
                        // 继续导入数据

                        info_2_1_3 = new PublishingTextbookSituation_2_1_3shqi();


                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);


                        String textbook_name = FormatUtil.getCellValue(currentRow,2);



                        String situation_with_selected_textbooks = FormatUtil.getCellValue(currentRow,3);


                        String publishing_house = FormatUtil.getCellValue(currentRow,4);


                        String publisher_country = FormatUtil.getCellValue(currentRow,5);


                        String total_number_of_words = FormatUtil.getCellValue(currentRow,6);



                        String number_of_issues = FormatUtil.getCellValue(currentRow,7);


                        String publication_date = FormatUtil.getCellValue(currentRow,8);


                        String book_number = FormatUtil.getCellValue(currentRow,9);

                        String publishing_language = FormatUtil.getCellValue(currentRow,10);


                        String role = FormatUtil.getCellValue(currentRow,11);


                        info_2_1_3.setTutorIdentificationCode(tutor_identification_code);
                        info_2_1_3.setTextbookName(textbook_name);
                        info_2_1_3.setSituationWithSelectedTextbooks(situation_with_selected_textbooks);
                        info_2_1_3.setPublishingHouse(publishing_house);
                        info_2_1_3.setPublisherCountry(publisher_country);
                        info_2_1_3.setTotalNumberOfWords(total_number_of_words);
                        info_2_1_3.setNumberOfIssues(number_of_issues);
                        info_2_1_3.setPublicationDate(publication_date);
                        info_2_1_3.setBookNumber(book_number);
                        info_2_1_3.setPublishingLanguage(publishing_language);
                        info_2_1_3.setRole(role);


                        list_2_1_3.add(info_2_1_3);
                        sheet3Map.put("list_2_1_3", list_2_1_3);

                    }/**
                     *     表  2-1-4
                     */
                }
            } else if (row != null && "表2-1-4 研究生教学成果获奖情况（时期）".equals(row.getCell(0).getStringCellValue())) {
                AwardsForGraduateTeachingAchievements_2_1_4_shiqi info_2_1_4;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet3.getRow(i);
                    if (currentRow != null && "表2-1-5 指导博士生获奖情况（时期）".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }else {

                        // 继续导入数据
                        info_2_1_4 = new AwardsForGraduateTeachingAchievements_2_1_4_shiqi();

                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);


                        String completion_order = FormatUtil.getCellValue(currentRow,2);


                        String award_name = FormatUtil.getCellValue(currentRow,3);


                        String certificate_number = FormatUtil.getCellValue(currentRow,4);


                        String whether_first_winning_unit_is_filling_unit = FormatUtil.getCellValue(currentRow,5);


                        String award_level = FormatUtil.getCellValue(currentRow,6);


                        String award_grade = FormatUtil.getCellValue(currentRow,7);


                        String award_date = FormatUtil.getCellValue(currentRow,8);


                        String awarding_unit = FormatUtil.getCellValue(currentRow,9);


                        info_2_1_4.setTutorIdentificationCode(tutor_identification_code);
                        info_2_1_4.setCompletionOrder(completion_order);
                        info_2_1_4.setAwardName(award_name);
                        info_2_1_4.setCertificateNumber(certificate_number);
                        info_2_1_4.setWhetherFirstWinningUnitIsFillingUnit(whether_first_winning_unit_is_filling_unit);
                        info_2_1_4.setAwardLevel(award_level);
                        info_2_1_4.setAwardGrade(award_grade);
                        info_2_1_4.setAwardDate(award_date);


                        info_2_1_4.setAwardingUnit(awarding_unit);


                        list_2_1_4.add(info_2_1_4);
                        sheet3Map.put("list_2_1_4", list_2_1_4);
                    }


                }

                /**
                 *     2-1-5
                 */
            } else if (row != null && "表2-1-5 指导博士生获奖情况（时期）".equals(row.getCell(0).getStringCellValue())) {
                GuidedDoctoralStudentsAwards_2_1_5_shiqi info_2_1_5;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet3.getRow(i);
                    if (currentRow != null && "结束".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }else {

                        // 继续导入数据
                        info_2_1_5 = new GuidedDoctoralStudentsAwards_2_1_5_shiqi();

                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);

                        String award_topic = FormatUtil.getCellValue(currentRow,2);


                        String award_name = FormatUtil.getCellValue(currentRow,3);


                        String certificate_number = FormatUtil.getCellValue(currentRow,4);

                        String award_level = FormatUtil.getCellValue(currentRow,5);


                        String award_grade = FormatUtil.getCellValue(currentRow,6);


                        String awarding_unit = FormatUtil.getCellValue(currentRow,7);


                        String award_doctoral_student_identification_code = FormatUtil.getCellValue(currentRow,8);


                        String instructor_order = FormatUtil.getCellValue(currentRow,9);


                        info_2_1_5.setTutorIdentificationCode(tutor_identification_code);
                        info_2_1_5.setAwardTopic(award_topic);
                        info_2_1_5.setAwardName(award_name);
                        info_2_1_5.setCertificateNumber(certificate_number);
                        info_2_1_5.setAwardLevel(award_level);
                        info_2_1_5.setAwardGrade(award_grade);
                        info_2_1_5.setAwardingUnit(awarding_unit);
                        info_2_1_5.setAwardDoctoralStudentIdentificationCode(award_doctoral_student_identification_code);


                        info_2_1_5.setInstructorOrder(instructor_order);


                        list_2_1_5.add(info_2_1_5);
                        sheet3Map.put("list_2_1_5", list_2_1_5);
                    }


                }

            }else{
                continue;
            }

        }
        return sheet3Map;
    }
}