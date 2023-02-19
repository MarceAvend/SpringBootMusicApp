package com.integrationproject.musicapp.auth.service;

import com.integrationproject.musicapp.appuser.model.AppUser;
import com.integrationproject.musicapp.appuser.repository.dataBaseRepository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailServiceAuth implements UserDetailsService {

    private final IAppUserRepository appUserRepository;

    @Autowired
    public UserDetailServiceAuth(IAppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser userFound = appUserRepository.findByName(email);
        return new org.springframework.security.core.userdetails.User(
                userFound.getName(), "{noop}" + userFound.getPassword(), new ArrayList<>()
        );
    }
}
