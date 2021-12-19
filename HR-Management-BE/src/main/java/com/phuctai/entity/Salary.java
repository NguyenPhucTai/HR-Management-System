package com.phuctai.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "salary")
public class Salary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "salary")
	private Float salary;
	
	@Column(name = "month")
	private Long month;
	
	@Column(name = "year")
	private Long year;
	
	@Column(name = "quarter")
	private Long quarter;
	
	@Column(name = "date")
	private Date date;

	public Salary() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return userId;
	}

	public void setEmployeeId(String employeeId) {
		this.userId = employeeId;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Long getQuarter() {
		return quarter;
	}

	public void setQuarter(Long quarter) {
		this.quarter = quarter;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
