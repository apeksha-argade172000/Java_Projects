package com.industry.employee.service;

import com.industry.employee.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    Boolean insertDeptService(DepartmentDto departmentDto);

    List getIndWiseDeptService(Integer indId);
}
