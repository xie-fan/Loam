package org.loam.system.bean.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.loam.common.core.bean.entity.AbstractTreeEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class Menu extends AbstractTreeEntity<Long> {

    private String name;

    private Integer type;

    private Integer status;

    private Integer disable;

    private Integer orderNum;

}
