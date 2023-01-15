package com.integrationproject.musicapp.appuser.service.interfaces;

import com.integrationproject.musicapp.appuser.dto.AppUserDTO;
import com.integrationproject.musicapp.appuser.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppUserService {

    List<AppUser> findAll();

    AppUser findById(Long idUser);

    AppUser findUserByName(String email);

    AppUser createAppUser(AppUserDTO appUserDTO);

    AppUser updateAppUser(AppUserDTO appUserDTO);

    void deleteAppUser(AppUser appUser);

}
