package com.integrationproject.musicapp.service.interfaces;

import com.integrationproject.musicapp.dto.AppUserDTO;
import com.integrationproject.musicapp.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppUserService {

    List<AppUser> findAll();

    AppUser findById(Long idUser);

    AppUser createAppUser(AppUserDTO appUserDTO);

    AppUser updateAppUser(AppUserDTO appUserDTO);

    void deleteAppUser(AppUser appUser);

}
