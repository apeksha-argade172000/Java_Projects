package com.college.project.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ClgDto {
    private Integer clgId;
    private String name;
    private String addr;
    private Integer contact;
//    private  Integer isactive=1;

}
