package com.cds.hrms.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSkillsModelPOST {
    private Integer employeeId;
    private Integer skillId;
    private Integer ratings;
}
