package com.integrationproject.musicapp.appuser.service;

import com.integrationproject.musicapp.appuser.dto.AppUserDTO;
import com.integrationproject.musicapp.appuser.model.AppUser;
import com.integrationproject.musicapp.appuser.repository.IAppUserRepositoryDao;
import com.integrationproject.musicapp.appuser.service.impl.AppUserServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppUserServiceImplTest {

    @Mock
    private IAppUserRepositoryDao appUserRepositoryDao;

    @InjectMocks
    private AppUserServiceImpl appUserService;


    @Test
    @Order(1)
    public void find_all_appUsers() {
        Date timeCreatedAndEdited = new Date();
        List<AppUser> appUserListMockito = new ArrayList<>();
        List<AppUser> appUserListExpected = new ArrayList<>();

        appUserListMockito.add(new AppUser("marcelaTes1Usr1", "pasword1", timeCreatedAndEdited, null, false));
        appUserListMockito.add(new AppUser("marcelaTes1Usr2", "pasword2", timeCreatedAndEdited, null, false));

        Mockito.when(appUserRepositoryDao.findAll()).thenReturn(appUserListMockito);
        List<AppUser> appUserListResultListResult = appUserService.findAll();

        appUserListExpected.add(new AppUser("marcelaTes1Usr1", "pasword1", timeCreatedAndEdited, null, false));
        appUserListExpected.add(new AppUser("marcelaTes1Usr2", "pasword2", timeCreatedAndEdited, null, false));
        Assertions.assertEquals(appUserListExpected, appUserListResultListResult);
    }

    @Test
    @Order(2)
    public void find_appUser_by_id() {
        Date timeCreatedAndEdited = new Date();
        AppUser appUserMockito = new AppUser("marcelaTes2Usr1", "pasword1", timeCreatedAndEdited, null, false);

        Mockito.when(appUserRepositoryDao.findById(1L)).thenReturn(appUserMockito);
        AppUser userResult = appUserService.findById(1L);

        AppUser userExpected = new AppUser("marcelaTes2Usr1", "pasword1", timeCreatedAndEdited, null, false);
        Assertions.assertEquals(userExpected, userResult);
    }

    @Test
    @Order(3)
    public void create_appUser() throws ParseException {
        AppUserDTO appUserDTOMockito = new AppUserDTO("marcelaTes2Usr1", "pasword1","31/12/2022");
        AppUser appUserMockito = new AppUser(appUserDTOMockito);

        Mockito.lenient().when(appUserRepositoryDao.createAppUser(appUserDTOMockito)).thenReturn(appUserMockito);
        AppUser userResult = appUserService.createAppUser(appUserDTOMockito);

        AppUser userExpected = new AppUser(appUserDTOMockito);
        Assertions.assertEquals(userExpected, userResult);
    }

    @Test
    @Order(4)
    public void update_appUser_by_id() throws ParseException {
        AppUserDTO appUserDTOMockito = new AppUserDTO(1L,"marcelaTes2Usr1", "pasword1","31/12/2022");
        AppUser appUserMockito = new AppUser(appUserDTOMockito);

        Mockito.lenient().when(appUserRepositoryDao.updateAppUser(1L, appUserDTOMockito)).thenReturn(appUserMockito);

        AppUser userResult = appUserService.updateAppUser(appUserDTOMockito);
        Assertions.assertEquals(appUserMockito, userResult);
    }

    @Test
    @Order(5)
    public void delete_user_by_id() {
        Mockito.when(appUserRepositoryDao.deleteAppUserById(1L)).thenReturn(true);
        Boolean userResult = appUserService.deleteAppUser(1L);
        Assertions.assertEquals(true, userResult);
    }

}
