package com.atqgh.common.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.ObjectUtils;

/**
 * JWT工具类.
 * @author Mubai
 * @date 2022/7/9 4:24 下午
 **/
public class JwtUtil {

    /**
     * 60 * 60 *1000  一个小时.
     */
    public static final Long JWT_TTL = 60 * 60 * 1000L;

    /**
     * 设置秘钥明文.
     */
    public static final String JWT_KEY = "sangeng";

    /**
     * uuid.
     * @return token
     */
    public static String getUUID() {
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    /**
     * 生成jtw.
     * @param subject token中要存放的数据（json格式）
     * @return jwt
     */
    public static String createJWT(String subject) {
        // 设置过期时间
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());
        return builder.compact();
    }

    /**
     * 生成jtw.
     * @param subject token中要存放的数据（json格式）
     * @param ttlMillis token超时时间
     * @return jwt
     */
    public static String createJWT(String subject, Long ttlMillis) {
        // 设置过期时间
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }

    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {

        Long ttl = ttlMillis;
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (ObjectUtils.isEmpty(ttl)) {
            ttl = JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttl;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                //唯一的ID
                .setId(uuid)
                // 主题  可以是JSON数据
                .setSubject(subject)
                // 签发者
                .setIssuer("sg")
                // 签发时间
                .setIssuedAt(now)
                //使用HS256对称加密算法签名, 第二个参数为秘钥
                .signWith(signatureAlgorithm, secretKey)
                .setExpiration(expDate);
    }

    /**
     * 创建token.
     * @param id id
     * @param subject subject
     * @param ttlMillis 过期时间
     * @return 结果
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        // 设置过期时间
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);
        return builder.compact();
    }

    /**
     * 生成加密后的秘钥 secretKey.
     * @return 密钥
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 解析.
     *
     * @param jwt jwt
     * @return 结果
     * @throws Exception 异常
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
