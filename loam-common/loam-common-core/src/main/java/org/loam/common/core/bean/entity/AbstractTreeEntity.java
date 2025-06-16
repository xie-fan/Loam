package org.loam.common.core.bean.entity;

import java.util.List;

public class AbstractTreeEntity<T> extends AbstractBeanEntity<T>{


    protected List<T> children;

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

}
