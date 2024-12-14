package vn.edu.iuh.fit.backEnd.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    private String jobName;
    private String jobDesc;

    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;
    // getters and setters

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}


}
