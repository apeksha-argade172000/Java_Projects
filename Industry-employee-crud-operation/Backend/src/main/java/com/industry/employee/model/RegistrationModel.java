package com.industry.employee.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "registration_table")
public class RegistrationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer regid;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String contact;
}
