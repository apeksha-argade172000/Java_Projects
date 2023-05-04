package com.industry.employee.service.Impl;

import com.industry.employee.dao.DepartmentDao;
import com.industry.employee.dto.DepartmentDto;
import com.industry.employee.model.DepartmentModel;
import com.industry.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Boolean insertDeptService(DepartmentDto departmentDto) {
        DepartmentModel departmentModel=new DepartmentModel();
        departmentModel.setDeptid(departmentDto.getDeptid());
        departmentModel.setName(departmentDto.getName());
        departmentModel.setInd(departmentDto.getInd());

        Boolean flag=departmentDao.insertDeptDao(departmentModel);
        return flag;
    }

    @Override
    public List getIndWiseDeptService(Integer indId) {
        List list=departmentDao.getIndWiseDeptDao(indId);
        return list;
    }
}
