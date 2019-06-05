package com.zhoulianchang.mongo.repository;

import com.zhoulianchang.mongo.entity.mongo.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZLC
 * @date 2019-06-05 16:07
 **/
@Repository
public interface MongoOperateRepository extends MongoRepository<User, ObjectId> {
    /**
     * 根据姓名查找
     * @param name 要查找的姓名
     * @return 返回User对象集合(考虑重名的情况)
     */
    List<User> findByName(String name);
}
