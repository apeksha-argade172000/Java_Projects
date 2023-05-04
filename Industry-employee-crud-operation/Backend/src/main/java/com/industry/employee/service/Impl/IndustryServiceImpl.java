package com.industry.employee.service.Impl;

import com.industry.employee.dao.IndustryDao;
import com.industry.employee.dto.IndustryDto;
import com.industry.employee.model.IndustryModel;
import com.industry.employee.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryServiceImpl implements IndustryService {
    @Autowired
    private IndustryDao industryDao;
    @Override
    public Boolean insertIndustryService(IndustryDto industryDto) {
        IndustryModel industryModel=new IndustryModel();
        industryModel.setName(industryDto.getName());
        industryModel.setIndId(industryDto.getIndId());
        industryModel.setAddr(industryDto.getAddr());
        industryModel.setContact(industryDto.getContact());
        Boolean flag=industryDao.insertIndustryDao(industryModel);
        return flag;
    }

    @Override
    public List getIndDataService() {
        List list=industryDao.getIndDataDao();
        return list;
    }

    @Override
    public IndustryDto editIndDataService(Integer indId) {
        IndustryDto industryDto=industryDao.editIndDataDao(indId);
        return industryDto;
    }

    @Override
    public Boolean deleteIndDataService(Integer indId) {
        Boolean flag=industryDao.deleteIndDataDao(indId);
        return flag;
    }
}
