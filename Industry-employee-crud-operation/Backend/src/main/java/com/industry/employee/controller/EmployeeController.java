package com.industry.employee.controller;

import com.industry.employee.dto.EmployeeDto;
import com.industry.employee.dto.IndustryResponseVO;
import com.industry.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "addemp")
    public Boolean insertEmpDataCtrl(@RequestBody EmployeeDto employeeDto){
        Boolean flag=employeeService.insertEmpDataService(employeeDto);
        if (flag==true){
            return flag;
        }
        else {
            return flag;
        }
    }

    @GetMapping(value = "getdept/{indId}")
    public IndustryResponseVO<List> getDeptController(@PathVariable Integer indId){
        IndustryResponseVO<List> industryResponseVO=new IndustryResponseVO<>();
        List list=employeeService.getDeptService(indId);
        if (list.size()!=0){
            industryResponseVO.setResult(list);
            industryResponseVO.setMessage("List found");
            return industryResponseVO;
        }
        else {
            industryResponseVO.setMessage("Not Found");
            return industryResponseVO;
        }
    }

    @GetMapping(value = "getemp")
    public IndustryResponseVO<List> getEmpCtrl(){
        IndustryResponseVO<List> industryResponseVO=new IndustryResponseVO<>();
        List list=employeeService.getEmpService();
        if (list.size()!=0){
            industryResponseVO.setResult(list);
            industryResponseVO.setMessage("Data found");
            return industryResponseVO;
        }
        else {
            industryResponseVO.setMessage("Data not found");
            return industryResponseVO;
        }
    }

    @GetMapping(value = "getdeptwiseemp/{deptid}")
    public IndustryResponseVO<List> getEmpListCtrl(@PathVariable Integer deptid){
        IndustryResponseVO<List> industryResponseVO=new IndustryResponseVO<>();
        List list=employeeService.getEmpListService(deptid);
        if (list.size()!=0){
            industryResponseVO.setResult(list);
            industryResponseVO.setMessage("Data found");
            return industryResponseVO;
        }
        else {
            industryResponseVO.setMessage("Not found");
            return industryResponseVO;
        }
    }

    @GetMapping(value = "editemp/{empid}")
    public IndustryResponseVO<EmployeeDto> editEmpCtrl(@PathVariable Integer empid){
        IndustryResponseVO<EmployeeDto> industryResponseVO=new IndustryResponseVO<>();
        EmployeeDto employeeDto=employeeService.editEmpService(empid);
        if (employeeDto !=null){
            industryResponseVO.setResult(employeeDto);
            industryResponseVO.setMessage("Data found");
            return industryResponseVO;
        }
        else {
            industryResponseVO.setMessage("Data not found");
            return industryResponseVO;
        }

    }

    @GetMapping(value = "deleteemp/{empid}")
    public Boolean deleteEmpCtrl(@PathVariable Integer empid){
        Boolean flag=employeeService.deletEmpService(empid);
        if (flag==true){
            return true;
        }
        else {
            return false;
        }
    }
}
