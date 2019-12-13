package com.ccnu.phdsic.util;

import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * create by Shipeixin on 2019/11/22 16:04
 */
public class ExportUtil {
    public static void exportFile(String fileName, Workbook wbss, HttpServletResponse response){
        try {
            response.setHeader("Content-disposition", "attachment; filename=\""
                    + new String(fileName.getBytes("GBK"), "ISO-8859-1")+"\"");

            OutputStream out = response.getOutputStream();
            wbss.write(out);

            out.flush();
            out.close();

        }catch (IOException ioe) {
            ioe.printStackTrace();
            output(response, "您所请求的文件出现异常！");
        } catch (Exception e) {
            e.printStackTrace();
            output(response, "您所请求的文件出现异常！");
        }
    }

    public static void output(HttpServletResponse response, String message) {
        try {
            response.setContentType("text/html; charset=UTF-8");
            Writer out = response.getWriter();
            out.write(message);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
