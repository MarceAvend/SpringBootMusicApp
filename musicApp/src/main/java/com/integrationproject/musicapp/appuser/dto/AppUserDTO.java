package com.integrationproject.musicapp.appuser.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
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

}
