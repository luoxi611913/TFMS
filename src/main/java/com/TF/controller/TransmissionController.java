package com.TF.controller;

import com.TF.model.Transmission;
import com.TF.service.TransmissionService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
