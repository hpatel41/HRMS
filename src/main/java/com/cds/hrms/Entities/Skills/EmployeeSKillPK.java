package com.cds.hrms.Entities.Skills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSKillPK implements Serializable {
    private Integer employeeId;
    private Integer skillId;
}
