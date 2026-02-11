package org.loam.mongo.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class MongoQueryBuilder {

    public static Pageable builder(int pageNum, int pageSize){
        return PageRequest.of(pageNum,pageSize, Sort.by(Sort.Direction.DESC,"createTime"));
    }
}
