package com.cds.hrms.Repositories;

import com.cds.hrms.Entities.Skills.EmployeeSKillPK;
import com.cds.hrms.Entities.Skills.EmployeeSkills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeSkillsRepo extends JpaRepository<EmployeeSkills, EmployeeSKillPK> {
    List<EmployeeSkills> findByEmployeeId(Integer id);
}
