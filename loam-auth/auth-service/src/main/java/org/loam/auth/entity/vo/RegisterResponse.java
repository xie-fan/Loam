package org.loam.auth.entity.vo;

import org.loam.auth.util.TokenUtil;
import org.loam.system.bean.entity.User;

public class RegisterResponse {

    private User user;

    private String token;

    public static RegisterResponse of(User user) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.user = sanitizeUser(user);
        String account = user == null || user.getAccount() == null ? "" : user.getAccount();
        String userId = user == null || user.getId() == null ? "" : user.getId().toString();
        registerResponse.token = TokenUtil.createToken(account, userId);
        return registerResponse;
    }

    private static User sanitizeUser(User user) {
        if (user == null) {
            return null;
        }
        User safeUser = new User();
        safeUser.setId(user.getId());
        safeUser.setAccount(user.getAccount());
        safeUser.setName(user.getName());
        safeUser.setSex(user.getSex());
        safeUser.setPhone(user.getPhone());
        safeUser.setEmail(user.getEmail());
        safeUser.setDelFlag(user.getDelFlag());
        safeUser.setCreator(user.getCreator());
        safeUser.setCreateTime(user.getCreateTime());
        safeUser.setLastModifier(user.getLastModifier());
        safeUser.setLastModifyTime(user.getLastModifyTime());
        return safeUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
