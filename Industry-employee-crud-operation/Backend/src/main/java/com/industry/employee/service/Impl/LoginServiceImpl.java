package com.industry.employee.service.Impl;

import com.industry.employee.dao.LoginDao;
import com.industry.employee.dto.LoginDto;
import com.industry.employee.dto.LoginResDto;
import com.industry.employee.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public LoginResDto userLoginservice(LoginDto loginDto) {
      LoginResDto loginResDto=new LoginResDto();
      loginResDto.setUsername(loginDto.getUsername());
      loginResDto.setPassword(loginDto.getPassword());

      loginResDto=loginDao.userLoginDao(loginDto);
      if (loginResDto!=null){
          if (loginResDto.getPassword().equals(loginDto.getPassword())){
              loginResDto.setLoginstatus(true);
              loginResDto.setLoginmessage("Logged in successfully");
          }
          else {
              loginResDto.setLoginmessage("Invalid password");
              loginResDto.setLoginstatus(false);
          }

      }
      else {
          loginResDto=new LoginResDto();
          loginResDto.setLoginmessage("Invalid username");
          loginResDto.setLoginstatus(false);
      }
      return loginResDto;

    }
}
