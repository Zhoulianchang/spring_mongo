package com.zhoulianchang.mongo.service.impl;

import com.zhoulianchang.mongo.entity.mongo.Test;
import com.zhoulianchang.mongo.entity.mongo.User;
import com.zhoulianchang.mongo.entity.response.Result;
import com.zhoulianchang.mongo.repository.MongoOperateRepository;
import com.zhoulianchang.mongo.service.MoreMongoOperateService;
import com.zhoulianchang.mongo.utils.BatchDownloadFile;
import com.zhoulianchang.mongo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * @author ZLC
 * @date 2019-06-05 17:52
 **/
@Service
public class MoreMongoOperateServiceImpl implements MoreMongoOperateService {
    private final MongoOperateRepository mongoOperateRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MoreMongoOperateServiceImpl(MongoOperateRepository mongoOperateRepository, MongoTemplate mongoTemplate) {
        this.mongoOperateRepository = mongoOperateRepository;
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Result findByName(String name) {
        List<User> userList = mongoOperateRepository.findByName(name);
        return ResultUtils.success(userList);
    }

    @Override
    public Result findByNameAndAge(String name, Integer age) {
        List<User> userLists = mongoOperateRepository.findByNameAndInfo_Age(name, age);
        return ResultUtils.success(userLists);
    }

    @Override
    public Result deleteByName(String name) {
        if (mongoOperateRepository.existsByName(name)) {
            mongoOperateRepository.deleteByName(name);
            return ResultUtils.success();
        } else {
            return ResultUtils.failed("用户名不存在");
        }
    }
}
