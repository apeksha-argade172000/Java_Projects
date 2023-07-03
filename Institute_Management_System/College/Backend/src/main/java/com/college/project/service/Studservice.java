package com.college.project.service;

import com.college.project.dto.StudDto;
import com.college.project.dto.StudResDto;

import java.util.List;

public interface Studservice {
    boolean insertStudService(StudDto studDto);

    List getStudService();

    StudResDto editStudService(Integer studid);

    List getStudListService(Integer id);

    List getNewStudListService(Integer clgId);

    Boolean deleteStudService(Integer studid);
}
