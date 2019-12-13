package com.ccnu.phdsic.service.impl;

import com.ccnu.phdsic.entities.DoctorStudentInformation_1_1_2_shiqi;
import com.ccnu.phdsic.entities.DoctorTutorInformation_1_1_1_shidian;
import com.ccnu.phdsic.entities.DoctorTutorInformation_1_1_1_xu1_shidian;
import com.ccnu.phdsic.entities.DoctorTutorInformation_1_1_1_xu2_shidian;
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
public class ImportServiceImplSheet_1 implements ImportService {

    // 异常时回滚
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String,List> batchImport(String fileName, MultipartFile file) throws Exception {

        List<DoctorTutorInformation_1_1_1_shidian> list_1_1_1 = new ArrayList<>();
        List<DoctorTutorInformation_1_1_1_xu1_shidian> list_1_1_1_xu1 = new ArrayList<>();
        List<DoctorTutorInformation_1_1_1_xu2_shidian> list_1_1_1_xu2 = new ArrayList<>();
        List<DoctorStudentInformation_1_1_2_shiqi> list_1_1_2 = new ArrayList<>();

        Map<String,List> sheet1Map = new HashMap<>();
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
        Sheet sheet1 = wb.getSheetAt(0);


        System.out.println(sheet1.getLastRowNum());
        for (int r = 0; r <= sheet1.getLastRowNum(); r++) {
            Row row = sheet1.getRow(r);
            //  导入第一张表

            /**
             *     表  1-1-1
             */
            if (row != null && "表1-1-1 博士导师信息（时点）".equals(row.getCell(0).getStringCellValue())) {

                DoctorTutorInformation_1_1_1_shidian info_1_1_1 ;

                // 找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet1.getRow(i);
                    if (currentRow != null && "表1-1-1博士导师信息（续1）（时点)".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }else  {
                        // 继续导入数据
                        info_1_1_1 = new DoctorTutorInformation_1_1_1_shidian();

                        String name = FormatUtil.getCellValue(currentRow,0);


                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);


                        String college = FormatUtil.getCellValue(currentRow,2);


                        String country = FormatUtil.getCellValue(currentRow,3);


                        String type_of_certificate = FormatUtil.getCellValue(currentRow,4);


                        String certificate_number = FormatUtil.getCellValue(currentRow,5);


                        String birthday = FormatUtil.getCellValue(currentRow,6);

                        String sex = FormatUtil.getCellValue(currentRow,7);

                        String nationality = FormatUtil.getCellValue(currentRow,8);

                        String political_status = FormatUtil.getCellValue(currentRow,9);


                        String highest_education = FormatUtil.getCellValue(currentRow,10);


                        String obtain_highest_education_country = FormatUtil.getCellValue(currentRow,11);


                        String institution_with_highest_degree = FormatUtil.getCellValue(currentRow,12);

                        String major_highest_degree = FormatUtil.getCellValue(currentRow,13);


                        String highest_degree_level = FormatUtil.getCellValue(currentRow,14);


                        String name_by_highest_degree = FormatUtil.getCellValue(currentRow,15);


                        String country_with_the_highest_degree = FormatUtil.getCellValue(currentRow,16);


                        String highest_degree_institution = FormatUtil.getCellValue(currentRow,17);

                        info_1_1_1.setTutorIdentificationCode(tutor_identification_code);
                        info_1_1_1.setName(name);
                        info_1_1_1.setCollege(college);
                        info_1_1_1.setCountry(country);
                        info_1_1_1.setTypeOfCertificate(type_of_certificate);
                        info_1_1_1.setCertificateNumber(certificate_number);
                        info_1_1_1.setBirthday(birthday);
                        info_1_1_1.setSex(sex);
                        info_1_1_1.setNationality(nationality);
                        info_1_1_1.setPoliticalStatus(political_status);
                        info_1_1_1.setHighestEducation(highest_education);
                        info_1_1_1.setObtainHighestEducationCountry(obtain_highest_education_country);
                        info_1_1_1.setInstitutionWithHighestDegree(institution_with_highest_degree);
                        info_1_1_1.setMajorHighestDegree(major_highest_degree);
                        info_1_1_1.setHighestDegreeLevel(highest_degree_level);
                        info_1_1_1.setNameByHighestDegree(name_by_highest_degree);
                        info_1_1_1.setCountryWithTheHighestDegree(country_with_the_highest_degree);
                        info_1_1_1.setHighestDegreeInstitution(highest_degree_institution);

                        list_1_1_1.add(info_1_1_1);
                        sheet1Map.put("list_1_1_1",list_1_1_1);
                        //System.out.println(list_1_1_1);
                    }
                }

/**
 *     表  1-1-1 续1
 */
            } else if (row != null && "表1-1-1博士导师信息（续1）（时点)".equals(row.getCell(0).getStringCellValue())) {
                DoctorTutorInformation_1_1_1_xu1_shidian info_1_1_1_xu1 ;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet1.getRow(i);
                    if (currentRow != null && "表1-1-1 博士导师信息表（续2）（时点）".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }

                    else {
                        info_1_1_1_xu1 = new DoctorTutorInformation_1_1_1_xu1_shidian();
                        // 继续导入数据

                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);



                        String participation_date = FormatUtil.getCellValue(currentRow,2);



                        String first_date_of_admission_to_doctoral_students = FormatUtil.getCellValue(currentRow,3);



                        String in_the_staff = FormatUtil.getCellValue(currentRow,4);


                        String sign_contract_with_institution = FormatUtil.getCellValue(currentRow,5);


                        String employment_period = FormatUtil.getCellValue(currentRow,6);



                        String full_time_job_in_unit = FormatUtil.getCellValue(currentRow,7);



                        String full_time_job_unit = FormatUtil.getCellValue(currentRow,8);


                        String is_retire = FormatUtil.getCellValue(currentRow,9);


                        String professional_and_technical_positions = FormatUtil.getCellValue(currentRow,10);

                        String post_rating = FormatUtil.getCellValue(currentRow,11);


                        String party_and_government_duties = FormatUtil.getCellValue(currentRow,12);


                        String overseas_training_experience = FormatUtil.getCellValue(currentRow,13);


                        String name_of_selected_talent_project_and_year_of_selection = FormatUtil.getCellValue(currentRow,14);


                        String have_other_industry_technical_titles = FormatUtil.getCellValue(currentRow,15);


                        String have_academic_part_time_at_home_and_abroad = FormatUtil.getCellValue(currentRow,16);


                        info_1_1_1_xu1.setTutorIdentificationCode(tutor_identification_code);
                        info_1_1_1_xu1.setParticipationDate(participation_date);
                        info_1_1_1_xu1.setFirstDateOfAdmissionToDoctoralStudents(first_date_of_admission_to_doctoral_students);
                        info_1_1_1_xu1.setInTheStaff(in_the_staff);
                        info_1_1_1_xu1.setSignContractWithInstitution(sign_contract_with_institution);
                        info_1_1_1_xu1.setEmploymentPeriod(employment_period);
                        info_1_1_1_xu1.setFullTimeJobInUnit(full_time_job_in_unit);
                        info_1_1_1_xu1.setFullTimeJobUnit(full_time_job_unit);
                        info_1_1_1_xu1.setIsRetire(is_retire);
                        info_1_1_1_xu1.setProfessionalAndTechnicalPositions(professional_and_technical_positions);
                        info_1_1_1_xu1.setPostRating(post_rating);
                        info_1_1_1_xu1.setPartyAndGovernmentDuties(party_and_government_duties);
                        info_1_1_1_xu1.setOverseasTrainingExperience(overseas_training_experience);
                        info_1_1_1_xu1.setNameOfSelectedTalentProjectAndYearOfSelection(name_of_selected_talent_project_and_year_of_selection);
                        info_1_1_1_xu1.setHaveOtherIndustryTechnicalTitles(have_other_industry_technical_titles);
                        info_1_1_1_xu1.setHaveAcademicPartTimeAtHomeAndAbroad(have_academic_part_time_at_home_and_abroad);

                        list_1_1_1_xu1.add(info_1_1_1_xu1);
                        sheet1Map.put("list_1_1_1_xu1",list_1_1_1_xu1);
                    }

/**
 *     表  1-1-1 续2
 */
                }
            } else if (row != null && "表1-1-1 博士导师信息表（续2）（时点）".equals(row.getCell(0).getStringCellValue())) {
                DoctorTutorInformation_1_1_1_xu2_shidian info_1_1_1_xu2 ;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet1.getRow(i);
                    if (currentRow != null && "表1-1-2 博士生信息表（时期）".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    }  else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }
                    else {
                        // 继续导入数据

                        info_1_1_1_xu2 = new DoctorTutorInformation_1_1_1_xu2_shidian();


                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);



                        String tutor_category = FormatUtil.getCellValue(currentRow,2);



                        String have_international_cooperation = FormatUtil.getCellValue(currentRow,3);



                        String guide_doctoral_students = FormatUtil.getCellValue(currentRow,4);


                        String first_level_subject = FormatUtil.getCellValue(currentRow,5);


                        String second_level_subject = FormatUtil.getCellValue(currentRow,6);



                        String guide_professional_degree_types = FormatUtil.getCellValue(currentRow,7);



                        String number_of_master_students_enrolled_in_the_unit = FormatUtil.getCellValue(currentRow,8);


                        info_1_1_1_xu2.setTutorIdentificationCode(tutor_identification_code);
                        info_1_1_1_xu2.setTutorCategory(tutor_category);
                        info_1_1_1_xu2.setHaveInternationalCooperation(have_international_cooperation);
                        info_1_1_1_xu2.setGuideDoctoralStudents(guide_doctoral_students);
                        info_1_1_1_xu2.setFirstLevelSubject(first_level_subject);
                        info_1_1_1_xu2.setSecondLevelSubject(second_level_subject);
                        info_1_1_1_xu2.setGuideProfessionalDegreeTypes(guide_professional_degree_types);
                        info_1_1_1_xu2.setNumberOfMasterStudentsEnrolledInTheUnit(number_of_master_students_enrolled_in_the_unit);


                        list_1_1_1_xu2.add(info_1_1_1_xu2);
                        sheet1Map.put("list_1_1_1_xu2",list_1_1_1_xu2);

                    }/**
                     *     表  1-1-2
                     */
                }
            } else if (row != null && "表1-1-2 博士生信息表（时期）".equals(row.getCell(0).getStringCellValue())) {
                DoctorStudentInformation_1_1_2_shiqi info_1_1_2 ;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet1.getRow(i);
                    if (currentRow != null && "结束".equals(currentRow.getCell(0).getStringCellValue()) ){
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    }  else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }
                    else {

                        // 继续导入数据
                        info_1_1_2 = new DoctorStudentInformation_1_1_2_shiqi();

                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);


                        String cooperative_guidance_tutor_identification_code = "";



                        String doctoral_student_identification_code = FormatUtil.getCellValue(currentRow,2);


                        String college = FormatUtil.getCellValue(currentRow,4);

                        String name = FormatUtil.getCellValue(currentRow,3);


                        String student_type = FormatUtil.getCellValue(currentRow,5);


                        String way_of_learning = FormatUtil.getCellValue(currentRow,6);



                        String country = FormatUtil.getCellValue(currentRow,7);



                        String nationality = FormatUtil.getCellValue(currentRow,8);



                        String degree_type = FormatUtil.getCellValue(currentRow,9);



                        String first_level_subject = FormatUtil.getCellValue(currentRow,10);




                        String second_level_subject = FormatUtil.getCellValue(currentRow,11);



                        String current_professional_degree_category = FormatUtil.getCellValue(currentRow,12);


                        String entry_date = FormatUtil.getCellValue(currentRow,13);



                        String have_change_in_student_status = FormatUtil.getCellValue(currentRow,14);



                        String reasons_for_changes_in_student_status = FormatUtil.getCellValue(currentRow,15);


                        String whether_to_award_degree = FormatUtil.getCellValue(currentRow,16);


                        info_1_1_2.setDoctoralStudentIdentificationCode(doctoral_student_identification_code);
                        info_1_1_2.setCollege(college);
                        info_1_1_2.setName(name);
                        info_1_1_2.setTutorIdentificationCode(tutor_identification_code);
                        info_1_1_2.setCooperativeGuidanceTutorIdentificationCode(cooperative_guidance_tutor_identification_code);
                        info_1_1_2.setStudentType(student_type);
                        info_1_1_2.setWayOfLearning(way_of_learning);
                        info_1_1_2.setCountry(country);
                        info_1_1_2.setNationality(nationality);


                        info_1_1_2.setDegreeType(degree_type);
                        info_1_1_2.setFirstLevelSubject(first_level_subject);
                        info_1_1_2.setSecondLevelSubject(second_level_subject);
                        info_1_1_2.setCurrentProfessionalDegreeCategory(current_professional_degree_category);
                        info_1_1_2.setEntryDate(entry_date);
                        info_1_1_2.setHaveChangeInStudentStatus(have_change_in_student_status);
                        info_1_1_2.setReasonsForChangesInStudentStatus(reasons_for_changes_in_student_status);
                        info_1_1_2.setWhetherToAwardDegree(whether_to_award_degree);



                        list_1_1_2.add(info_1_1_2);
                        sheet1Map.put("list_1_1_2",list_1_1_2);
                    }


                }

              /*  System.out.println(list_1_1_1);
                System.out.println(list_1_1_1_xu1);
                System.out.println(list_1_1_1_xu2);
                System.out.println(list_1_1_2.get(0));
                System.out.println(list_1_1_2.get(1));*/
            }else {
                continue;
            }

        }
        return  sheet1Map;
    }
}