package com.cds.hrms.Controllers;

import com.cds.hrms.Models.EmployeeModel;
import com.cds.hrms.Models.UpdateEmployeeModel;
import com.cds.hrms.Models.UpdatePasswordModel;
import com.cds.hrms.Service.ServiceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping("/employees")
    public ResponseEntity<List<EmployeeModel>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @RequestMapping("/employees/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employeeModel) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeModel), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/employees/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(
            @RequestBody UpdateEmployeeModel updateEmployeeModel,
            @PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.updateEmployee(updateEmployeeModel, id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employees/update-password")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordModel updatePasswordModel) {
        return new ResponseEntity<>(employeeService.updatePassword(updatePasswordModel), HttpStatus.OK);
    }
}
