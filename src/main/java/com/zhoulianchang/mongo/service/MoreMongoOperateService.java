package com.zhoulianchang.mongo.service;

import com.zhoulianchang.mongo.entity.response.Result;

/**
 * @author ZLC
 * @date 2019-06-05 17:52
 **/
public interface MoreMongoOperateService {
    /**
     * 根据姓名进行查找
     *
     * @param name 要查找的姓名
     * @return 返回的结果集
     */
    Result findByName(String name);
}
