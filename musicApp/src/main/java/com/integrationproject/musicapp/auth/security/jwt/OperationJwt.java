package com.integrationproject.musicapp.auth.security.jwt;

import com.integrationproject.musicapp.appuser.model.AppUser;
import com.integrationproject.musicapp.auth.dto.TokenDto;
import io.jsonwebtoken.Claims;

import java.util.Calendar;

public interface OperationJwt {

    String generateJwt(AppUser user, Calendar expirationDate);
    TokenDto generateTokenDto(AppUser user);
    Boolean validateJwt(String jwt, AppUser user);
    Claims returnClaims(String jwt);
    String extractSubject(String jwt);
}
