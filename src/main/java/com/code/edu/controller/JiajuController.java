package com.code.edu.controller;

import com.code.edu.model.JiajuLunbo;
import com.code.edu.model.JiajuWindow;
import com.code.edu.service.JiajuLunboService;
import com.code.edu.service.JiajuWindowService;
import com.code.edu.utils.Result;
import com.code.edu.utils.ResultFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("jiaju")
public class JiajuController {
    private final static Logger logger = LoggerFactory.getLogger(JiajuController.class);

    @Autowired
    private JiajuLunboService jiajuLunboService;
    @Autowired
    private JiajuWindowService jiajuWindowService;

    @PostMapping("lunbo/list/{companyId}")
    @ResponseBody
    public Result<List<JiajuLunbo>> lunboList(@PathVariable Long companyId){
        return ResultFactory.newInstaceSuccessResult("获取成功",200L,jiajuLunboService.findLunboByTypeAndComId(companyId));
    }

    @PostMapping("window/list/{companyId}")
    @ResponseBody
    public Result<List<JiajuWindow>> windowList(@PathVariable Long companyId){
        return ResultFactory.newInstaceSuccessResult("获取成功",200L,jiajuWindowService.findWindowByTypeAndComId(companyId));
    }

}
