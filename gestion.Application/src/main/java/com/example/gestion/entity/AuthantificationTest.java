package com.example.gestion.entity;

import java.net.URL;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(	name = "authantification_test", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "id_lien") })
public class AuthantificationTest {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_authantification")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_lien", nullable=false)
 private Lien lien;
	
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_username", referencedColumnName = "id_element")
    private Elements username;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_password", referencedColumnName = "id_element")
    private Elements password;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_botton", referencedColumnName = "id_element")
    private Elements botton;
	private String siterepense;
	
	/*
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_username", nullable=false)
 private Elements username;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_password", nullable=false)
 private Elements password;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_botton", nullable=false)
       private Elements button;

	*/
	
	

	public AuthantificationTest() {
		super();
	}

	public AuthantificationTest(Lien lien, Elements username, Elements password, Elements botton, String siterepense) {
		super();
		this.lien = lien;
		this.username = username;
		this.password = password;
		this.botton = botton;
		this.siterepense = siterepense;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLien() {
		return lien.getId();
	}

	public void setLien(Lien lien) {
		this.lien = lien;
	}

	public Elements getUsername() {
		return username;
	}

	public void setUsername(Elements username) {
		this.username = username;
	}

	public Elements getPassword() {
		return password;
	}

	public void setPassword(Elements password) {
		this.password = password;
	}

	public Elements getBotton() {
		return botton;
	}

	public void setBotton(Elements botton) {
		this.botton = botton;
	}

	public String getSiterepense() {
		return siterepense;
	}

	public void setSiterepense(String siterepense) {
		this.siterepense = siterepense;
	}
	
	
	
	
	
	
	
	
	
	
	

}
