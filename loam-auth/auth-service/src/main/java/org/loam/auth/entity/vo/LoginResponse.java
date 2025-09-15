package org.loam.auth.entity.vo;

import org.loam.auth.util.TokenUtil;
import org.loam.system.bean.entity.User;

public class LoginResponse {

    private User user;

    private String token;

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public static LoginResponse of(User user){
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.user = user;
        loginResponse.token = TokenUtil.createToken(user.getName(), user.getPassword());
        return loginResponse;
    }
}
