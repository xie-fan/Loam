package org.loam.auth.util;

public class TokenUtil {

    public static String createToken(String username, String password){
        return username + ":"  + password;
    }
    
}
