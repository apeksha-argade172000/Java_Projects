package com.industry.employee.dao;

import com.industry.employee.dto.EmployeeDto;
import com.industry.employee.model.EmployeeModel;

import java.util.List;

public interface EmployeeDao {
    Boolean insertEmpDataDao(EmployeeModel employeeModel);

    List getDeptDao(Integer indId);

    List getEmpDao();

    List getEmpListDao(Integer deptid);

    EmployeeDto editEmpDao(Integer empid);

    Boolean deleteEmpDao(Integer empid);
}
