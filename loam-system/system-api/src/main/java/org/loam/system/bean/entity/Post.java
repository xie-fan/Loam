package org.loam.system.bean.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.loam.common.core.bean.entity.AbstractBeanEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class Post extends AbstractBeanEntity<Long> {

    private String name;

    private String code;

    private String responsibility;

    private Long departId;

}
