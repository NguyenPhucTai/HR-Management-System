package com.phuctai.entity;

import javax.persistence.*;

@Entity
@Table(name = "rank")
public class Rank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "supervisorId")
	private String supervisorId;
	
	@Column(name = "userId")
	private String userId;

	public Rank() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getEmployeeId() {
		return userId;
	}

	public void setEmployeeId(String employeeId) {
		this.userId = employeeId;
	}
	
	
}
