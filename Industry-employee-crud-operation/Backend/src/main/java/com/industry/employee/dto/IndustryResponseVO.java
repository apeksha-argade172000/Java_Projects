package com.industry.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndustryResponseVO <T>{
    private String statuscode;
    private String message;
    private T result;
}
