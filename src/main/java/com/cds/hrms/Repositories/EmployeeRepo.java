package com.cds.hrms.Repositories;

import com.cds.hrms.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Employee findByEmail(String username);
}
