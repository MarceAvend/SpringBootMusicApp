package com.integrationproject.musicapp.controller;



import com.integrationproject.musicapp.appuser.controller.AppUserController;
import com.integrationproject.musicapp.appuser.dto.AppUserDTO;
import com.integrationproject.musicapp.appuser.model.AppUser;
import com.integrationproject.musicapp.appuser.service.interfaces.AppUserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppUserControllerTest {

    @Mock
    private AppUserService appUserService;

    @InjectMocks
    private AppUserController appUserController;

    @Test
    @Order(1)
    public void find_all_users_200_ok() {

        Date timeCreatedAndEdited = new Date();
        List<AppUser> appUserListMockito = new ArrayList<>();

        appUserListMockito.add(new AppUser("marcelaTes1Usr1", "pasword1", timeCreatedAndEdited, null, false));
        appUserListMockito.add(new AppUser("marcelaTes1Usr2", "pasword2", timeCreatedAndEdited, null, false));

        Mockito.when(appUserService.findAll()).thenReturn(appUserListMockito);

        ResponseEntity<List<AppUser>> listAppUsersResultController = appUserController.findAll();
        Assertions.assertEquals(200, listAppUsersResultController.getStatusCodeValue());
    }

    @Test
    @Order(2)
    public void find_all_users_empty_404_not_found() {

        List<AppUser> userListMockito = new ArrayList<>();

        Mockito.when(appUserService.findAll()).thenReturn(userListMockito);

        ResponseEntity<List<AppUser>> listUsersResultController = appUserController.findAll();
        Assertions.assertEquals(204, listUsersResultController.getStatusCodeValue());
    }

    @Test
    @Order(3)
    public void find_user_by_id_200_ok() {
        Date timeCreatedAndEdited = new Date();
        AppUser appUserMockito = new AppUser("marcelaTes3Usr1", "pasword1", timeCreatedAndEdited, null, false);

        Mockito.when(appUserService.findById(1L)).thenReturn(appUserMockito);
        ResponseEntity<AppUser> usersResultController = appUserController.findById(1L);
        Assertions.assertEquals(200, usersResultController.getStatusCodeValue());
    }

    @Test
    @Order(4)
    public void find_user_by_id_404_not_found() {

        Mockito.when(appUserService.findById(Mockito.anyLong())).thenReturn(null);

        ResponseEntity<AppUser> usersResultController = appUserController.findById(1L);
        Assertions.assertEquals(204, usersResultController.getStatusCodeValue());
    }

    @Test
    @Order(5)
    public void create_user_200_ok() throws ParseException {

        AppUserDTO appUserDtoMockito = new AppUserDTO("marcelaTes5Usr1", "pasword1","31/12/2022");
        AppUser appUserMockito = new AppUser(appUserDtoMockito);

        Mockito.when(appUserService.createAppUser(appUserDtoMockito)).thenReturn(appUserMockito);

        ResponseEntity<AppUser> userResult = appUserController.createAppUser(appUserDtoMockito);
        Assertions.assertTrue(201 == userResult.getStatusCodeValue());
    }

    @Test
    @Order(6)
    public void update_user_by_id_200_ok() throws ParseException {

        AppUserDTO userUpdateDtoMockito = new AppUserDTO(1L,"marcelaTes6Usr1", "pasword1","31/12/2022");
        AppUser userMockito = new AppUser(userUpdateDtoMockito);

        Mockito.when(appUserService.updateAppUser(userUpdateDtoMockito)).thenReturn(userMockito);

        ResponseEntity<AppUser> userUpdatedResult = appUserController.updateAppUser(userUpdateDtoMockito);
        Assertions.assertTrue(200 == userUpdatedResult.getStatusCodeValue());
        Assertions.assertTrue(userUpdatedResult.getBody() != null);
    }

    @Test
    @Order(7)
    public void delete_user_by_id_204_No_Content() {
        Mockito.when(appUserService.deleteAppUser(1L)).thenReturn(false);
        Boolean userResult = appUserService.deleteAppUser(1L);
        ResponseEntity<Boolean> userResultController = appUserController.deleteAppUser(1L);
        Assertions.assertEquals(204, userResultController.getStatusCodeValue());
    }

}
