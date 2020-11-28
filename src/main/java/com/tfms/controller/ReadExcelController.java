package com.tfms.controller;

import com.tfms.model.Transmission;
import com.tfms.service.TestService;
import com.tfms.service.TransmissionService;
import com.tfms.util.MakeHtml;
import jxl.read.biff.BiffException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

            System.out.println(uploadFilePath);

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


    /**
     * Excel读取
     */
    @RequestMapping("/exceldo")
    public String ExcelRead(MultipartFile file, Map<String,Object> map) {

        System.out.println(file.getOriginalFilename());

        if (null == file || file.getSize() < 1) {
            System.out.println("文件无用");
        }

        InputStream fileInputStream = null;

        XSSFWorkbook xssfWorkbook = null;

        //创建list
        List<Transmission> list = new ArrayList<Transmission>();

        try {
            //获取文件流
            fileInputStream = file.getInputStream();

            //封入表格对象
            xssfWorkbook = new XSSFWorkbook(fileInputStream);



            //循环遍历sheet
            for (int i = 0; i < xssfWorkbook.getNumberOfSheets(); i++) {

                //获得sheet
                XSSFSheet sheet = xssfWorkbook.getSheetAt(i);

                //循环遍历行
                for (int j = 0; j < sheet.getLastRowNum(); j++) {
                    System.out.println("有几行？" + sheet.getLastRowNum());

                    int count = 0;

                    //获得row
                    XSSFRow row = sheet.getRow(j);

                    Transmission transmission = new Transmission();
                    transmission.setStartUser(row.getCell(count++).toString());
                    transmission.setJumperPort(row.getCell(count++).toString());
                    transmission.setJumperPosition(row.getCell(count++).toString());
                    transmission.setLinkOne(row.getCell(count++).toString());
                    transmission.setLinkTwo(row.getCell(count++).toString());
                    transmission.setLocalPort(row.getCell(count++).toString());
                    transmission.setOpenPath(row.getCell(count++).toString());
                    transmission.setChannelCode(row.getCell(count++).toString());
                    transmission.setDevicePort(row.getCell(count++).toString());
                    transmission.setEndUser(row.getCell(count++).toString());
                    transmission.setFullRouting(row.getCell(count++).toString());
                    transmission.setRemarks(row.getCell(count++).toString());
                    list.add(transmission);
                    //遍历excel
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("处理Excel遇到错误，请重试");
        } finally {

            try {
                if (xssfWorkbook != null) {
                    xssfWorkbook.close();
                }

                if (fileInputStream != null) {
                    fileInputStream.close();
                }

            } catch (Exception e) {
                System.out.println("关闭异常"+e.getMessage());
            }

        }

//        //获取第一个sheet
//        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
//
//        System.out.println(xssfSheet);
//
//        //获取第一行
//        XSSFRow row = xssfSheet.getRow(0);
//        System.out.println(row);
//
//        //获取第一个单元格
//        XSSFCell cell = row.getCell(0);
//        System.out.println(cell);
        map.put("uname","luoxi");
        map.put("ulist",list);
        return "WriteExcel/excelconfirm";
    }

    @Autowired
    TransmissionService transmissionService;

    @RequestMapping("/dataConfirm")
    @ResponseBody
    public String dataConfirm(@RequestBody List<Transmission> dataList){

        for(Transmission transmission:dataList){
            System.out.println(transmission.toString());

            if(transmission.getId() == null || transmission.getId().equals("null")){
                transmission.setId("-1");
            }

            transmissionService.insert(transmission);
        }

        return "sss";
    }
}
