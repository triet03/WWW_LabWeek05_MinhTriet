package vn.edu.iuh.fit.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backEnd.models.*;
@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {}
