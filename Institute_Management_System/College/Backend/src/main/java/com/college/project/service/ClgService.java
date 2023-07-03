package com.college.project.service;

import com.college.project.dto.ClgDto;
import com.college.project.dto.ClgResDto;

import java.util.List;

public interface ClgService {
    boolean insertClgService(ClgDto clgDto);

    List getClgRecordService();

    ClgResDto editClgService(Integer clgId);

    Boolean deleteClgService(Integer clgId);
}
