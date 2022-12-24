package com.cds.hrms.Service.ServiceImpl;

import com.cds.hrms.Entities.Skills.Skills;
import com.cds.hrms.Models.SkillsModel;
import com.cds.hrms.Repositories.SkillsRepo;
import com.cds.hrms.Service.SkillsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    private SkillsRepo skillsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SkillsModel addSkill(SkillsModel skillsModel) {
        Skills skills = modelMapper.map(skillsModel, Skills.class);
        return modelMapper.map(skillsRepo.save(skills), SkillsModel.class);
    }

    @Override
    public List<SkillsModel> getAllSkills() {
        List<Skills> skillsList = skillsRepo.findAll();
        return skillsList.stream().map((skill) -> modelMapper.map(skill, SkillsModel.class)).collect(Collectors.toList());
    }
}
