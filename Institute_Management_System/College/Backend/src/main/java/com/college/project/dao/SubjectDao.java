package com.college.project.dao;

import com.college.project.dto.SubjectResDto;
import com.college.project.model.SubjectModel;

import java.util.List;

public interface SubjectDao {
    Boolean insertSubjectDao(SubjectModel subjectModel);

    List getSubjectDao(Integer clgId);

    SubjectResDto editSubjectDao(Integer subid);

    Boolean deleteSubDao(Integer subid);

    List getSubDao();
}
