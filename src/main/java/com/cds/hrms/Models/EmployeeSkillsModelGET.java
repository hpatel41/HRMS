package com.cds.hrms.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSkillsModelGET {
    private EmployeeModel employee;
    private List<SkillsList> skillsList;
}
