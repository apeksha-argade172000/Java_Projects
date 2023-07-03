package com.college.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudResponseVO <T>{
    private Integer statuscode;
    private String message;
    private T result;
}
