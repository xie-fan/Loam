package org.loam.auth.service.impl;

import org.loam.auth.entity.vo.LoginBody;
import org.loam.auth.entity.vo.LoginResponse;
import org.loam.auth.entity.vo.RegisterBody;
import org.loam.auth.entity.vo.RegisterResponse;
import org.loam.auth.service.LoginService;
import org.loam.auth.util.PasswordUtil;
import org.loam.common.core.bean.vo.DataSet;
import org.loam.auth.constants.UserErrorConstant;
import org.loam.system.bean.entity.User;
import org.loam.system.remote.service.UserRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private UserRemoteService userRemoteService;

    @Autowired
    public LoginServiceImpl(UserRemoteService userRemoteService) {
        this.userRemoteService = userRemoteService;
    }

    @Override
    public LoginResponse login(LoginBody loginBody) {

        DataSet<User> userDataSet = userRemoteService.getUserByAccount(loginBody.getUsername());
        if(userDataSet.isEmpty()){
            throw new RuntimeException(UserErrorConstant.USER_OR_PWD_ERROR);
        }
        User user = userDataSet.getData();
        if(PasswordUtil.validPassword(loginBody.getPassword(), user.getPassword())){
            throw new RuntimeException(UserErrorConstant.USER_OR_PWD_ERROR);
        }

        return LoginResponse.of(user);
    }

    @Override
    public RegisterResponse register(RegisterBody registerBody) {
        return null;
    }
}
