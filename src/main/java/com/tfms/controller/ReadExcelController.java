package com.tfms.controller;

import com.tfms.service.TestService;
import com.tfms.util.MakeHtml;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/read")
public class ReadExcelController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    TestService testService;

    @RequestMapping(value = "/readExcel", method = RequestMethod.POST)
    public String readExcel(String filePth) {
        String readExcelResult = "";
        File file = new File(filePth);
        if(!file.exists()){
            // 文件不存在
            throw new RuntimeException("文件不存在，请联系田凡");
        }
        try {
            //读取结果发送至页面，待后续
            readExcelResult = MakeHtml.readExcel(filePth);
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
        return readExcelResult;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        Map<String,String> reMap=new HashMap<>();
        String flag="0";
        String msg="";
        if(!multipartFile.isEmpty()){
            //获取客户端文件名称
            String fileName=multipartFile.getOriginalFilename();
            //服务器上文件保存路径
            String uploadFilePath=request.getSession().getServletContext().getRealPath("/")+File.separator+fileName;
            File file=new File(uploadFilePath);
            try {
                multipartFile.transferTo(file);
                //删除文件
                flag="1";
                msg="上传成功;";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            msg="入参有空值请检查;";
        }
        reMap.put("flag",flag);
        reMap.put("errorMsg",msg);
        return reMap;
    }


}
