package com.example.distance.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    public static final long EXPIRATION_TIME = 3600_000_000L;
    public static  final String SECRET = "erbj4rfb7d8cbirf" ;
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
    public static final String USER_ID = "userName";

    public static String createToken(int userId){
        Map<String,Object> map = new HashMap<>();

        map.put( USER_ID,String.valueOf(userId));

        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return jwt;
    }

    public static Integer getUserId(String jwt) {
        try {
            Map<String, Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(jwt)
                    .getBody();
            String userId = (String) body.get(USER_ID);
            return Integer.valueOf(userId);
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }

    }

}