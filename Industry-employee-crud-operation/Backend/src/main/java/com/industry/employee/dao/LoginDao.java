package com.industry.employee.dao;

import com.industry.employee.dto.LoginDto;
import com.industry.employee.dto.LoginResDto;

public interface LoginDao {
    LoginResDto userLoginDao(LoginDto loginDto);
}
