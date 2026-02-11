package org.loam.yolo.service.dao;


import org.bson.types.ObjectId;
import org.loam.common.core.bean.vo.DataSet;
import org.loam.yolo.api.bean.entity.Dataset;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataSetRepository extends MongoRepository<Dataset, ObjectId> {

}
