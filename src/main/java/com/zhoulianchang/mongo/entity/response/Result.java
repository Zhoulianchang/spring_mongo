package com.zhoulianchang.mongo.entity.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZLC
 * @date 2019-06-05 16:04
 **/
@Data
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
}
