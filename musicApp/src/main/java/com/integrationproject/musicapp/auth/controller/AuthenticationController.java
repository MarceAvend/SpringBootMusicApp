package com.integrationproject.musicapp.auth.controller;

import com.integrationproject.musicapp.appuser.model.AppUser;
import com.integrationproject.musicapp.appuser.service.interfaces.AppUserService;
import com.integrationproject.musicapp.auth.dto.LoginDto;
import com.integrationproject.musicapp.auth.dto.TokenDto;
import com.integrationproject.musicapp.auth.security.jwt.OperationJwt;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final OperationJwt operationJwt;
    private final AppUserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    public AuthenticationController(OperationJwt operationJwt, AppUserService userService) {
        this.operationJwt = operationJwt;
        this.userService = userService;
    }

    @Operation(summary = "Jwt generation to obtain the Token")
    @PostMapping
    public ResponseEntity<TokenDto> generateJwt(@RequestBody LoginDto loginDto) {
        AppUser userFound = userService.findUserByName(loginDto.getEmail());
        if (userFound != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
            TokenDto tokenDto = operationJwt.generateTokenDto(userFound);
            return new ResponseEntity<>(tokenDto, HttpStatus.OK);
        }
        return new ResponseEntity("Entry denied, due to incorrect credentials.", HttpStatus.NOT_FOUND);
    }


}
