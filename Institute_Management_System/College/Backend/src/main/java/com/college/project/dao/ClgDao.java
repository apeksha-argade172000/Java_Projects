package com.college.project.dao;

import com.college.project.dto.ClgResDto;
import com.college.project.model.ClgModel;

import java.util.List;

public interface ClgDao {
     boolean insertClgDao(ClgModel clgModel) ;

     List getClgRecordDao();

     ClgResDto editCalDao(Integer clgId);

     Boolean deleteClgDao(Integer clgId);
}
