package com.industry.employee.dto;

import com.industry.employee.model.DepartmentModel;
import com.industry.employee.model.IndustryModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private Integer empid;
    private  String empname;
    private String addr;
    private String contact;
    private String dob;
    private IndustryModel ind;
    private DepartmentModel dept;

}
