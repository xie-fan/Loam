package org.loam.system.bean.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.loam.common.core.bean.entity.AbstractBeanEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends AbstractBeanEntity<Long> {
    private String name;

    private String roleKey;

    private Integer status;

    private Integer orderNum;

}
