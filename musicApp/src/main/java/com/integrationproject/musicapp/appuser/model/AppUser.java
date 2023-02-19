package com.integrationproject.musicapp.appuser.model;

import com.integrationproject.musicapp.appuser.dto.AppUserDTO;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "APP_USER")
public class AppUser implements Serializable {

    private static final long serialVersionUID = -329493776645965148L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "EDIT_DATE")
    private Date editDate;

    @Column(name = "IS_ADMIN", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isAdmin;

    public AppUser() { }

    public AppUser(String name, String password, Date createDate) {
        this.name = name;
        this.password = password;
        this.createDate = createDate;
        this.editDate = null;
        this.isAdmin = false;
    }

    public AppUser(String name, String password, Date createDate, Date editDate, Boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.createDate = createDate;
        this.editDate = null;
        this.isAdmin = isAdmin;
    }

    public AppUser(AppUserDTO appUserDto) {
        this.name = appUserDto.getName();
        this.password = appUserDto.getPassword();

        if (appUserDto.getCreateDate() == null) {
            this.createDate = new Date();
        }else { this.createDate = appUserDto.getCreateDate(); }
        this.editDate = null;
        if (appUserDto.getIsAdmin() != null) {
            this.isAdmin =  appUserDto.getIsAdmin();
        } else{ this.isAdmin = false; }
    }

    public void updateAppUserFromDTO(AppUserDTO appUserDTO) {
        this.name = appUserDTO.getName();
        this.password = appUserDTO.getPassword();
        this.editDate = new Date();
        if (appUserDTO.getIsAdmin() != null) {
            this.isAdmin = appUserDTO.getIsAdmin();
        }
        this.isAdmin = appUserDTO.getIsAdmin();
    }

}
