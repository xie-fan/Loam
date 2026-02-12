package org.loam.auth.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    public static boolean validPassword(String inputPassword, String password) {
        if (StringUtils.isBlank(inputPassword) || StringUtils.isBlank(password)) {
            return false;
        }
        // 向后兼容历史明文密码，便于平滑迁移。
        if (!StringUtils.startsWith(password, "$2")) {
            return StringUtils.equals(inputPassword, password);
        }
        return ENCODER.matches(inputPassword, password);
    }

    public static String signPassword(String password) {
        if (StringUtils.isBlank(password)) {
            throw new IllegalArgumentException("密码不能为空");
        }
        return ENCODER.encode(password);
    }
}
