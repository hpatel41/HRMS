package com.cds.hrms.Service;

import com.cds.hrms.Models.SkillsModel;

import java.util.List;

public interface SkillsService {
    public SkillsModel addSkill(SkillsModel skillsModel);
    public List<SkillsModel> getAllSkills();
}
