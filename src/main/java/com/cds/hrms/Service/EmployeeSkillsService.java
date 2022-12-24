package com.cds.hrms.Service;

import com.cds.hrms.Models.EmployeeSkillsModelGET;
import com.cds.hrms.Models.EmployeeSkillsModelPOST;

import java.util.List;

public interface EmployeeSkillsService {
    public EmployeeSkillsModelGET addSkillForEmployee(EmployeeSkillsModelPOST employeeSkillsModelPOST);
    public EmployeeSkillsModelGET getAllSkillsForEmployee(Integer id);
}
