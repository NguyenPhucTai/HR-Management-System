package com.phuctai.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticketQueue")
public class TicketQueue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column()
	private Date timeOpen;
	
	@Column()
	private Date timeClose;
	
	@Column()
	private String createrId;
	
	@Column()
	private String approverId;
	
	@Column()
	private String resolverId;
	
	@Column()
	private String ticketId;
	
	@Column()
	private String title;
	
	@Column()
	private String comment;
	
	@Column()
	private String priority;
	
	@Column()
	private String status;
	
}
