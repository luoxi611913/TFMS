package com.TF.controller;

import com.TF.Util.makeHtml;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class ReadExcel {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/readExcel")
    public String readExcel(Model model) {
        String readExcelResult = "";
        String filePth = "";
        filePth = request.getSession().getServletContext().getRealPath("/")+"WEB-INF/pages/ReadExexl/DDF.xls";
        File file = new File(filePth);
        if(!file.exists()){
            // 文件不存在
            throw new RuntimeException("文件不存在，请联系田凡");
        }
        try {
            readExcelResult = makeHtml.readExcel(filePth);
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
        model.addAttribute("excel",readExcelResult);
        return "WriteExcel/test";
    }

}
