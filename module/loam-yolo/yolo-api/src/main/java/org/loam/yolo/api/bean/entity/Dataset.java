package org.loam.yolo.api.bean.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.loam.common.core.bean.entity.AbstractBeanEntity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.lang.annotation.Documented;
import java.util.List;

@Document("dataset")
@EqualsAndHashCode(callSuper = true)
@Data
public class Dataset extends AbstractBeanEntity<ObjectId> {

    private List<Image> images;

    private String name;

}
