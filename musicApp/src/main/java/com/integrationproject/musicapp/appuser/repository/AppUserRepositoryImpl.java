package com.integrationproject.musicapp.appuser.repository;


import com.integrationproject.musicapp.appuser.dto.AppUserDTO;
import com.integrationproject.musicapp.appuser.model.AppUser;
import com.integrationproject.musicapp.appuser.repository.dataBaseRepository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class AppUserRepositoryImpl implements IAppUserRepositoryDao{

    private final IAppUserRepository appUserRepository;


    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser findById(Long id) {
        Optional<AppUser> userByIdFound = appUserRepository.findById(id);
        if (userByIdFound.isPresent()) {
            return userByIdFound.get();
        }
        return null;
    }

    @Override
    public AppUser findAppUserByName(String email) {
        Optional<AppUser> userByEmailFound = appUserRepository.findUserByName(email);
        if (userByEmailFound.isPresent()) {
            return userByEmailFound.get();
        }
        return null;
    }

    @Override
    public AppUser createAppUser(AppUserDTO appUserDTO) {
        AppUser appUser = new AppUser(appUserDTO);
        return appUserRepository.save(appUser);
    }


    @Override
    public AppUser updateAppUser(Long id, AppUserDTO appUserDTO) {
        AppUser appUserFound = findById(id);
        if (appUserFound != null) {
            appUserFound.updateAppUserFromDTO(appUserDTO);
            return appUserRepository.save(appUserFound);
        }
        return null;
    }

    @Override
    public Boolean deleteAppUserById(Long id) {
        AppUser appUserFound = findById(id);
        if (appUserRepository.existsById(id)) {
            appUserRepository.delete(appUserFound);
            return true;
        }
        return false;
    }

    @Autowired
    public AppUserRepositoryImpl(IAppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
}
