package com.industry.employee.dao;

import com.industry.employee.dto.IndustryDto;
import com.industry.employee.model.IndustryModel;

import java.util.List;

public interface IndustryDao {
    Boolean insertIndustryDao(IndustryModel industryDto);

    List getIndDataDao();

    IndustryDto editIndDataDao(Integer indId);

    Boolean deleteIndDataDao(Integer indId);
}
