package com.example.gestion.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(	name = "test")
public class Test {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_test")
	private Long id;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name="id_lien", nullable=false)
	 private Lien lien;
	
	
	
	@Column(name = "status_test")
	private String status;
	
	@Column(name = "date_test")
	private Date date_test;

	public Test() {
		super();
	}

	public Test(Lien lien, String status, Date date_test) {
		super();
		this.lien = lien;
		this.status = status;
		this.date_test = date_test;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate_test() {
		return date_test;
	}

	public void setDate_test(Date date_test) {
		this.date_test = date_test;
	}
	
	
	
	

}
