package com.setu.demo.modules.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/01/29 16:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetuReqParams implements Serializable {
    private String apikey;

    /**0为非 R18，1为 R18，2为混合*/
    private Integer r18;

    private String keyword;
    /**一次返回的结果数量，范围为1到10，不提供 APIKEY 时固定为1；在指定关键字的情况下，结果数量可能会不足指定的数量*/
    private Integer num;
    /**设置返回的原图链接的域名，你也可以设置为disable来得到真正的原图链接[1]*/
    private String proxy;

    /**是否使用 master_1200 缩略图，即长或宽最大为 1200px 的缩略图，以节省流量或提升加载速度（某些原图的大小可以达到十几MB）*/
    private boolean size1200;
}
