package com.cds.hrms.Entities.Skills;

import com.cds.hrms.Entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@IdClass(EmployeeSKillPK.class)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSkills {

    // Use the employee_id and skill_id as PK

    @Id
    @Column(name = "employee_id") // save the column with the defined name
    private Integer employeeId;
    @Id
    @Column(name = "skill_id")
    private Integer skillId;
    private Integer ratings;

    // Add the employee reference and save the column with same name to assign the FK
    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "skill_id", insertable = false, updatable = false)
    private Skills skills;

    public EmployeeSkills(Integer employeeId, Integer skillId, Integer ratings) {
        this.employeeId = employeeId;
        this.skillId = skillId;
        this.ratings = ratings;
    }
}
