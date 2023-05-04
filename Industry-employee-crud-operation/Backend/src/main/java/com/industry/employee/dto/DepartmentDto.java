package com.industry.employee.dto;

import com.industry.employee.model.IndustryModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDto {
    private Integer deptid;
    private String name;
    private IndustryModel ind;
}
