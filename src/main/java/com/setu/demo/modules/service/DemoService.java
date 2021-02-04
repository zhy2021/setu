package com.setu.demo.modules.service;

import com.setu.demo.modules.dto.SetuReqParams;
import com.setu.demo.modules.vo.SetuVO;

import java.util.List;

public interface DemoService {
    List<SetuVO> getInfoFromInterface(SetuReqParams setuReqParams);
}
