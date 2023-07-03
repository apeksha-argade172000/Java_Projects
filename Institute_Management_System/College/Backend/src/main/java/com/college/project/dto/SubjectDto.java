package com.college.project.dto;

import com.college.project.model.ClgModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDto {
    private Integer subid;
    private Integer id;
    private String subname;

    private ClgModel inst;
}
