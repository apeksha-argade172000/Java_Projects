package com.college.project.dto;

import com.college.project.model.ClgModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectResDto {
    private Integer subid;
    private String subname;
    private Integer isactive;
    private ClgModel inst;
}
