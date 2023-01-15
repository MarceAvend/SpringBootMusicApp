package com.integrationproject.musicapp.appuser.controller;

import com.integrationproject.musicapp.appuser.dto.AppUserDTO;
import com.integrationproject.musicapp.appuser.model.AppUser;
import com.integrationproject.musicapp.appuser.service.interfaces.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private AppUserService appUserService;

    @GetMapping("/all")
    public ResponseEntity<List<AppUser>> findAll(){
        List<AppUser> appUserList = this.appUserService.findAll();
        if (appUserList == null || appUserList.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        System.out.println("ESTA A PUNTO DE RESPOINDER");
        return new ResponseEntity<>(appUserList, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<AppUser> findTipoLiquidadorNominaPorPersona(
            @RequestParam(name = "id")Long idUser
    ){
        AppUser appUser = appUserService.findById(idUser);
        if (appUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AppUser> createAppUser(
            @Valid @RequestBody AppUserDTO appUserDTO
    ) {
        AppUser appUser = this.appUserService.createAppUser(appUserDTO);
        return new ResponseEntity<>(appUser,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AppUser> updateAppUser(
            @Valid @RequestBody AppUserDTO appUserDTO
    ) {
        AppUser appUser = this.appUserService.updateAppUser(appUserDTO);
        if (appUser == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(appUser,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAppUser(
            @PathVariable(value = "id", required = true) Long aId
    ) {
        AppUser appUserBD = this.appUserService.findById(aId);
        if (appUserBD == null) {
            return new ResponseEntity<>(false,HttpStatus.NO_CONTENT);
        }
        this.appUserService.deleteAppUser(appUserBD);
        return new ResponseEntity<>(true,HttpStatus.OK);

    }

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
}