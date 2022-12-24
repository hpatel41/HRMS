package com.cds.hrms.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillsList extends SkillsModel{
    private Integer ratings;
    public SkillsList(SkillsModel skillsModel, Integer ratings) {
        super.setId(skillsModel.getId());
        super.setName(skillsModel.getName());
        this.ratings = ratings;
    }
}
