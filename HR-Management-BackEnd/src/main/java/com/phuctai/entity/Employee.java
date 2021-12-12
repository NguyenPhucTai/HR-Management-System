package com.phuctai.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true, length = 20)
	private String employeeId;
	
	@Column(length = 50)
	private String firstName;
	
	@Column(length = 50)
	private String middleName;
	
	@Column(length = 50)
	private String lastName;
	
	@Column(length = 200)
	private String email;
	
	@Column(length = 20)
	private String phone;
	
	@Column()
	private String streetNumber;
	
	@Column()
	private String city;
	
	@Column()
	private String disctrict;
	
	@Column()
	private String ward;
	
	@Column()
	private Date dateOfBirth;
	
	@Column()
	private Boolean status;
	
	@Column(nullable = false, unique = true, length = 20)
	private String departmentId;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "employee_role",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();
	
	public Employee() {
		
	}
	
	
	
	
	
}
