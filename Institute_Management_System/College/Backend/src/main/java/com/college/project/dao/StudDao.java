package com.college.project.dao;

import com.college.project.dto.StudResDto;
import com.college.project.model.StudModel;
import com.college.project.model.StudSubjectModel;

import java.util.List;

public interface StudDao {
    boolean inserStudDao(StudModel studModel);

    List getStudDao();

    StudResDto editStudDao(Integer studid);

    List getStudListDao(Integer id);

    boolean inserStudSubDao(StudSubjectModel studSubjectModel);

    List getNewStudListDao(Integer clgId);

    Boolean deleteStudDao(Integer studid);
}
