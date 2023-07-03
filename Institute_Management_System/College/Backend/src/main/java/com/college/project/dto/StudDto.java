package com.college.project.dto;

import com.college.project.model.ClgModel;
import com.college.project.model.StudModel;
import com.college.project.model.StudSubjectModel;
import com.college.project.model.SubjectModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudDto {
    private Integer studid;
    private String name;
    private String addr;
    private String dob;
    private String gender;
    private String contact;

    private ClgModel inst;
    private StudModel studModel;
    private SubjectModel subjectModel;
    private StudSubjectModel sub;

    private List<SubjectDto> subjectModelList;
}
