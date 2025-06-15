package org.loam.common.core.bean.entity;

import java.util.List;

public class BaseTreeEntity<T> extends BaseEntity<T> {

    protected List<T> children;

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
