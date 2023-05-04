package com.industry.employee.service;

import com.industry.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    Boolean insertEmpDataService(EmployeeDto employeeDto);

    List getDeptService(Integer indId);

    List getEmpService();

    List getEmpListService(Integer deptid);

    EmployeeDto editEmpService(Integer empid);

    Boolean deletEmpService(Integer empid);
}
