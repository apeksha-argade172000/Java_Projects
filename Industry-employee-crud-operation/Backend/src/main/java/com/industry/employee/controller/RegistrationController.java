package com.industry.employee.controller;

import com.industry.employee.dto.IndustryResponseVO;
import com.industry.employee.dto.RegistrationDto;
import com.industry.employee.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping(value = "register")
    public IndustryResponseVO<Boolean> insertregisterCtrl(@RequestBody RegistrationDto registrationDto){
        IndustryResponseVO<Boolean> industryResponseVO=new IndustryResponseVO<>();
        Boolean flag=registrationService.insertregistrationService(registrationDto);
        if (flag==true){
            industryResponseVO.setStatuscode(String.valueOf(HttpStatus.OK));
            industryResponseVO.setResult(flag);

        }
        else {
            industryResponseVO.setStatuscode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            industryResponseVO.setResult(flag);

        }
        return industryResponseVO;
    }
}
