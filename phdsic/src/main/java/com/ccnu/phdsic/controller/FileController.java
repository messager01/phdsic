package com.ccnu.phdsic.controller;

import com.ccnu.phdsic.entities.*;
import com.ccnu.phdsic.mapper.*;
import com.ccnu.phdsic.service.ExportAll;
import com.ccnu.phdsic.service.PHDService;
import com.ccnu.phdsic.service.impl.*;
import com.ccnu.phdsic.util.ExcelUtil;
import com.ccnu.phdsic.util.ExportUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * create by Shipeixin on 2019/11/21 21:27
 */

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    PHDService phdService;

    @Autowired
    Export_1_1_ export_1_1_;

    @Autowired
    Export_1_2_ export_1_2_;

    @Autowired
    Export_2_1_  export_2_1_;

    @Autowired
    Export_2_2_  export_2_2_;

    @Autowired
    Mapper_1_1_1 mapper_1_1_1;


    @Autowired
    Mapper_1_1_1_xu1 mapper_1_1_1_xu1;

    @Autowired
    Mapper_1_1_1_xu2 mapper_1_1_1_xu2;

    @Autowired
    Mapper_1_1_2 mapper_1_1_2;

    @Autowired
    Mapper_1_2_1 mapper_1_2_1;

    @Autowired
    Mapper_2_1_1 mapper_2_1_1;

    @Autowired
    Mapper_2_1_2 mapper_2_1_2;

    @Autowired
    Mapper_2_1_3 mapper_2_1_3;

    @Autowired
    Mapper_2_1_4 mapper_2_1_4;

    @Autowired
    Mapper_2_1_5 mapper_2_1_5;

    @Autowired
    Mapper_2_2_1 mapper_2_2_1;

    @Autowired
    Mapper_2_2_2 mapper_2_2_2;

    @Autowired
    Mapper_2_2_3 mapper_2_2_3;

    @Autowired
    Mapper_2_2_4 mapper_2_2_4;

    @Autowired
    Mapper_2_2_5 mapper_2_2_5;

    @Autowired
    Mapper_2_2_6 mapper_2_2_6;

    @Autowired
    Mapper_2_2_7 mapper_2_2_7;

    @Autowired
    ImportServiceImplSheet_1 importServiceImplSheet_1;

    @Autowired
    ImportServiceImplSheet_2 importServiceImplSheet_2;

    @Autowired
    ImportServiceImplSheet_3 importServiceImplSheet_3;

    @Autowired
    ImportServiceImplSheet_4 importServiceImplSheet_4;

    @Autowired
    ExportAll exportAll;

    @Autowired
    ExportAllDownInfo exportAllDown;


    @Autowired
    GetAllTeacherByCollege getAllTeacherByCollege;

    @Autowired
    ExcelUtil excelUtil;



    //  导师上传
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/upload")
    public MSG upLoad(@RequestParam("file") MultipartFile file) {

        MSG msg = new MSG();
        HashMap<String, String> map = new HashMap<>();

        // 获取原始名字
        String fileName = file.getOriginalFilename();

        try {
            Map<String, List> sheet_1_map = importServiceImplSheet_1.batchImport(fileName, file);
            List list_1_1_1 = sheet_1_map.get("list_1_1_1");



            //  获取导师信息门户号
            /*DoctorTutorInformation_1_1_1_shidian o2 = (DoctorTutorInformation_1_1_1_shidian) list_1_1_1.get(0);
            String idNum = o2.getTutorIdentificationCode();
*/

            if (list_1_1_1 != null){
                for (Object o : list_1_1_1) {
                    mapper_1_1_1.insertDoctorTutorInformation_1_1_1_shidian((DoctorTutorInformation_1_1_1_shidian) o);
                }
            }



            List list_1_1_1_xu1 = sheet_1_map.get("list_1_1_1_xu1");
            if (list_1_1_1_xu1 != null){
                for (Object o : list_1_1_1_xu1) {
                    mapper_1_1_1_xu1.insertDoctorTutorInformation_1_1_1_xu1_shidian((DoctorTutorInformation_1_1_1_xu1_shidian) o);
                }
            }

            List list_1_1_1_xu2 = sheet_1_map.get("list_1_1_1_xu2");
            if (list_1_1_1_xu2 != null){
                for (Object o : list_1_1_1_xu2) {
                    mapper_1_1_1_xu2.insertDoctorTutorInformation_1_1_1_xu2_shidian((DoctorTutorInformation_1_1_1_xu2_shidian) o);
                }
            }



            List list_1_1_2 = sheet_1_map.get("list_1_1_2");
            if (list_1_1_2 != null){

                for (Object o : list_1_1_2) {
                    mapper_1_1_2.insert112((DoctorStudentInformation_1_1_2_shiqi) o);
                }
            }

            //=================================================================================================//

            Map<String, List> sheet_2_map = importServiceImplSheet_2.batchImport(fileName, file);
            List list_1_2_1 = sheet_2_map.get("list_1_2_1");
            if (list_1_2_1 != null){


                for (Object o : list_1_2_1) {
                    mapper_1_2_1.insert121((ResearchProjectSituation_1_2_1_shiqi) o);
                }
            }

            //===================================================================================================//

            Map<String, List> sheet_3_map = importServiceImplSheet_3.batchImport(fileName, file);

            List list_2_1_1 = sheet_3_map.get("list_2_1_1");
            if (list_2_1_1 != null){


                for (Object o : list_2_1_1) {
                    mapper_2_1_1.insert211((CourseStatus_2_1_1_shiqi) o);
                }
            }


            List list_2_1_2 = sheet_3_map.get("list_2_1_2");
            if (list_2_1_2 != null){


                for (Object o : list_2_1_2) {
                    mapper_2_1_2.insert213((GraduateEducationTeachingReformResearchProject_2_1_2_shiqi) o);
                }
            }



            List list_2_1_3 = sheet_3_map.get("list_2_1_3");
            if (list_2_1_3 != null){


                for (Object o : list_2_1_3) {
                    mapper_2_1_3.insert213((PublishingTextbookSituation_2_1_3shqi) o);
                }

            }



            List list_2_1_4 = sheet_3_map.get("list_2_1_4");
            if (list_2_1_4 != null){

                for (Object o : list_2_1_4) {
                    mapper_2_1_4.insert214((AwardsForGraduateTeachingAchievements_2_1_4_shiqi) o);
                }



            }

            List list_2_1_5 = sheet_3_map.get("list_2_1_5");
            if (list_2_1_5 != null){

                for (Object o : list_2_1_5) {
                    mapper_2_1_5.insert215((GuidedDoctoralStudentsAwards_2_1_5_shiqi) o);
                }
            }


            //======================================================================================================//

            Map<String, List> sheet_4_map = importServiceImplSheet_4.batchImport(fileName, file);
            List list_2_2_1 = sheet_4_map.get("list_2_2_1");
            if(list_2_2_1 != null) {


                for (Object o : list_2_2_1) {
                    mapper_2_2_1.insert221((ResearchPapers_2_2_1shiqi) o);
                }
            }

            List list_2_2_2 = sheet_4_map.get("list_2_2_2");
            if(list_2_2_2 != null){


                for (Object o : list_2_2_2) {
                    mapper_2_2_2.insert222((ResearchAwards_2_2_2_shiqi) o);
                }
            }


            List list_2_2_3 = sheet_4_map.get("list_2_2_3");
            if (list_2_2_3 != null){



                for (Object o : list_2_2_3) {
                    mapper_2_2_3.insert223((PublicationStatus_2_2_3_shiqi) o);
                }
            }


            List list_2_2_4 = sheet_4_map.get("list_2_2_4");
            if (list_2_2_4 != null){
                for (Object o : list_2_2_4) {
                    mapper_2_2_4.insert224((PatentOrCopyrightAuthorizationStatus_2_2_4_shiqi) o);
                }
            }



            List list_2_2_5 = sheet_4_map.get("list_2_2_5");
            if (list_2_2_5 != null){

                for (Object o : list_2_2_5) {
                    mapper_2_2_5.insert225((ParticipationInternationalAcademicConferences_2_2_5_shiqi) o);
                }
            }

            List list_2_2_6 = sheet_4_map.get("list_2_2_6");
            if (list_2_2_6 != null){


                for (Object o : list_2_2_6) {
                    mapper_2_2_6.insert226((AcademicAppointment_2_2_6_shidian) o);
                }
            }

            List list_2_2_7 = sheet_4_map.get("list_2_2_7");

            if (list_2_2_7 != null){
                for (Object o : list_2_2_7) {
                    mapper_2_2_7.insert227((RelyingOnScientificResearchPlatform_2_2_7_shidian) o);
                }

            }

            msg.setCode(1);
            map.put("message","上传成功");
            msg.setData(map);
        } catch (Exception e) {
            msg.setCode(0);
            map.put("message","上传失败，请检查上传文件内容格式是否正确。");
            msg.setData(map);
            e.printStackTrace();
        }
        return msg;
    }


    //  导出所有
    @RequestMapping("/export")
    public void downLoad(HttpServletResponse response){
        Map<String, List> allInfo = exportAll.getAllInfo();


        /*//  拿到每个表的数据
        List info_1_1_1 = allInfo.get("info_1_1_1");
        List info_1_1_1_xu1 = allInfo.get("info_1_1_1_xu1");
        List info_1_1_1_xu2 = allInfo.get("info_1_1_1_xu2");
        List info_1_1_2 = allInfo.get("info_1_1_2");
        List info_1_2_1 = allInfo.get("info_1_2_1");
        List info_2_1_1 = allInfo.get("info_2_1_1");
        List info_2_1_2 = allInfo.get("info_2_1_2");
        List info_2_1_3 = allInfo.get("info_2_1_3");
        List info_2_1_4 = allInfo.get("info_2_1_4");
        List info_2_1_5 = allInfo.get("info_2_1_5");
        List info_2_2_1 = allInfo.get("info_2_2_1");
        List info_2_2_2 = allInfo.get("info_2_2_2");
        List info_2_2_3 = allInfo.get("info_2_2_3");
        List info_2_2_4 = allInfo.get("info_2_2_4");
        List info_2_2_5 = allInfo.get("info_2_2_5");
        List info_2_2_6 = allInfo.get("info_2_2_6");
        List info_2_2_7 = allInfo.get("info_2_2_7");*/


        Workbook wbss = new HSSFWorkbook();

        //  创建 17 个  sheet  并设置每个sheet属性
        HSSFSheet  sheet1 = (HSSFSheet) wbss.createSheet("表1-1-1 博士导师信息（时点）");
        for (int i = 0; i <= 17;i++){
            sheet1.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet2 = (HSSFSheet) wbss.createSheet("表1-1-1博士导师信息（续1）（时点)");
        for (int i = 0; i <= 15;i++){
            sheet2.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet3 = (HSSFSheet) wbss.createSheet("表1-1-1 博士导师信息表（续2）（时点）");
        for (int i = 0; i <= 7;i++){
            sheet3.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet4 = (HSSFSheet) wbss.createSheet("表1-1-2 博士生信息表（时期）");
        for (int i = 0; i <= 15;i++){
            sheet4.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet5 = (HSSFSheet) wbss.createSheet("表1-2-1 科研项目情况（时期）");
        for (int i = 0; i <= 13;i++){
            sheet5.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet6 = (HSSFSheet) wbss.createSheet("表2-1-1 开课情况（时期）");
        for (int i = 0; i <= 8;i++){
            sheet6.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet7 = (HSSFSheet) wbss.createSheet("表2-1-2 研究生教育教学改革研究项目情况（时期）");
        for (int i = 0; i <= 8;i++){
            sheet7.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet8 = (HSSFSheet) wbss.createSheet("表2-1-3 出版教材情况（时期）");
        for (int i = 0; i <= 10;i++){
            sheet8.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet9 = (HSSFSheet) wbss.createSheet("表2-1-4 研究生教学成果获奖情况（时期）");
        for (int i = 0; i <= 8;i++){
            sheet9.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet10 = (HSSFSheet) wbss.createSheet("表2-1-5 指导博士生获奖情况（时期）");
        for (int i = 0; i <= 8;i++){
            sheet10.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet11 = (HSSFSheet) wbss.createSheet("表2-2-1 科研论文情况（时期）");
        for (int i = 0; i <= 10;i++){
            sheet11.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet12 = (HSSFSheet) wbss.createSheet("表2-2-2 科研获奖情况（时期）");
        for (int i = 0; i <= 10;i++){
            sheet12.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet13 = (HSSFSheet) wbss.createSheet("表2-2-3 出版著作情况（时期）");
        for (int i = 0; i <= 10;i++){
            sheet13.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet14 = (HSSFSheet) wbss.createSheet("表2-2-4  专利（著作权）授权情况（时期）");
        for (int i = 0; i <= 7;i++){
            sheet14.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet15 = (HSSFSheet) wbss.createSheet("表2-2-5 参加国际学术会议情况（时期）");
        for (int i = 0; i <= 10;i++){
            sheet15.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet16 = (HSSFSheet) wbss.createSheet("表2-2-6 学术任职情况（时点）");
        for (int i = 0; i <= 5;i++){
            sheet16.setColumnWidth(i,20*260);
        }
        HSSFSheet  sheet17 = (HSSFSheet) wbss.createSheet("表2-2-7 依托科研平台情况（时点）");
        for (int i = 0; i <= 5;i++){
            sheet17.setColumnWidth(i,20*260);
        }


        exportAllDown.exportAll1_1_1(allInfo.get("info_1_1_1"),sheet1,wbss);
        exportAllDown.exportAll1_1_1_xu1(allInfo.get("info_1_1_1_xu1"),sheet2,wbss);
        exportAllDown.exportAll1_1_1_xu2(allInfo.get("info_1_1_1_xu2"),sheet3,wbss);
        exportAllDown.exportAll1_1_2(allInfo.get("info_1_1_2"),sheet4,wbss);
        exportAllDown.exportAll1_2_1(allInfo.get("info_1_2_1"),sheet5,wbss);
        exportAllDown.exportAll2_1_1(allInfo.get("info_2_1_1"),sheet6,wbss);

        exportAllDown.exportAll2_1_2(allInfo.get("info_2_1_2"),sheet7,wbss);
        exportAllDown.exportAll2_1_3(allInfo.get("info_2_1_3"),sheet8,wbss);
        exportAllDown.exportAll2_1_4(allInfo.get("info_2_1_4"),sheet9,wbss);
        exportAllDown.exportAll2_1_5(allInfo.get("info_2_1_5"),sheet10,wbss);


        exportAllDown.exportAll2_2_1(allInfo.get("info_2_2_1"),sheet11,wbss);
        exportAllDown.exportAll2_2_2(allInfo.get("info_2_2_2"),sheet12,wbss);
        exportAllDown.exportAll2_2_3(allInfo.get("info_2_2_3"),sheet13,wbss);
        exportAllDown.exportAll2_2_4(allInfo.get("info_2_2_4"),sheet14,wbss);
        exportAllDown.exportAll2_2_5(allInfo.get("info_2_2_5"),sheet15,wbss);
        exportAllDown.exportAll2_2_6(allInfo.get("info_2_2_6"),sheet16,wbss);
        exportAllDown.exportAll2_2_7(allInfo.get("info_2_2_7"),sheet17,wbss);








        ExportUtil.exportFile("华中师范大学博士生导师信息表.xls",wbss,response);

    }


    //  根据id下载
    @RequestMapping("/downloadbyid")
        public  void downLoadById( String idNum,HttpServletResponse response) {

        String nameByIdNum = mapper_1_1_1.getNameByIdNum(idNum);
        Map<String, List> allInformation = phdService.getAllInformation(idNum);
        List list_1_1_1 = allInformation.get("Collection_1_1_1");
        List list_1_1_1_xu1 = allInformation.get("Collection_1_1_1_xu1");
        List list_1_1_1_xu2 = allInformation.get("Collection_1_1_1_xu2");
        List list_1_1_2 = allInformation.get("Collection_1_1_2");
        List list_1_2_1 = allInformation.get("Collection_1_2_1");
        List list_2_1_1 = allInformation.get("Collection_2_1_1");
        List list_2_1_2 = allInformation.get("Collection_2_1_2");
        List list_2_1_3 = allInformation.get("Collection_2_1_3");
        List list_2_1_4 = allInformation.get("Collection_2_1_4");
        List list_2_1_5 = allInformation.get("Collection_2_1_5");
        List list_2_2_1 = allInformation.get("Collection_2_2_1");
        List list_2_2_2 = allInformation.get("Collection_2_2_2");
        List list_2_2_3 = allInformation.get("Collection_2_2_3");
        List list_2_2_4 = allInformation.get("Collection_2_2_4");
        List list_2_2_5 = allInformation.get("Collection_2_2_5");
        List list_2_2_6 = allInformation.get("Collection_2_2_6");
        List list_2_2_7 = allInformation.get("Collection_2_2_7");


        Workbook wbss = new HSSFWorkbook();
        CellStyle cellStyle = wbss.createCellStyle();
        DataFormat dataFormat = wbss.createDataFormat();
        cellStyle.setDataFormat(dataFormat.getFormat("@"));


        //  基础信息sheet1
        HSSFSheet sheet1 = (HSSFSheet) wbss.createSheet("1.1基础信息");
        sheet1.setColumnWidth(0,11000);
        sheet1.setColumnWidth(1,5258);
        sheet1.setColumnWidth(2,6105);
        sheet1.setColumnWidth(3,7900);
        sheet1.setColumnWidth(4,6650);
        sheet1.setColumnWidth(5,7800);
        sheet1.setColumnWidth(6,14000);
        sheet1.setColumnWidth(7,7600);
        sheet1.setColumnWidth(8,9360);
        sheet1.setColumnWidth(9,4680);
        sheet1.setColumnWidth(10,20*260);
        sheet1.setColumnWidth(11,26*260);
        sheet1.setColumnWidth(12,28*260);
        sheet1.setColumnWidth(13,24*260);
        sheet1.setColumnWidth(14,32*260);
        sheet1.setColumnWidth(15,27*260);
        sheet1.setColumnWidth(16,24*260);
        sheet1.setColumnWidth(17,24*260);

       /* CellRangeAddress range = new CellRangeAddress(0, 0, 0, 17);
               sheet1.addMergedRegion(range);
        HSSFCellStyle headstyle = (HSSFCellStyle) wbss.createCellStyle();
        headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);*/
        //  基础信息sheet2
        HSSFSheet  sheet2 = (HSSFSheet) wbss.createSheet("1.2科研项目");

        sheet2.setColumnWidth(0,25*260);
        sheet2.setColumnWidth(1,23*260);
        sheet2.setColumnWidth(2,23*260);
        sheet2.setColumnWidth(3,15*260);
        sheet2.setColumnWidth(4,15*260);
        sheet2.setColumnWidth(5,15*260);
        sheet2.setColumnWidth(6,25*260);
        sheet2.setColumnWidth(7,10*260);
        sheet2.setColumnWidth(8,16*260);
        sheet2.setColumnWidth(9,27*260);
        sheet2.setColumnWidth(10,27*260);
        sheet2.setColumnWidth(11,27*260);
        sheet2.setColumnWidth(12,27*260);
        sheet2.setColumnWidth(13,22*260);
        sheet2.setColumnWidth(14,14*260);
        //  基础信息sheet3
        HSSFSheet  sheet3 = (HSSFSheet) wbss.createSheet("2.1教学信息");
        sheet3.setColumnWidth(0,52*260);
        sheet3.setColumnWidth(1,23*260);
        sheet3.setColumnWidth(2,18*260);
        sheet3.setColumnWidth(3,22*260);
        sheet3.setColumnWidth(4,20*260);
        sheet3.setColumnWidth(5,45*260);
        sheet3.setColumnWidth(6,18*260);
        sheet3.setColumnWidth(7,21*260);
        sheet3.setColumnWidth(8,25*260);
        sheet3.setColumnWidth(9,20*260);
        sheet3.setColumnWidth(10,13*260);
        sheet3.setColumnWidth(11,12*260);
        //  基础信息sheet4
        HSSFSheet  sheet4 = (HSSFSheet) wbss.createSheet("2.2其他科研信息");
        sheet4.setColumnWidth(0,46*260);
        sheet4.setColumnWidth(1,23*260);
        sheet4.setColumnWidth(2,23*260);
        sheet4.setColumnWidth(3,26*260);
        sheet4.setColumnWidth(4,29*260);
        sheet4.setColumnWidth(5,27*260);
        sheet4.setColumnWidth(6,27*260);
        sheet4.setColumnWidth(7,26*260);
        sheet4.setColumnWidth(8,29*260);
        sheet4.setColumnWidth(9,29*260);
        sheet4.setColumnWidth(10,22*260);
        sheet4.setColumnWidth(11,18*260);
        sheet4.setColumnWidth(12,20*260);
        // 每个sheet的开始位置
        Integer sheet1StartIndex = 0;

        Integer sheet3StartIndex = 0;

        Integer sheet4StartIndex = 0;


        /**
         *
         *
         *
         *
         * 1.1 基础信息   1-1-1    1-1-1（续1）  1-1-1（续2）   1-1-2
         *
         *
         *
         *
         */
        sheet1StartIndex = export_1_1_.exportByClass1_1_1(list_1_1_1, sheet1, sheet1StartIndex,wbss);
        //System.out.println(sheet1StartIndex);


        sheet1StartIndex = export_1_1_.exportByClass1_1_1_xu1(list_1_1_1_xu1,sheet1,sheet1StartIndex,nameByIdNum,wbss);
        //System.out.println(sheet1StartIndex);

        sheet1StartIndex = export_1_1_.exportByClass1_1_1_xu2(list_1_1_1_xu2,sheet1,sheet1StartIndex, nameByIdNum,wbss);


        export_1_1_.exportByClass1_1_2(list_1_1_2,sheet1,sheet1StartIndex, nameByIdNum,wbss);
        //System.out.println(sheet1StartIndex);


        /**
         *
         *
         *
         * 1.2 科研信息
         *
         *
         *
         *
         */

        export_1_2_.exportByClass1_2_1(list_1_2_1,sheet2, nameByIdNum,wbss);


        /**
         *
         *
         *
         * 2.1 教学信息   2-1-1   2-1-2  2-1-3  2-1-4  2-1-5
         *
         *
         *
         *
         */


        sheet3StartIndex =  export_2_1_.exportByClass2_1_1(list_2_1_1,sheet3,sheet3StartIndex, nameByIdNum,wbss);

        //
        sheet3StartIndex = export_2_1_.exportByClass2_1_2(list_2_1_2,sheet3,sheet3StartIndex, nameByIdNum,wbss);

        sheet3StartIndex = export_2_1_.exportByClass2_1_3(list_2_1_3,sheet3,sheet3StartIndex, nameByIdNum,wbss);

        sheet3StartIndex = export_2_1_.exportByClass2_1_4(list_2_1_4,sheet3,sheet3StartIndex, nameByIdNum,wbss);

        sheet3StartIndex = export_2_1_.exportByClass2_1_5(list_2_1_5,sheet3,sheet3StartIndex, nameByIdNum,wbss);


        /**
         *
         *
         *
         * 2.2 科研信息   2-2-1   2-2-2   2-2-3  2-2-4   2-2-5   2-2-6   2-2-7
         *
         *
         *
         *
         */
        sheet4StartIndex =  export_2_2_.exportByClass2_2_1(list_2_2_1,sheet4,sheet4StartIndex, nameByIdNum,wbss);

        sheet4StartIndex =  export_2_2_.exportByClass2_2_2(list_2_2_2,sheet4,sheet4StartIndex, nameByIdNum,wbss);

        sheet4StartIndex =  export_2_2_.exportByClass2_2_3(list_2_2_3,sheet4,sheet4StartIndex, nameByIdNum,wbss);

        sheet4StartIndex =  export_2_2_.exportByClass2_2_4(list_2_2_4,sheet4,sheet4StartIndex, nameByIdNum,wbss);

        sheet4StartIndex =  export_2_2_.exportByClass2_2_5(list_2_2_5,sheet4,sheet4StartIndex, nameByIdNum,wbss);

        sheet4StartIndex =  export_2_2_.exportByClass2_2_6(list_2_2_6,sheet4,sheet4StartIndex, nameByIdNum,wbss);

        sheet4StartIndex =  export_2_2_.exportByClass2_2_7(list_2_2_7,sheet4,sheet4StartIndex, nameByIdNum,wbss);


        for (int i = 4;i <= wbss.getNumberOfSheets()-1;i++){
            wbss.setSheetHidden(i,true);
        }

         ExportUtil.exportFile(nameByIdNum+".xls",wbss,response);


    }




    //  根据院系下载
    @RequestMapping("/downloadbycollege")
    public  void downLoadByCollege(String collegeName,HttpServletResponse response) throws IOException {


        List<String> idByCollege = mapper_1_1_1.getIdByCollege(collegeName);

        List<String> fileName = new ArrayList<>();
        // 创建
        File file = new File("/opt/template/"+collegeName);

        if(!file.exists()){
            file.mkdir();
        }
        //System.out.println(file.getPath());
        //System.out.println(file.getAbsoluteFile());
        for (String id : idByCollege) {
            Workbook workbook = excelUtil.generateExcel(id);
//                                                              "E:/template/"+mapper_1_1_1.getNameByIdNum(id)+".xls"
            FileOutputStream fout = new FileOutputStream(file.getAbsolutePath()+"/"+mapper_1_1_1.getNameByIdNum(id)+".xls");
            workbook.write(fout);
            fileName.add(mapper_1_1_1.getNameByIdNum(id)+".xls");



            fout.close();


        }

        System.out.println(fileName);
        //  将某个学院的所有excel放在一个文件夹下

        // 压缩下载
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
        response.setHeader("Content-Disposition","attachment; filename=\"information.zip\"");

        ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());

        for(String f : fileName) {
            ZipEntry zipEntry = new ZipEntry(f);
            zipOutputStream.putNextEntry(zipEntry);
            System.out.println(file.getAbsolutePath());
            FileInputStream inputStream = new FileInputStream(file.getAbsolutePath()+"/"+f);
            IOUtils.copy(inputStream,zipOutputStream);
            inputStream.close();
        }

        zipOutputStream.closeEntry();
        zipOutputStream.close();

        // 删除该目下 的所有内容
        ExcelUtil.deleteDir(file.getAbsolutePath());
    }


    // 删除所有
    @RequestMapping("/deleteAll")
    public String deleteAll(){

        try {
            mapper_1_1_1.deleteAll();
            mapper_1_1_1_xu1.deleteAll();
            mapper_1_1_1_xu2.deleteAll();
            mapper_1_1_2.deleteAll();
            mapper_1_2_1.deleteAll();
            mapper_2_1_1.deleteAll();
            mapper_2_1_2.deleteAll();
            mapper_2_1_3.deleteAll();
            mapper_2_1_4.deleteAll();
            mapper_2_1_5.deleteAll();
            mapper_2_2_1.deleteAll();
            mapper_2_2_2.deleteAll();
            mapper_2_2_3.deleteAll();
            mapper_2_2_4.deleteAll();
            mapper_2_2_5.deleteAll();
            mapper_2_2_6.deleteAll();
            mapper_2_2_7.deleteAll();

            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }


    }



    // 按id删除
    @RequestMapping("/delete")
    public String deleteById(String id){
        try {
            mapper_1_1_1.deleteById(id);
            mapper_1_1_1_xu1.deleteById(id);
            mapper_1_1_1_xu2.deleteById(id);

            mapper_1_1_2.deleteById(id);
            mapper_1_2_1.deleteById(id);

            mapper_2_1_1.deleteById(id);
            mapper_2_1_2.deleteById(id);
            mapper_2_1_3.deleteById(id);
            mapper_2_1_4.deleteById(id);
            mapper_2_1_5.deleteById(id);


            mapper_2_2_1.deleteById(id);
            mapper_2_2_2.deleteById(id);
            mapper_2_2_3.deleteById(id);
            mapper_2_2_4.deleteById(id);
            mapper_2_2_5.deleteById(id);
            mapper_2_2_6.deleteById(id);
            mapper_2_2_7.deleteById(id);

            return  "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }
}
