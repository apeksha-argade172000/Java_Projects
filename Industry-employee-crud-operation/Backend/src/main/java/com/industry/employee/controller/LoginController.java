package com.industry.employee.controller;

import com.industry.employee.dto.IndustryResponseVO;
import com.industry.employee.dto.LoginDto;
import com.industry.employee.dto.LoginResDto;
import com.industry.employee.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "login")
    public IndustryResponseVO<LoginResDto> loginCtrl(@RequestBody LoginDto loginDto){
        IndustryResponseVO<LoginResDto> industryResponseVO=new IndustryResponseVO<>();
        LoginResDto loginResDto=loginService.userLoginservice(loginDto);
        if (loginResDto!=null){
            industryResponseVO.setStatuscode(String.valueOf(HttpStatus.OK));
            industryResponseVO.setMessage(loginResDto.getLoginmessage());
            industryResponseVO.setResult(loginResDto);
        }
        else {
            industryResponseVO.setStatuscode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            industryResponseVO.setMessage(loginResDto.getLoginmessage());
            industryResponseVO.setResult(loginResDto);
        }
        return industryResponseVO;
    }
}
