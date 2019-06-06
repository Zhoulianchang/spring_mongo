package com.zhoulianchang.mongo.service.impl;

import com.zhoulianchang.mongo.entity.mongo.User;
import com.zhoulianchang.mongo.entity.response.Result;
import com.zhoulianchang.mongo.repository.MongoOperateRepository;
import com.zhoulianchang.mongo.service.MongoOperateService;
import com.zhoulianchang.mongo.utils.ResultUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author ZLC
 * @date 2019-06-05 16:05
 **/
@Service
public class MongoOperateServiceImpl implements MongoOperateService {
    private static Logger logger = LoggerFactory.getLogger(MongoOperateServiceImpl.class);
    private final MongoOperateRepository mongoOperateRepository;

    @Autowired
    public MongoOperateServiceImpl(MongoOperateRepository mongoOperateRepository) {
        this.mongoOperateRepository = mongoOperateRepository;
    }

    @Override
    public Result findAll() {
        // 查询所有用户信息(不分页)
        List<User> userList = mongoOperateRepository.findAll();
        return ResultUtils.success(userList);
    }

    @Override
    public Result findAll(Pageable pageable) {
        // 查询所有用户信息(分页)
        Page<User> userPage = mongoOperateRepository.findAll(pageable);
        return ResultUtils.success(userPage);
    }

    @Override
    public Result save(User user) {
        if(StringUtils.isEmpty(user.getId())){
            return ResultUtils.badRequest("不能指定用户id");
        }
        // 插入用户信息 (如果user的id不指定的话)
        User newUser = mongoOperateRepository.save(user);
        return ResultUtils.success(newUser);
    }

    @Override
    public Result update(User user) {
        if(mongoOperateRepository.existsById(new ObjectId(user.getId()))){
            // 修改用户信息(如果user的id指定的话且存在的话就是修改)
            user = mongoOperateRepository.save(user);
            return ResultUtils.success(user);
        } else {
            return ResultUtils.badRequest("该用户id不存在");
        }
    }

    @Override
    public Result delete(String id) {
        User user = new User();
        user.setId(id);
        mongoOperateRepository.delete(user);
        return ResultUtils.success();
    }

    @Override
    public Result judgeIsExist(String id) {
        // 将字符串id 转化成为Mongodb中的ObjectId
        ObjectId objectId = new ObjectId(id);
        boolean bool = mongoOperateRepository.existsById(objectId);
        return ResultUtils.success(bool);
    }
}
