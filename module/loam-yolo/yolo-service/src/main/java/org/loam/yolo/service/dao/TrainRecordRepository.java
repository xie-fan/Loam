package org.loam.yolo.service.dao;

import org.bson.types.ObjectId;
import org.loam.yolo.api.bean.entity.TrainRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainRecordRepository extends MongoRepository<TrainRecord, ObjectId> {

}
