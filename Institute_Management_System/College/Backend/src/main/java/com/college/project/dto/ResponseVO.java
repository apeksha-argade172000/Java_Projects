package com.college.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseVO<T> {
    private String statuscode;
    private String message;
    private  T result;
}
