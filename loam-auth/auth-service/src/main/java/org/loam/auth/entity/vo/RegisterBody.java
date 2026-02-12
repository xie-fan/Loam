package org.loam.auth.entity.vo;

import jakarta.validation.constraints.NotNull;
import org.loam.system.bean.entity.User;

public class RegisterBody {

    private String token;

    @NotNull(message = "用户信息不能为空")
    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
