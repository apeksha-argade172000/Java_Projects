package com.industry.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResDto {
    private Integer regid;
    private String username;
    private String password;
    private Boolean loginstatus;
    private String status;
    private String loginmessage;
}
