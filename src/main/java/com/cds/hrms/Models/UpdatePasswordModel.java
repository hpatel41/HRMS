package com.cds.hrms.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePasswordModel {
    private Integer id;
    private String oldPassword;
    private String newPassword;
}
