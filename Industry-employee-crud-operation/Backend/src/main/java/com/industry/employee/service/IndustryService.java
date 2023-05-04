package com.industry.employee.service;


import com.industry.employee.dto.IndustryDto;

import java.util.List;

public interface IndustryService {

    Boolean insertIndustryService(IndustryDto industryDto);

    List getIndDataService();

    IndustryDto editIndDataService(Integer indId);

    Boolean deleteIndDataService(Integer indId);
}
