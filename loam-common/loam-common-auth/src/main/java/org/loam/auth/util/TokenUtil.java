package org.loam.auth.util;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Base64;

public class TokenUtil {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String createToken(String account, String userId) {
        long timestamp = Instant.now().toEpochMilli();
        String nonce = Long.toHexString(SECURE_RANDOM.nextLong());
        String payload = account + ":" + userId + ":" + timestamp + ":" + nonce;
        return Base64.getUrlEncoder().withoutPadding().encodeToString(payload.getBytes(StandardCharsets.UTF_8));
    }
}
