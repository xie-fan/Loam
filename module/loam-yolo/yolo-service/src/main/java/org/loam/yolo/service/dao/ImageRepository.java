package org.loam.yolo.service.dao;

import org.bson.types.ObjectId;
import org.loam.yolo.api.bean.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, ObjectId> {

}
