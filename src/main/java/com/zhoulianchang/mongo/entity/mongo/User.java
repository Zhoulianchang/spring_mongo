package com.zhoulianchang.mongo.entity.mongo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @author ZLC
 * @date 2019-06-05 16:18
 **/
@Data
@NoArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String card;
    private String name;
    private InfoBean info;
    private List<Course> course;

    @Data
    private class InfoBean {
        private Integer age;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date birth;
        private Integer sex;
    }
}
