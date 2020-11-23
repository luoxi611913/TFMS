package com.tfms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tfms.model.Transmission;
import com.tfms.service.TransmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ZhaoJiaLin
 * @date 2020-11-18 17:09
 * @description：
 */
@Controller
@RequestMapping("/transmission")
public class TransmissionController {
    @Autowired
    private TransmissionService transmissionService;

    @ResponseBody
    @PostMapping("/selectByParam")
    List<Transmission> selectByParam(Transmission transmission){
        return transmissionService.selectByParam(transmission);
    }
    @ResponseBody
    @GetMapping("/selectPageByParam")
    PageInfo<Transmission> selectPageByParam(Transmission transmission){
        PageHelper.startPage(transmission.getPageNum(),transmission.getPageSize());
        List<Transmission> transmissions = transmissionService.selectByParam(transmission);
        return new PageInfo<>(transmissions);
    }
    @ResponseBody
    @PostMapping("/insert")
    public int insert(Transmission transmission){
        return transmissionService.insert(transmission);
    }
    @ResponseBody
    @PostMapping("/update")
    public int update(Transmission transmission){
        return transmissionService.update(transmission);

    }
    @ResponseBody
    @PostMapping("/delete")
    public int delete(Transmission transmission){
        return transmissionService.delete(transmission);
    }

    @RequestMapping("/findView")
    public String findView(){
        return "transmission/transmissionPage";
    }
}
