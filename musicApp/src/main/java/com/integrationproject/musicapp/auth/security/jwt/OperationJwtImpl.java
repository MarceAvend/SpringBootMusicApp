package com.integrationproject.musicapp.auth.security.jwt;

import com.integrationproject.musicapp.appuser.model.AppUser;
import com.integrationproject.musicapp.auth.dto.TokenDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.Date;

public class OperationJwtImpl implements OperationJwt {

//    @Value("${KEY_SECRET}")
    private String KEY_SECRET = "KEY_SECRET";

    private final Integer MINUTES_JWT_EXPIRATION = 30;

    @Override
    public String generateJwt(AppUser user, Calendar expirationDate) {

        return Jwts.builder()
                .setSubject(user.getId().toString())
                .claim("name", user.getName())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate.getTime())
                .signWith(SignatureAlgorithm.HS256, KEY_SECRET)
                .compact();
    }

    @Override
    public TokenDto generateTokenDto(AppUser user) {
        Calendar dateExpiration = Calendar.getInstance();
        dateExpiration.add(Calendar.MINUTE, MINUTES_JWT_EXPIRATION);
        String jwt = generateJwt(user, dateExpiration);
        return new TokenDto(jwt, dateExpiration.getTime());
    }

    @Override
    public Boolean validateJwt(String jwt, AppUser user) {
        Boolean isJwtExpired = returnClaims(jwt).getExpiration().before(new Date());
        return user.getId().toString().equals(extractSubject(jwt)) && !isJwtExpired;
    }

    @Override
    public Claims returnClaims(String jwt) {
        return Jwts.parser()
                .setSigningKey(KEY_SECRET)
                .parseClaimsJws(jwt)
                .getBody();
    }

    @Override
    public String extractSubject(String jwt) {
        return returnClaims(jwt).getSubject();
    }
}
