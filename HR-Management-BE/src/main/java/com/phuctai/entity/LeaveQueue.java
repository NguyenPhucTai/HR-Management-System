package com.phuctai.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "leaveQueue")
public class LeaveQueue {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "approverId")
	private String approverId;
	
	@Column(name = "dateFrom")
	private Date dateFrom;
	
	@Column(name = "dateTo")
	private Date dateTo;
	
	@Column(name = "leaveId")
	private Long leaveId;
	
	@Column(name = "hour")
	private Float hour;
	
	@Column(name = "status")
	private String status;

	public LeaveQueue() {
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

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

	public Float getHour() {
		return hour;
	}

	public void setHour(Float hour) {
		this.hour = hour;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
