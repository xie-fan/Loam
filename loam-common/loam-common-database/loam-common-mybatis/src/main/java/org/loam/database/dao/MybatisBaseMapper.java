package org.loam.database.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface MybatisBaseMapper<T extends BaseEntity<ID>, ID> extends BaseDao<T, ID>, BaseMapper<T> {



}
