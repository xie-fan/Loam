package org.loam.database.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.loam.database.dao.MybatisBaseMapper;
import org.loam.common.core.bean.entity.BaseEntity;

public class MybatisServiceImpl<M extends MybatisBaseMapper<T, ID>, T extends BaseEntity<ID>, ID> extends ServiceImpl<M, T> implements MybatisBaseService<T, ID> {



}
