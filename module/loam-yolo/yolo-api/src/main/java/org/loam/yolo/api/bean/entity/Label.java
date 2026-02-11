package org.loam.yolo.api.bean.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.loam.common.core.bean.entity.AbstractBeanEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class Label{

    private Long type;

}
