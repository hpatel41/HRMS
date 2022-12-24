package com.cds.hrms.Repositories;

import com.cds.hrms.Entities.Skills.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepo extends JpaRepository<Skills, Integer> {
}
