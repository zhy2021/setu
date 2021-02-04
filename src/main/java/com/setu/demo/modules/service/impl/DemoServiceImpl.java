package com.setu.demo.modules.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.setu.demo.modules.constant.ApiConstant;
import com.setu.demo.modules.dto.SetuReqParams;
import com.setu.demo.modules.service.DemoService;
import com.setu.demo.modules.vo.SetuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/01/29 16:38
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<SetuVO> getInfoFromInterface(SetuReqParams setuReqParams) {
        StringBuilder url = new StringBuilder(ApiConstant.API);
        url.append("?apikey={apikey}");
        String apikey = setuReqParams.getApikey();
        if (StringUtils.isEmpty(apikey)){
            apikey = ApiConstant.APIKEY;
        }
        String keyword = setuReqParams.getKeyword();
        Integer num = setuReqParams.getNum();
        String proxy = setuReqParams.getProxy();
        Integer r18 = setuReqParams.getR18();
        Map<String,Object> map = new HashMap<>();
        map.put("apikey",apikey);

        if (!StringUtils.isEmpty(keyword)){
            url.append("&keyword={keyword}");
            map.put("keyword",keyword);
        }
        if (!(num == 0)){
            url.append("&num={num}");
            map.put("num",num);
        }
        if (r18 == 1){
            url.append("&r18={r18}");
            map.put("r18",1);
        }else {
            map.put("r18",0);
        }


        ResponseEntity<JSONObject> exchange = restTemplate.getForEntity(url.toString(),JSONObject.class,map);

        JSONObject body = exchange.getBody();
        System.out.println(body);
        if (body!=null && body.getInteger("code")==0){
            return getInfoByJSONObject(body);
        }
        return null;
    }

    private List<SetuVO> getInfoByJSONObject(JSONObject body) {
        JSONArray data = body.getJSONArray("data");
        List<SetuVO> list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            JSONObject jsonObject = data.getJSONObject(i);
            SetuVO setuVO = jsonObject.toJavaObject(SetuVO.class);
            System.out.println(setuVO);
            list.add(setuVO);
        }
        return list;
    }
}
