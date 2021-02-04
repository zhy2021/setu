package com.setu.demo.modules.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/01/29 17:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetuVO implements Serializable {

    private Integer pid;
    private Integer p;
    private Integer uid;
    private String title;
    private String author;
    private String url;
    private Boolean r18;
    private Integer width;
    private Integer height;
    private String[] tags;
}
