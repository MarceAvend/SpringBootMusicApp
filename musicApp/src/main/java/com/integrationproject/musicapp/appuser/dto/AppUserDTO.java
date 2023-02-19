package com.integrationproject.musicapp.appuser.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class AppUserDTO implements Serializable {

    private static final long serialVersionUID = -2335297918513917021L;

    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    private Date editDate;

    private Boolean isAdmin;


    public AppUserDTO() { }

    public Date transformaDateString(String sDate1) throws ParseException {
//        String sDate1="31/12/1998";
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        return formatter1.parse(sDate1);
    }

    public AppUserDTO(String name, String password, String createDate) throws ParseException {
        this.name = name;
        this.password = password;
        this.createDate = transformaDateString(createDate);
        this.editDate = null;
        this.isAdmin = null;
    }

    public AppUserDTO(Long id,String name, String password, String createDate) throws ParseException {
        this.id = id;
        this.name = name;
        this.password = password;
        this.createDate = transformaDateString(createDate);
        this.editDate = null;
        this.isAdmin = null;
    }

}
