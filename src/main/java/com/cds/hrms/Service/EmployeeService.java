package com.cds.hrms.Service;

import com.cds.hrms.Models.EmployeeModel;
import com.cds.hrms.Models.UpdateEmployeeModel;
import com.cds.hrms.Models.UpdatePasswordModel;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeModel> getAllEmployee();
    public EmployeeModel getEmployeeById(Integer id);
    public EmployeeModel createEmployee(EmployeeModel employeeModel);
    public EmployeeModel updateEmployee(UpdateEmployeeModel updateEmployeeModel, Integer id);
    public String deleteEmployee(Integer id);
    public String updatePassword(UpdatePasswordModel updatePasswordModel);
}
