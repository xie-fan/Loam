package database.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.loam.common.core.bean.entity.BaseEntity;

public interface MybatisBaseMapper<T extends BaseEntity<ID>, ID> extends BaseDao<T, ID>, BaseMapper<T> {



}
