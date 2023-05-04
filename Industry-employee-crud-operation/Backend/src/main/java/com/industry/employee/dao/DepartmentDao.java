package com.industry.employee.dao;

import com.industry.employee.model.DepartmentModel;

import java.util.List;

public interface DepartmentDao {
    Boolean insertDeptDao(DepartmentModel departmentModel);

    List getIndWiseDeptDao(Integer indId);
}
