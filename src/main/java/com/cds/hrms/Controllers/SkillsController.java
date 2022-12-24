package com.cds.hrms.Controllers;

import com.cds.hrms.Models.SkillsModel;
import com.cds.hrms.Service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillsController {

    @Autowired
    private SkillsService skillsService;

    @RequestMapping(method = RequestMethod.POST, value = "/skills")
    public ResponseEntity<SkillsModel> addSkill(@RequestBody SkillsModel skillsModel) {
        return new ResponseEntity<>(skillsService.addSkill(skillsModel), HttpStatus.CREATED);
    }

    @RequestMapping("/skills")
    public ResponseEntity<List<SkillsModel>> listAllSkills() {
        return new ResponseEntity<>(skillsService.getAllSkills(), HttpStatus.OK);
    }
}
