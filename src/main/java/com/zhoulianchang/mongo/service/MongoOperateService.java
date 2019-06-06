package com.zhoulianchang.mongo.service;

import com.zhoulianchang.mongo.entity.mongo.User;
import com.zhoulianchang.mongo.entity.response.Result;
import org.springframework.data.domain.Pageable;

/**
 * @author ZLC
 * @date 2019-06-05 16:02
 **/
public interface MongoOperateService {
    /**
     * 查询所有数据 (不分页)
     * 该方法是MongoRepository已经实现的无需再写
     *
     * @return 返回的结果集
     */
    Result findAll();

    /**
     * 查询所有数据 (分页)
     * 该方法是MongoRepository已经实现的无需再写
     *
     * @param pageable 分页对象
     * @return 返回的结果集
     */
    Result findAll(Pageable pageable);

    /**
     * 插入用户记录
     *
     * @param user 要插入的用户对象
     * @return 返回的结果集
     */
    Result save(User user);

    /**
     * 修改用户信息
     * @param user 要修改的用户对象
     * @return 返回的结果集
     */
    Result update(User user);

    /**
     * 删除用户记录
     *
     * @param id 要删除的用户id
     * @return 返回的结果集
     */
    Result delete(String id);

    /**
     * 判断该用户是否存在
     * @param id 用户id
     * @return
     */
    Result judgeIsExist(String id);
}
