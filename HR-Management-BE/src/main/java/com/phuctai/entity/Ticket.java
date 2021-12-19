package com.phuctai.entity;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "typeId")
	private Long typeId;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTicketTypeId() {
		return typeId;
	}

	public void setTicketTypeId(Long ticketTypeId) {
		this.typeId = ticketTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
