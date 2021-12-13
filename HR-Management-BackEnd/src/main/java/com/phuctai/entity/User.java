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
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 20)
	private String userId;
	
	@Column()
	private Boolean statusEmployee;
	
	@Column(nullable = false, unique = true, length = 100)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false)
	private Boolean statusAccount;
	
	@Column(nullable = false)
	private Long failNumber;
	
	@Column()
	private String departmentId;
	
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
	

	
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "user_role",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName="userId") },
            inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName="id") })
	private Set<Role> roles = new HashSet<>();
	
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "user_leaveType",
            joinColumns = { @JoinColumn(name = "user_id",  referencedColumnName="userId") },
            inverseJoinColumns = { @JoinColumn(name = "leaveType_id",  referencedColumnName="id") })
	private Set<LeaveType> leaveTypes = new HashSet<>();
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
