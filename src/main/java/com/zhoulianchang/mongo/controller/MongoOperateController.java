package com.zhoulianchang.mongo.controller;

import com.zhoulianchang.mongo.entity.mongo.User;
import com.zhoulianchang.mongo.entity.response.Result;
import com.zhoulianchang.mongo.service.MongoOperateService;
import com.zhoulianchang.mongo.utils.ResultUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZLC
 * @date 2019-06-05 16:01
 **/
@RestController
@RequestMapping("/v1")
public class MongoOperateController {
    private final MongoOperateService mongoOperateService;

    @Autowired
    public MongoOperateController(MongoOperateService mongoOperateService) {
        this.mongoOperateService = mongoOperateService;
    }

    @GetMapping("/user")
    public Result findAll() {
        return mongoOperateService.findAll();
    }

    @GetMapping("/user/page")
    public Result findAllByPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize) {
        return mongoOperateService.findAll(PageRequest.of(pageNum, pageSize));
    }

    @GetMapping("/user/page/sort")
    public Result findAllByPageAndSort(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize) {
        return mongoOperateService.findAll(PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "info.age"));
    }

    @GetMapping("/user/exist/{id}")
    public Result judgeIsExist(@PathVariable String id) {
        // 对id进行校验防止无效id
        boolean valid = ObjectId.isValid(id);
        if(valid){
            return mongoOperateService.judgeIsExist(id);
        } else {
            return ResultUtils.badRequest("输入的id是无效的16进制,[" + id + "]");
        }
    }
    @PostMapping("/user")
    public Result save(@RequestBody User user) {
        return mongoOperateService.save(user);
    }

    @PutMapping("/user/{id}")
    public Result update(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        return mongoOperateService.update(user);
    }

    @DeleteMapping("/user/{id}")
    public Result delete(@PathVariable String id) {
        return mongoOperateService.delete(id);
    }
}
