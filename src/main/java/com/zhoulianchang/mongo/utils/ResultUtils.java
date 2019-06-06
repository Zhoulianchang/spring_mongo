package com.zhoulianchang.mongo.utils;

import com.zhoulianchang.mongo.entity.response.Result;

/**
 * @author ZLC
 * @date 2019-06-05 16:28
 **/
public class ResultUtils {
    /**
     * 用于处理成功结果
     * @param data 要返回的数据
     * @param <T> 泛型
     * @return 返回结果集
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setCode(200);
        result.setMsg("success...");
        result.setData(data);
        return result;
    }

    /**
     * 用于处理成功结果
     * @param <T> 泛型
     * @return 返回结果集
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("success...");
        result.setData(null);
        return result;
    }

    /**
     * 用于处理失败结果
     * @param <T> 泛型
     * @return 返回结果集
     */
    public static <T> Result<T> failed(String message) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMsg(message);
        result.setData(null);
        return result;
    }

    /**
     * 用于处理失败结果
     * @param <T> 泛型
     * @return 返回结果集
     */
    public static <T> Result<T> badRequest(String message) {
        Result<T> result = new Result<>();
        result.setCode(400);
        result.setMsg(message);
        result.setData(null);
        return result;
    }
}
