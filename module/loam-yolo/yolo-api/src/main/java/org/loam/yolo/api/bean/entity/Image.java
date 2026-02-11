package org.loam.yolo.api.bean.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.loam.common.core.bean.entity.AbstractBeanEntity;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("image")
@EqualsAndHashCode(callSuper = true)
@Data
public class Image extends AbstractBeanEntity<ObjectId> {

    private String name;

    private String url;

    private List<Label> labels;

}
