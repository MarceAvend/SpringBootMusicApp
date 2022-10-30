package com.integrationproject.musicapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
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

}
