package org.loam.web.controller;

import org.loam.common.core.bean.entity.BaseEntity;
import org.loam.database.dao.BaseDao;
import org.loam.database.service.BaseService;

public class BaseController<S extends BaseService<M, T, ID>, M extends BaseDao<T, ID>, T extends BaseEntity<ID>, ID> {
}
