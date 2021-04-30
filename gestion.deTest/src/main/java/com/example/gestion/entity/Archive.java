package com.example.gestion.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(	name = "archive")
public class Archive {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private Long id;
	@Column(name = "nom_application", nullable = false)
	private String applicationName;
	@Column(name = "date_ajoute")
	private Date dateAjoute;
	@Column(name = "url")
	private String url;
	@JoinColumn(name="test_type")
	 private String testType;
	@Column(name = "status_test")
	private String status;
	@Column(name = "date_test")
	@Temporal(TemporalType.DATE)
	private java.util.Date datetest;
	@Column(name = "time_test")
	private Time time_test;
	
	
	
	
	////////constructore
	public Archive() {
		super();
	}




	public Archive(String applicationName, Date dateAjoute, String url, String testType, String status,
			Date date_test,Time t) {
		super();
		this.applicationName = applicationName;
		this.dateAjoute = dateAjoute;
		this.url = url;
		this.testType = testType;
		this.status = status;
		this.datetest = date_test;
		this.time_test=t;
	}


//////////geter seter

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getApplicationName() {
		return applicationName;
	}




	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}




	public Date getDateAjoute() {
		return dateAjoute;
	}




	public void setDateAjoute(Date dateAjoute) {
		this.dateAjoute = dateAjoute;
	}




	public String getUrl() {
		return url;
	}




	public void setUrl(String url) {
		this.url = url;
	}




	public String getTestType() {
		return testType;
	}




	public void setTestType(String testType) {
		this.testType = testType;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public java.util.Date getDatetest() {
		return datetest;
	}




	public void setDate_test(Date date_test) {
		this.datetest = date_test;
	}




	public Time getTime_test() {
		return time_test;
	}




	public void setTime_test(Time time_test) {
		this.time_test = time_test;
	}
	
	
	
	
	
	
	
	
	
	
	

}
