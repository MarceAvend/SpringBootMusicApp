package com.integrationproject.musicapp.appuser.service.impl;

import com.integrationproject.musicapp.appuser.service.interfaces.AppUserService;
import com.integrationproject.musicapp.appuser.dto.AppUserDTO;
import com.integrationproject.musicapp.appuser.model.AppUser;
import com.integrationproject.musicapp.appuser.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    private IAppUserRepository appUserRepository;
    @Override
    public List<AppUser> findAll() {
        return this.appUserRepository.findAll();
    }

    @Override
    public AppUser findById(Long idUser) {
        Optional<AppUser> appUser = this.appUserRepository.findById(idUser);
        if (appUser.isPresent()) {
            return appUser.get();
        }
        return null;
    }

    @Override
    public AppUser findUserByName(String email) {
        return this.appUserRepository.findByName(email);
    }

    @Override
    @Transactional
    public AppUser createAppUser(AppUserDTO appUserDTO) {
        AppUser newAppUser = new AppUser();
        newAppUser.setName(appUserDTO.getName());
        newAppUser.setPassword(appUserDTO.getPassword());
        newAppUser.setCreateDate(new Date());
        if (appUserDTO.getIsAdmin() != null) {
            newAppUser.setIsAdmin(appUserDTO.getIsAdmin());

        } else{ newAppUser.setIsAdmin(false); }

        return this.appUserRepository.save(newAppUser);
    }

    @Override
    @Transactional
    public AppUser updateAppUser(AppUserDTO appUserDTO) {
        Optional<AppUser> appUserBD = this.appUserRepository.findById(appUserDTO.getId());
        if (appUserBD.isPresent()) {
            AppUser upadteAppUserBD = appUserBD.get();
            upadteAppUserBD.setName(appUserDTO.getName());
            upadteAppUserBD.setPassword(appUserDTO.getPassword());
            upadteAppUserBD.setEditDate(new Date());
            if (appUserDTO.getIsAdmin() != null) {
                upadteAppUserBD.setIsAdmin(appUserDTO.getIsAdmin());
            }
            return this.appUserRepository.save(upadteAppUserBD);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteAppUser(AppUser appUser) {
        this.appUserRepository.deleteById(appUser.getId());
    }


    @Autowired
    public AppUserServiceImpl(IAppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
}
