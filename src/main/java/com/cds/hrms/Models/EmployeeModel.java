package com.cds.hrms.Models;

import com.cds.hrms.Entities.Gender;
import com.cds.hrms.Entities.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String privateEmail;
    private Gender gender;
    private List<Roles> roles;
}
