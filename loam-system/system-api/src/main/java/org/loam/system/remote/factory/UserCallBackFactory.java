package org.loam.system.remote.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.auth.constants.RemoteErrorConstants;
import org.loam.system.bean.entity.User;
import org.loam.system.remote.service.UserRemoteService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCallBackFactory implements FallbackFactory<UserRemoteService> {

    private static final Logger log = LogManager.getLogger(UserCallBackFactory.class);

    @Override
    public UserRemoteService create(Throwable cause) {
        log.error(RemoteErrorConstants.ERROR_MESSAGE, "system-service:/system/user", cause);

        return new UserRemoteService(){

            @Override
            public DataSet<User> getUser(Long id) {
                return DataSet.error(null, "查询用户失败");
            }

            @Override
            public DataSet<List<User>> getList(User user) {
                return DataSet.error(null, "查询用户失败");
            }

            @Override
            public DataSet<User> getUserByAccount(String account) {
                return DataSet.error(null, "查询用户失败");
            }

            @Override
            public DataSet<List<User>> getListByPage(User user, int pageNum, int pageSize) {
                return DataSet.error(null, "查询用户失败");
            }

            @Override
            public DataSet<User> insertUser(User user) {
                return DataSet.error(null, "新增用户失败");
            }

            @Override
            public DataSet<User> updateUser(User user) {
                return DataSet.error(null, "更新用户失败");
            }

            @Override
            public Message deleteUser(Long id) {
                return Message.error("删除用户失败");
            }
        };
    }
}
