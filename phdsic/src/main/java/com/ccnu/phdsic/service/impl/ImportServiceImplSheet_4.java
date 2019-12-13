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

import javax.crypto.Cipher;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by Shipeixin on 2019/11/23 10:39
 */

@Service
public class ImportServiceImplSheet_4 implements ImportService {

    // 异常时回滚
    @Transactional
    @Override
    public Map<String,List> batchImport(String fileName, MultipartFile file) throws Exception {

        List<ResearchPapers_2_2_1shiqi> list_2_2_1 = new ArrayList<>();
        List<ResearchAwards_2_2_2_shiqi> list_2_2_2 = new ArrayList<>();
        List<PublicationStatus_2_2_3_shiqi> list_2_2_3 = new ArrayList<>();
        List<PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi> list_2_2_4 = new ArrayList<>();
        List<ParticipationInternationalAcademicConferences_2_2_5_shiqi> list_2_2_5 = new ArrayList<>();
        List<AcademicAppointment_2_2_6_shidian> list_2_2_6 = new ArrayList<>();
        List<RelyingOnScientificResearchPlatform_2_2_7_shidian> list_2_2_7 = new ArrayList<>();

        Map<String, List> sheet4Map = new HashMap<>();
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

        // 获得第4个sheet
        Sheet sheet4 = wb.getSheetAt(3);

        int num = sheet4.getLastRowNum();

        System.out.println(sheet4.getLastRowNum());
        for (int r = 0; r <= sheet4.getLastRowNum(); r++) {
            Row row = sheet4.getRow(r);
            //  导入第一张表

            /**
             *     表  2-2-1
             */
            if (row != null && "表2-2-1 科研论文情况（时期）".equals(row.getCell(0).getStringCellValue())) {

                ResearchPapers_2_2_1shiqi info_2_2_1;


                // 找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet4.getRow(i);
                    if (currentRow != null && "表2-2-2 科研获奖情况（时期）".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }else {
                        // 继续导入数据
                        info_2_2_1 = new ResearchPapers_2_2_1shiqi();

                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);


                        String paper_name = FormatUtil.getCellValue(currentRow,2);


                        String paper_type = FormatUtil.getCellValue(currentRow,3);


                        String journal_name = FormatUtil.getCellValue(currentRow,4);


                        String issue_number = FormatUtil.getCellValue(currentRow,5);


                        String publishing_language = FormatUtil.getCellValue(currentRow,6);


                        String DOI = FormatUtil.getCellValue(currentRow,7);


                        String whether_esi_is_included = FormatUtil.getCellValue(currentRow,8);


                        String index = FormatUtil.getCellValue(currentRow,9);


                        String author_order = FormatUtil.getCellValue(currentRow,10);


                        String whether_corresponding_author = FormatUtil.getCellValue(currentRow,11);


                        info_2_2_1.setTutorIdentificationCode(tutor_identification_code);
                        info_2_2_1.setPaperName(paper_name);
                        info_2_2_1.setPaperType(paper_type);
                        info_2_2_1.setJournalName(journal_name);
                        info_2_2_1.setIssueNumber(issue_number);
                        info_2_2_1.setPublishingLanguage(publishing_language);
                        info_2_2_1.setDOI(DOI);
                        info_2_2_1.setWhetherEsIIsIncluded(whether_esi_is_included);
                        info_2_2_1.setIndex(index);
                        info_2_2_1.setAuthorOrder(author_order);
                        info_2_2_1.setWhetherCorrespondingAuthor(whether_corresponding_author);

                        list_2_2_1.add(info_2_2_1);
                        sheet4Map.put("list_2_2_1", list_2_2_1);
                        //System.out.println(list_1_1_1);
                    }
                }

/**
 *     表  2-2-2
 */
            } else if (row != null && "表2-2-2 科研获奖情况（时期）".equals(row.getCell(0).getStringCellValue())) {
                ResearchAwards_2_2_2_shiqi info_2_2_2;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet4.getRow(i);
                    if (currentRow != null && "表2-2-3 出版著作情况（时期）".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }else {
                        info_2_2_2 = new ResearchAwards_2_2_2_shiqi();
                        // 继续导入数据

                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);


                        String award_level = FormatUtil.getCellValue(currentRow,2);



                        String award_name = FormatUtil.getCellValue(currentRow,3);



                        String whether_first_completed_unit = FormatUtil.getCellValue(currentRow,4);


                        String award_category = FormatUtil.getCellValue(currentRow,5);


                        String award_grade = FormatUtil.getCellValue(currentRow,6);



                        String award_date = FormatUtil.getCellValue(currentRow,7);



                        String awarding_unit = FormatUtil.getCellValue(currentRow,8);


                        String award_certificate_number = FormatUtil.getCellValue(currentRow,9);


                        String complete_unit_ranking = FormatUtil.getCellValue(currentRow,10);


                        String sort_by_name = FormatUtil.getCellValue(currentRow,11);


                        info_2_2_2.setTutorIdentificationCode(tutor_identification_code);
                        info_2_2_2.setAwardLevel(award_level);
                        info_2_2_2.setAwardName(award_name);
                        info_2_2_2.setWhetherFirstCompletedUnit(whether_first_completed_unit);
                        info_2_2_2.setAwardCategory(award_category);
                        info_2_2_2.setAwardDate(award_date);
                        info_2_2_2.setAwardGrade(award_grade);
                        info_2_2_2.setAwardingUnit(awarding_unit);
                        info_2_2_2.setAwardCertificateNumber(award_certificate_number);
                        info_2_2_2.setCompleteUnitRanking(complete_unit_ranking);
                        info_2_2_2.setSortByName(sort_by_name);


                        list_2_2_2.add(info_2_2_2);
                        sheet4Map.put("list_2_2_2", list_2_2_2);
                    }

/**
 *     表  2-2-3
 */
                }
            } else if (row != null && "表2-2-3 出版著作情况（时期）".equals(row.getCell(0).getStringCellValue())) {
                PublicationStatus_2_2_3_shiqi info_2_2_3;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet4.getRow(i);
                    if (currentRow != null && "表2-2-4  专利（著作权）授权情况（时期）".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }else {
                        // 继续导入数据

                        info_2_2_3 = new PublicationStatus_2_2_3_shiqi();


                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);



                        String book_name = FormatUtil.getCellValue(currentRow,2);


                        String book_type = FormatUtil.getCellValue(currentRow,3);


                        String publishing_house = FormatUtil.getCellValue(currentRow,4);


                        String publisher_country = FormatUtil.getCellValue(currentRow,5);


                        String total_number_of_words = FormatUtil.getCellValue(currentRow,6);



                        String number_of_issues = FormatUtil.getCellValue(currentRow,7);



                        String publication_date = FormatUtil.getCellValue(currentRow,8);


                        String book_number = FormatUtil.getCellValue(currentRow,9);


                        String language = FormatUtil.getCellValue(currentRow,10);


                        String role = FormatUtil.getCellValue(currentRow,11);


                        info_2_2_3.setTutorIdentificationCode(tutor_identification_code);
                        info_2_2_3.setBookName(book_name);
                        info_2_2_3.setBookType(book_type);
                        info_2_2_3.setPublishingHouse(publishing_house);
                        info_2_2_3.setPublisherCountry(publisher_country);
                        info_2_2_3.setTotalNumberOfWords(total_number_of_words);
                        info_2_2_3.setNumberOfIssues(number_of_issues);
                        info_2_2_3.setPublicationDate(publication_date);
                        info_2_2_3.setBookNumber(book_number);
                        info_2_2_3.setLanguage(language);
                        info_2_2_3.setRole(role);


                        list_2_2_3.add(info_2_2_3);
                        sheet4Map.put("list_2_2_3", list_2_2_3);

                    }/**
                     *     表  2-2-4
                     */
                }
            } else if (row != null && "表2-2-4  专利（著作权）授权情况（时期）".equals(row.getCell(0).getStringCellValue())) {
                PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi info_2_2_4;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet4.getRow(i);
                    if (currentRow != null && "表2-2-5 参加国际学术会议情况（时期）".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }else {

                        // 继续导入数据
                        info_2_2_4 = new PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi();

                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);



                        String patent_or_book_name = FormatUtil.getCellValue(currentRow,2);



                        String intellectual_property_category = FormatUtil.getCellValue(currentRow,3);



                        String authorization_number = FormatUtil.getCellValue(currentRow,4);


                        String approved_date = FormatUtil.getCellValue(currentRow,5);


                        String sort_by_me = FormatUtil.getCellValue(currentRow,6);



                        String whether_unit_is_first_application_unit = FormatUtil.getCellValue(currentRow,7);


                        String whether_industry_joint_patent = FormatUtil.getCellValue(currentRow,8);



                        info_2_2_4.setTutorIdentificationCode(tutor_identification_code);
                        info_2_2_4.setPatentOrBookName(patent_or_book_name);
                        info_2_2_4.setIntellectualPropertyCategory(intellectual_property_category);
                        info_2_2_4.setAuthorizationNumber(authorization_number);
                        info_2_2_4.setApprovedDate(approved_date);
                        info_2_2_4.setSortByMe(sort_by_me);
                        info_2_2_4.setWhetherUnitIsFirstApplicationUnit(whether_unit_is_first_application_unit);
                        info_2_2_4.setWhetherIndustryJointPatent(whether_industry_joint_patent);




                        list_2_2_4.add(info_2_2_4);
                        sheet4Map.put("list_2_2_4", list_2_2_4);
                    }


                }

                /**
                 *     2-2-5
                 */
            } else if (row != null && "表2-2-5 参加国际学术会议情况（时期）".equals(row.getCell(0).getStringCellValue())) {
                ParticipationInternationalAcademicConferences_2_2_5_shiqi info_2_2_5;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet4.getRow(i);
                    if (currentRow != null &&  "表2-2-6 学术任职情况（时点）".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }else {

                        // 继续导入数据
                        info_2_2_5 = new ParticipationInternationalAcademicConferences_2_2_5_shiqi();

                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);


                        String academic_conference_name = FormatUtil.getCellValue(currentRow,2);


                        String organizer = FormatUtil.getCellValue(currentRow,3);


                        String conference_held_country_or_region = FormatUtil.getCellValue(currentRow,4);


                        String conference_city = FormatUtil.getCellValue(currentRow,5);


                        String opening_date_of_meeting = FormatUtil.getCellValue(currentRow,6);



                        String whether_chairman_of_conference = FormatUtil.getCellValue(currentRow,7);



                        String report_type = FormatUtil.getCellValue(currentRow,8);



                        String report_name = FormatUtil.getCellValue(currentRow,9);



                        String report_date = FormatUtil.getCellValue(currentRow,10);



                        String reporter = FormatUtil.getCellValue(currentRow,11);


                        info_2_2_5.setTutorIdentificationCode(tutor_identification_code);
                        info_2_2_5.setAcademicConferenceName(academic_conference_name);
                        info_2_2_5.setOrganizer(organizer);
                        info_2_2_5.setConferenceHeldCountryOrRegion(conference_held_country_or_region);
                        info_2_2_5.setConferenceCity(conference_city);
                        info_2_2_5.setOpeningDateOfMeeting(opening_date_of_meeting);
                        info_2_2_5.setWhetherChairmanOfConference(whether_chairman_of_conference);
                        info_2_2_5.setReportType(report_type);
                        info_2_2_5.setReportName(report_name);
                        info_2_2_5.setReportDate(report_date);
                        info_2_2_5.setReporter(reporter);





                        list_2_2_5.add(info_2_2_5);
                        sheet4Map.put("list_2_2_5", list_2_2_5);
                    }


                }

            }else if (row != null && "表2-2-6 学术任职情况（时点）".equals(row.getCell(0).getStringCellValue())) {
                AcademicAppointment_2_2_6_shidian info_2_2_6;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet4.getRow(i);
                    if (currentRow != null && "表2-2-7 依托科研平台情况（时点）".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }else {

                        // 继续导入数据
                        info_2_2_6 = new AcademicAppointment_2_2_6_shidian();

                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);



                        String job_title = FormatUtil.getCellValue(currentRow,2);



                        String job_level = FormatUtil.getCellValue(currentRow,3);


                        String employment_organization = FormatUtil.getCellValue(currentRow,4);


                        String organization_type = FormatUtil.getCellValue(currentRow,5);


                        String start_of_office = FormatUtil.getCellValue(currentRow,6);





                        info_2_2_6.setTutorIdentificationCode(tutor_identification_code);
                        info_2_2_6.setJobTitle(job_title);
                        info_2_2_6.setJobLevel(job_level);
                        info_2_2_6.setEmploymentOrganization(employment_organization);
                        info_2_2_6.setOrganizationType(organization_type);
                        info_2_2_6.setStartOfOffice(start_of_office);





                        list_2_2_6.add(info_2_2_6);
                        sheet4Map.put("list_2_2_6", list_2_2_6);
                    }


                }

            }else if (row != null && "表2-2-7 依托科研平台情况（时点）".equals(row.getCell(0).getStringCellValue())) {
                RelyingOnScientificResearchPlatform_2_2_7_shidian info_2_2_7;
                //找到信息
                for (int i = r + 2; i < Integer.MAX_VALUE; i++) {
                    Row currentRow = sheet4.getRow(i);
                    if (currentRow != null && "结束".equals(currentRow.getCell(0).getStringCellValue())) {
                        //  说明小部分sheet 全部扫描完毕，  跳出第一部分扫描
                        break;
                    } else if (currentRow == null || "".equals(currentRow.getCell(0).getStringCellValue())){
                        continue;
                    }else {

                        // 继续导入数据
                        info_2_2_7 = new RelyingOnScientificResearchPlatform_2_2_7_shidian();

                        String tutor_identification_code = FormatUtil.getCellValue(currentRow,1);


                        String research_platform_name = FormatUtil.getCellValue(currentRow,2);


                        String research_platform_level = FormatUtil.getCellValue(currentRow,3);


                        String research_platform_category = FormatUtil.getCellValue(currentRow,4);


                        String provincial_and_ministerial_authorities = FormatUtil.getCellValue(currentRow,5);


                        String serve = FormatUtil.getCellValue(currentRow,6);


                        info_2_2_7.setTutorIdentificationCode(tutor_identification_code);
                        info_2_2_7.setResearchPlatformName(research_platform_name);
                        info_2_2_7.setResearchPlatformLevel(research_platform_level);
                        info_2_2_7.setResearchPlatformCategory(research_platform_category);
                        info_2_2_7.setProvincialAndMinisterialAuthorities(provincial_and_ministerial_authorities);
                        info_2_2_7.setServe(serve);






                        list_2_2_7.add(info_2_2_7);
                        sheet4Map.put("list_2_2_7", list_2_2_7);
                    }


                }

            }else {
                continue;
            }

        }
        return sheet4Map;
    }
}