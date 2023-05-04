package com.industry.employee.service;

import com.industry.employee.dto.LoginDto;
import com.industry.employee.dto.LoginResDto;

public interface LoginService {


    LoginResDto userLoginservice(LoginDto loginDto);
}
