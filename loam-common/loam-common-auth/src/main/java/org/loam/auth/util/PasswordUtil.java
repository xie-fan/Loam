package org.loam.auth.util;

import org.apache.commons.lang3.StringUtils;

public class PasswordUtil {

    public static boolean validPassword(String inputPassword, String password){
        return StringUtils.equals(signPassword(inputPassword), password);
    }

    public static String signPassword(String password){
        return password;
    }
}
