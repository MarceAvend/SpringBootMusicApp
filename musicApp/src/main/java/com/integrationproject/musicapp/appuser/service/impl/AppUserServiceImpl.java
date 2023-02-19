package com.integrationproject.musicapp.appuser.service.impl;

import com.integrationproject.musicapp.appuser.dto.AppUserDTO;
import com.integrationproject.musicapp.appuser.model.AppUser;
import com.integrationproject.musicapp.appuser.repository.IAppUserRepositoryDao;
import com.integrationproject.musicapp.appuser.service.interfaces.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    private IAppUserRepositoryDao appUserRepositoryDao;

    @Override
    public List<AppUser> findAll() {
        return this.appUserRepositoryDao.findAll();
    }

    @Override
    public AppUser findById(Long idUser) {
        return this.appUserRepositoryDao.findById(idUser);
    }

    @Override
    public AppUser findUserByName(String email) {
        return this.appUserRepositoryDao.findAppUserByName(email);
    }

    @Override
    @Transactional
    public AppUser createAppUser(AppUserDTO appUserDTO) {
        return this.appUserRepositoryDao.createAppUser(appUserDTO);
    }

    @Override
    @Transactional
    public AppUser updateAppUser(AppUserDTO appUserDTO) {
        return this.appUserRepositoryDao.updateAppUser(appUserDTO.getId(), appUserDTO);
    }

    @Override
    @Transactional
    public Boolean deleteAppUser(Long idAppUser) {
        return this.appUserRepositoryDao.deleteAppUserById(idAppUser);
    }

    @Autowired
    public AppUserServiceImpl(IAppUserRepositoryDao appUserRepositoryDao) {
        this.appUserRepositoryDao = appUserRepositoryDao;
    }

}
