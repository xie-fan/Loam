package org.loam.yolo.api.bean.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.loam.common.core.bean.entity.AbstractBeanEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("trainRecord")
@EqualsAndHashCode(callSuper = true)
@Data
public class TrainRecord extends AbstractBeanEntity<ObjectId> {

    private ObjectId datasetId;
}
