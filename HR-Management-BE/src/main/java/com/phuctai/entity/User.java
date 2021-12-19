package com.phuctai.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.phuctai.entity.Role;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userId", unique = true)
	private String userId;
	
	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password", length = 100)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();

	@Column(name = "statusAccount")
	private Boolean statusAccount;

	@Column(name = "failNumber")
	private Long failNumber;

	@Column(name = "statusEmployee")
	private Boolean statusEmployee;

	@Column(name = "departmentId")
	private String departmentId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "middleName")
	private String middleName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "phone")
	private String phone;

	@Column(name = "streetNumber")
	private String streetNumber;

	@Column(name = "city")
	private String city;

	@Column(name = "disctrict")
	private String disctrict;

	@Column(name = "ward")
	private String ward;

	@Column(name = "dateOfBirth")
	private Date dateOfBirth;



	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Boolean getStatusEmployee() {
		return statusEmployee;
	}

	public void setStatusEmployee(Boolean statusEmployee) {
		this.statusEmployee = statusEmployee;
	}

	public Boolean getStatusAccount() {
		return statusAccount;
	}

	public void setStatusAccount(Boolean statusAccount) {
		this.statusAccount = statusAccount;
	}

	public Long getFailNumber() {
		return failNumber;
	}

	public void setFailNumber(Long failNumber) {
		this.failNumber = failNumber;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDisctrict() {
		return disctrict;
	}

	public void setDisctrict(String disctrict) {
		this.disctrict = disctrict;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


}
