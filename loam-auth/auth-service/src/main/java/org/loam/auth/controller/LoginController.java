package org.loam.auth.controller;

import jakarta.validation.Valid;
import jakarta.annotation.Resource;
import org.loam.auth.entity.vo.LoginBody;
import org.loam.auth.entity.vo.LoginResponse;
import org.loam.auth.entity.vo.RegisterBody;
import org.loam.auth.entity.vo.RegisterResponse;
import org.loam.auth.service.LoginService;
import org.loam.common.core.bean.vo.DataSet;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public DataSet<LoginResponse> login(@Valid @RequestBody LoginBody loginBody) {
        LoginResponse loginResponse = loginService.login(loginBody);
        return DataSet.success(loginResponse);
    }

    @PostMapping("/register")
    public DataSet<RegisterResponse> register(@Valid @RequestBody RegisterBody registerBody) {
        RegisterResponse registerResponse = loginService.register(registerBody);
        return DataSet.success(registerResponse);
    }

}
