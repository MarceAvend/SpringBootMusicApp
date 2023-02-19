package com.integrationproject.musicapp.appuser.repository;

import com.integrationproject.musicapp.appuser.dto.AppUserDTO;
import com.integrationproject.musicapp.appuser.model.AppUser;

import java.util.List;

public interface IAppUserRepositoryDao {


    List<AppUser> findAll();

    AppUser findById(Long idUser);

    AppUser findAppUserByName(String email);

    AppUser createAppUser(AppUserDTO appUserDTO);

    AppUser updateAppUser(Long idAppUser, AppUserDTO appUserDTO);

    Boolean deleteAppUserById(Long idAppUser);
}
