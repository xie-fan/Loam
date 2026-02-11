package org.loam.common.core.bean.entity;

import java.time.LocalDateTime;

public abstract class AbstractBeanEntity<T> extends BaseEntity<T>{
    protected int delFlag = 0;

    protected String creator;

    protected LocalDateTime createTime;

    protected String updated_by;

    protected LocalDateTime lastModifyTime;

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getLastModifier() {
        return updated_by;
    }

    public void setLastModifier(String updated_by) {
        this.updated_by = updated_by;
    }

    public LocalDateTime getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(LocalDateTime lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
