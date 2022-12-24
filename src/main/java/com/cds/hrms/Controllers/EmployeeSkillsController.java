package com.cds.hrms.Controllers;

import com.cds.hrms.Models.EmployeeSkillsModelGET;
import com.cds.hrms.Models.EmployeeSkillsModelPOST;
import com.cds.hrms.Service.EmployeeSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeSkillsController {
    @Autowired
    private EmployeeSkillsService employeeSkillsService;

    @RequestMapping(method = RequestMethod.POST, value = "/employee-skills")
    public ResponseEntity<EmployeeSkillsModelGET> addSkillForEmployee(@RequestBody EmployeeSkillsModelPOST employeeSkillsModelPOST) {
        return new ResponseEntity<>(employeeSkillsService.addSkillForEmployee(employeeSkillsModelPOST), HttpStatus.CREATED);
    }

    @RequestMapping("/employee-skills/{id}")
    public ResponseEntity<EmployeeSkillsModelGET> getAllSkillsForEmployee(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeSkillsService.getAllSkillsForEmployee(id), HttpStatus.OK);
    }
}
