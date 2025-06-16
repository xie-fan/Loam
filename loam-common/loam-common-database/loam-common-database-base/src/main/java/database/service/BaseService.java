package database.service;

import database.dao.BaseDao;
import org.loam.common.core.bean.entity.BaseEntity;

public interface BaseService<M extends BaseDao<T, ID>, T extends BaseEntity<ID>, ID>{
}
