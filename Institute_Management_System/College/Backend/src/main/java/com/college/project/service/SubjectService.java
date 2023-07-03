package com.college.project.service;

import com.college.project.dto.SubjectDto;
import com.college.project.dto.SubjectResDto;

import java.util.List;

public interface SubjectService {
    Boolean insertSubService(SubjectDto subjectDto);

    List getSubjectService(Integer clgId);

    SubjectResDto editSubService(Integer subid);

    Boolean deleteSubService(Integer subid);

    List getSubService();
}
