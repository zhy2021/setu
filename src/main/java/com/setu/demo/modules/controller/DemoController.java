package com.setu.demo.modules.controller;

import com.alibaba.fastjson.JSONObject;
import com.setu.demo.modules.dto.SetuReqParams;
import com.setu.demo.modules.service.DemoService;
import com.setu.demo.modules.vo.Result;
import com.setu.demo.modules.vo.SetuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/01/29 11:05
 */
@RestController
@CrossOrigin
public class DemoController {
    @Autowired
    private DemoService demoService;
    @PostMapping("/demo")
    public Result<?> test(@RequestBody SetuReqParams setuReqParams){
        List<SetuVO> list = demoService.getInfoFromInterface(setuReqParams);
        return Result.OK(list);
    }
}
