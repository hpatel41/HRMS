package com.cds.hrms.Service.ServiceImpl;

import com.cds.hrms.Entities.Skills.EmployeeSkills;
import com.cds.hrms.Models.*;
import com.cds.hrms.Repositories.EmployeeRepo;
import com.cds.hrms.Repositories.EmployeeSkillsRepo;
import com.cds.hrms.Repositories.SkillsRepo;
import com.cds.hrms.Service.EmployeeSkillsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService {

    @Autowired
    private EmployeeSkillsRepo employeeSkillsRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private SkillsRepo skillsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeSkillsModelGET getAllSkillsForEmployee(Integer id) {
        EmployeeModel employeeModel = modelMapper.map(employeeRepo.findById(id).get(), EmployeeModel.class);
        List<SkillsList> skillsList = new ArrayList<>();
        for (EmployeeSkills employeeSkill: employeeSkillsRepo.findByEmployeeId(id)) {
            SkillsModel skillsModel = modelMapper.map(
                    skillsRepo.findById(employeeSkill.getSkillId()).get(), SkillsModel.class);
            SkillsList skill = new SkillsList(skillsModel, employeeSkill.getRatings());
            skillsList.add(skill);
        }

        return new EmployeeSkillsModelGET(employeeModel, skillsList);
    }

    @Override
    public EmployeeSkillsModelGET addSkillForEmployee(EmployeeSkillsModelPOST employeeSkillsModelPOST) {

        EmployeeSkills employeeSkills = new EmployeeSkills(
            employeeSkillsModelPOST.getEmployeeId(), // pass employee id, employee will be mapped automatically
            employeeSkillsModelPOST.getSkillId(), // pass skill id, skill will be mapped automatically
            employeeSkillsModelPOST.getRatings()
        );

        return getAllSkillsForEmployee(employeeSkillsRepo.save(employeeSkills).getEmployeeId());
    }
}
