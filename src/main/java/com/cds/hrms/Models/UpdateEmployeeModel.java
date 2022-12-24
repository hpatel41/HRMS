package com.cds.hrms.Models;

import com.cds.hrms.Entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeModel {
    private String privateEmail;
    private Gender gender;
}
