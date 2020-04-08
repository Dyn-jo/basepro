package com.dyn.basepro.frame.response;

import lombok.Data;

import java.util.List;

/**
 *@description:分页数据封装类
 *@author: dyn
 *@create: 2020-03-15 20:23
 */
@Data
public class CommonPage<T> {

    private long current;

    private long total;

    private long size;

    private long pages;

    private List<T> records;

}
