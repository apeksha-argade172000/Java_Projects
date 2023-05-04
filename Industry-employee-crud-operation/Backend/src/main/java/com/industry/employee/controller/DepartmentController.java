package com.industry.employee.controller;

import com.industry.employee.dto.DepartmentDto;
import com.industry.employee.dto.IndustryResponseVO;
import com.industry.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "adddept")
    public Boolean insertDeptController(@RequestBody DepartmentDto departmentDto){
            Boolean flag=departmentService.insertDeptService(departmentDto);
            if (flag == true){
                return flag;
            }
            else {
                return flag;
            }
    }

    @GetMapping(value = "getindwisedept/{indId}")
    public IndustryResponseVO<List> getIndwiseDeptController(@PathVariable Integer indId){
        IndustryResponseVO<List> industryResponseVO=new IndustryResponseVO<>();
        List list=departmentService.getIndWiseDeptService(indId);
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
}
