package com.college.project.dto;

import com.college.project.model.ClgModel;
import com.college.project.model.StudSubjectModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudResDto {

    private Integer studid;
    private String name;
    private String addr;
    private String dob;
    private String gender;
    private String contact;

    private StudSubjectModel sub;

    private ClgModel inst;
}
