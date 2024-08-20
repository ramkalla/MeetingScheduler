package com.employees.test.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Meeting")
//@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Meeting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;

	
	@Column(name="Title")
	private String Title;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp  startTime;

	
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp endTime;

	
	@Column(name="created_by")
	private String createdBy;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Timestamp updatedDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Timestamp create_date;
	
	

	//bi-directional many-to-one association to EmployeePhone
     

	@ManyToMany
	@JoinTable(
	name="meeting_participants",joinColumns=@JoinColumn(name="meeting_id"),
	inverseJoinColumns=@JoinColumn(name="participant_id"))
    private List<Participant> participants;
	
	
	public Meeting() {
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}


	public Date getCreate_date() {
		return create_date;
	}


	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}


	public List<Participant> getParticipants() {
		return participants;
	}


	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	

}