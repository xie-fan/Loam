package org.loam.yolo.api.bean.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.loam.common.core.bean.entity.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class LabelType extends BaseEntity<Long> {
    private String name;

}
