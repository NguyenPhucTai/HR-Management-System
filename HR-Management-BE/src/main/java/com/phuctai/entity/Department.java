package com.phuctai.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "departmentId", unique = true, length = 20)
	private String departmentId;
	
	@Column(name = "name", unique = true)
	private String name;

	public Department() {
		super();
	}

	public Department(Long id, String departmentId, String name) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
