package com.cds.hrms.Service.ServiceImpl;

import com.cds.hrms.Entities.Employee;
import com.cds.hrms.Models.EmployeeModel;
import com.cds.hrms.Models.UpdateEmployeeModel;
import com.cds.hrms.Models.UpdatePasswordModel;
import com.cds.hrms.Repositories.EmployeeRepo;
import com.cds.hrms.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<EmployeeModel> getAllEmployee() {
        List<Employee> employeeList = employeeRepo.findAll();
        List<EmployeeModel> employeeModelList = employeeList.stream().map((employee) -> modelMapper.map(employee, EmployeeModel.class)).collect(Collectors.toList());
        return employeeModelList;
    }

    @Override
    public EmployeeModel getEmployeeById(Integer id) {
        // Handle request for employee not found for id
        Employee employee = employeeRepo.findById(id).get();
        return modelMapper.map(employee, EmployeeModel.class);
    }

    @Override
    public EmployeeModel createEmployee(EmployeeModel employeeModel) {
        Employee employee = modelMapper.map(employeeModel, Employee.class);
        employee.setEmail(employee.getFirstName().toLowerCase() + "." + employee.getLastName().toLowerCase());
        employee.setPassword(passwordEncoder.encode(employee.getFirstName().toLowerCase() + "Crest@123"));
        return modelMapper.map(employeeRepo.save(employee), EmployeeModel.class);
    }

    @Override
    public EmployeeModel updateEmployee(UpdateEmployeeModel updateEmployeeModel, Integer id) {
        // Handle request for employee not found for id
        Employee employee = employeeRepo.findById(id).get();

        // How to dynamically update the values that not null? Rather than manually checking all values
        if (updateEmployeeModel.getGender() != null) {
            employee.setGender(updateEmployeeModel.getGender());
        }
        if (updateEmployeeModel.getPrivateEmail() != null) {
            employee.setPrivateEmail(updateEmployeeModel.getPrivateEmail());
        }
        return modelMapper.map(employeeRepo.save(employee), EmployeeModel.class);
    }

    @Override
    public String deleteEmployee(Integer id) {
        Employee employee = employeeRepo.findById(id).get();
        employeeRepo.delete(employee);
        return "Employee with id: " + id + " deleted successfully";
    }

    @Override
    public String updatePassword(UpdatePasswordModel updatePasswordModel) {
        Employee employee = employeeRepo.findById(updatePasswordModel.getId()).get();

        // if (employee.getPassword() == passwordEncoder.encode(updatePasswordModel.getOldPassword())) {
        if (passwordEncoder.matches(updatePasswordModel.getOldPassword(), employee.getPassword())) {
            employee.setPassword(passwordEncoder.encode(updatePasswordModel.getNewPassword()));
            employeeRepo.save(employee);
            return "Password for id: " + updatePasswordModel.getId() + " updated successfully";
        } else {
            return "Old password is not matching. Please try again.";
        }
    }
}
