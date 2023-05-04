package com.industry.employee.service.Impl;

import com.industry.employee.dao.EmployeeDao;
import com.industry.employee.dto.EmployeeDto;
import com.industry.employee.model.EmployeeModel;
import com.industry.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Boolean insertEmpDataService(EmployeeDto employeeDto) {
        EmployeeModel employeeModel=new EmployeeModel();
        employeeModel.setEmpid(employeeDto.getEmpid());
        employeeModel.setEmpname(employeeDto.getEmpname());
        employeeModel.setAddr(employeeDto.getAddr());
        employeeModel.setDob(employeeDto.getDob());
        employeeModel.setContact(employeeDto.getContact());
        employeeModel.setInd(employeeDto.getInd());
        employeeModel.setDept(employeeDto.getDept());
        Boolean flag=employeeDao.insertEmpDataDao(employeeModel);
        return flag;
    }

    @Override
    public List getDeptService(Integer indId) {
        List list=employeeDao.getDeptDao(indId);
        return list;
    }

    @Override
    public List getEmpService() {
        List list=employeeDao.getEmpDao();
        return list;
    }

    @Override
    public List getEmpListService(Integer deptid) {
        List list=employeeDao.getEmpListDao(deptid);
        return list;
    }

    @Override
    public EmployeeDto editEmpService(Integer empid) {
        EmployeeDto employeeDto=employeeDao.editEmpDao(empid);
        return employeeDto;
    }

    @Override
    public Boolean deletEmpService(Integer empid) {
        Boolean flag=employeeDao.deleteEmpDao(empid);
        return flag;
    }
}
