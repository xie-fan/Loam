package org.loam.auth.service;

import org.loam.auth.entity.vo.LoginBody;
import org.loam.auth.entity.vo.LoginResponse;
import org.loam.auth.entity.vo.RegisterBody;
import org.loam.auth.entity.vo.RegisterResponse;

public interface LoginService {
    LoginResponse login(LoginBody loginBody);

    RegisterResponse register(RegisterBody registerBody);
}
