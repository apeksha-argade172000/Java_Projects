package com.industry.employee.service.Impl;

import com.industry.employee.dao.RegistrationDao;
import com.industry.employee.dto.RegistrationDto;
import com.industry.employee.model.RegistrationModel;
import com.industry.employee.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationDao registrationDao;
    @Override
    public Boolean insertregistrationService(RegistrationDto registrationDto) {
        RegistrationModel registrationModel=new RegistrationModel();
        registrationModel.setRegid(registrationDto.getRegid());
        registrationModel.setFirstname(registrationDto.getFirstname());
        registrationModel.setLastname(registrationDto.getLastname());
        registrationModel.setUsername(registrationDto.getUsername());
        registrationModel.setPassword(registrationDto.getPassword());
        registrationModel.setEmail(registrationDto.getEmail());
        registrationModel.setContact(registrationDto.getContact());
        Boolean flag=registrationDao.insertRegistrationDao(registrationModel);
        return flag;

    }
}
