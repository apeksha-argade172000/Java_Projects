package com.industry.employee.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;

@Getter
@Setter
public class LoginDto {
    private Integer regid;
    private String username;
    private String password;
}
