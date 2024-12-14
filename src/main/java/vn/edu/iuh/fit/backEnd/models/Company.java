package vn.edu.iuh.fit.backEnd.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comId;
    private String about;
    private String compName;
    private String email;
    private String phone;
    private String webUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;
    // getters and setters

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}


}