package org.loam.mongo.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class MongoQueryBuilder {

    public static Pageable builder(int pageNum, int pageSize){
        int safePageNum = Math.max(pageNum - 1, 0);
        int safePageSize = pageSize <= 0 ? 10 : pageSize;
        return PageRequest.of(safePageNum, safePageSize, Sort.by(Sort.Direction.DESC,"createTime"));
    }
}
