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

    /**
     * 根据姓名和年龄一起查询
     * @param name 姓名
     * @param age 年龄
     * @return 返回的结果集
     */
    Result findByNameAndAge(String name, Integer age);

    /**
     * 根据姓名进行删除
     * @param name 要删除的姓名
     * @return 返回的结果集
     */
    Result deleteByName(String name);
}
