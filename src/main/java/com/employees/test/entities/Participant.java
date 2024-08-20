package com.employees.test.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;

@Entity
public class Participant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;

	@Column(name="name")
	private String name;
	
	
	@Email
	@Column(name="email",unique = true)
	private String email;
	
	
	@ManyToMany(mappedBy="participants")
	private List<Meeting> meetings; 
	
	
	@Column(name="created_by")
	private String createdby;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name="updated_by")
	private String updatedby;
	


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Timestamp create_date;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to EmployeePhone
     
	 
	
	
	
	public Participant() {
	}

	

}