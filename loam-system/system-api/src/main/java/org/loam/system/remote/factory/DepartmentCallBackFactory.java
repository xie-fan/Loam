package org.loam.system.remote.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.auth.constants.RemoteErrorConstants;
import org.loam.system.bean.entity.Department;
import org.loam.system.remote.service.DepartmentRemoteService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentCallBackFactory implements FallbackFactory<DepartmentRemoteService> {

    private static final Logger log = LogManager.getLogger(DepartmentCallBackFactory.class);

    @Override
    public DepartmentRemoteService create(Throwable cause) {
        log.error(RemoteErrorConstants.ERROR_MESSAGE, "system-service:/system/department", cause);

        return new DepartmentRemoteService(){

            @Override
            public DataSet<Department> getDepartment(Long id) {
                return DataSet.error(null, "查询部门失败");
            }

            @Override
            public DataSet<List<Department>> getList(Department department) {
                return DataSet.error(null, "查询部门失败");
            }

            @Override
            public DataSet<List<Department>> getListByPage(Department department, int pageNum, int pageSize) {
                return DataSet.error(null, "查询部门失败");
            }

            @Override
            public DataSet<Department> insertDepartment(Department department) {
                return DataSet.error(null, "新增部门失败");
            }

            @Override
            public DataSet<Department> updateDepartment(Department department) {
                return DataSet.error(null, "更新部门失败");
            }

            @Override
            public Message deleteDepartment(Long id) {
                return Message.error("删除部门失败");
            }
        };
    }
}
