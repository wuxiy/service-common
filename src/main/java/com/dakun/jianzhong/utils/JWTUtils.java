package com.dakun.jianzhong.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.spec.KeySpec;
import java.util.Date;

/**
 * Created by wangh09 on Thu Jul 13 14:40:19 GMT+08:00 2017.
 */
public class JWTUtils {
    static private SecretKey key = null;
    static private SecretKey generalKey() {
        if(key != null) return key;
        String secret = "zxjertansdiqaewalsdnf";
            try {
                KeySpec keySpec = new DESKeySpec(secret.getBytes());
                key = SecretKeyFactory.getInstance("DES").generateSecret(keySpec);
            }
            catch(Exception e) {
                System.out.println(e);
        }
        return key;
    }
    /**
     * 创建 jwt
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     * @throws Exception
     */
    static public String createJWT(String id, String subject, long ttlMillis) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512 ;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts. builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0){
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date( expMillis);
            builder.setExpiration( exp);
        }
        return builder.compact();
    }

    /**
     * 解密 jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    static public Claims parseJWT(String jwt) throws Exception{
        SecretKey key = generalKey();
        Claims claims = Jwts.parser()
                .setSigningKey( key)
                .parseClaimsJws( jwt).getBody();
        return claims;
    }
}
