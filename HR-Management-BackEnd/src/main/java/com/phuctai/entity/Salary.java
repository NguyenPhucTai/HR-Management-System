package com.phuctai.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salary")
public class Salary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true, length = 20)
	private String employeeId;
	
	@Column()
	private Float salary;
	
	@Column()
	private Long month;
	
	@Column()
	private Long year;
	
	@Column()
	private Long quarter;
	
	@Column()
	private Date date;
	
}
