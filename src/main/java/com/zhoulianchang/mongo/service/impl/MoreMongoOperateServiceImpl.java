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

    @Override
    public Result test(String roomId, String localActor) {
        localActor = "[" + localActor + "]";
        Criteria cri = Criteria.where("info.ConfAttr.room_id").is(roomId).and("info.ConfQos.localActor").is(localActor);
        List<Test> tests = mongoTemplate.find(Query.query(cri), Test.class);
        return ResultUtils.success(tests);
    }

    @Override
    public void download(HttpServletResponse response) {
        try {
            ZipOutputStream zip = new ZipOutputStream(response.getOutputStream());
            File file1 = new File("/home/docker/minio/data/test/24C2474E-D18B-4C66-8295-F65CECE9823E.jpeg");
            File file2 = new File("/home/docker/minio/data/myself/American_id.png");
            System.out.println("file1 exists :" + file1.exists());
            System.out.println("file2 exists :" + file2.exists());
            List<File> list = new ArrayList<>();
            list.add(file1);
            list.add(file2);
            BatchDownloadFile.setResponseHeader(System.currentTimeMillis() + ".zip", response);
            BatchDownloadFile.batchDownload(zip, list);
            zip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
