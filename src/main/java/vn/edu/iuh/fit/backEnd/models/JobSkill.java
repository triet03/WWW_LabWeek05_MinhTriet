package vn.edu.iuh.fit.backEnd.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class JobSkill {
    @EmbeddedId
    private JobSkillId id;

    @ManyToOne
    @MapsId("jobId")
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private Byte skillLevel;
    private String moreInfos;
    // getters and setters
	public JobSkill() {
		super();
		// TODO Auto-generated constructor stub
	}


}