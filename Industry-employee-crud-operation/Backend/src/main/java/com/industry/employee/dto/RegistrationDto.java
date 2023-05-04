package com.industry.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {
    private Integer regid;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String contact;

}
