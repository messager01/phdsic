package com.ccnu.phdsic.util;

import com.ccnu.phdsic.mapper.*;
import com.ccnu.phdsic.service.ExportAll;
import com.ccnu.phdsic.service.PHDService;
import com.ccnu.phdsic.service.impl.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * create by Shipeixin on 2019/11/27 11:53
 */
@Component
public class ExcelUtil {

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
    public  Workbook generateExcel(String idNum) {

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

        sheet2.setColumnWidth(0,12*260);
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


        /**
         * 将要 隐藏的sheet  隐藏起来
         */
        for (int i = 4;i <= wbss.getNumberOfSheets()-1;i++){
            wbss.setSheetHidden(i,true);
        }



        return wbss;

    }

    public static void deleteDir(String dirPath)
    {
        File file = new File(dirPath);
        if(file.isFile())
        {
            file.delete();
        }else
        {
            File[] files = file.listFiles();
            if(files == null)
            {
                file.delete();
            }else
            {
                for (int i = 0; i < files.length; i++)
                {
                    deleteDir(files[i].getAbsolutePath());
                }
                file.delete();
            }
        }
    }

}
