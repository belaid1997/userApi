package com.example.gestion.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(	name = "applications", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "nom_application") })
public class Applications {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_application")
	private Long idApplication;
	
	@Column(name = "nom_application", nullable = false)
	private String applicationName;
	
	@Column(name = "date_ajoute")
	private Date dateAjoute;
	
	@OneToMany(mappedBy="application")
    private Set<Lien> lien;
	
	
	
	
	
	
	

	public Applications() {
		super();
	}

	public Applications( String applicationName, Date dateAjoute, Set<Lien> lien) {
		super();
		
		this.applicationName = applicationName;
		this.dateAjoute = dateAjoute;
		this.lien = lien;
	}

	public Long getIdApplication() {
		return idApplication;
	}

	public void setIdApplication(Long idApplication) {
		this.idApplication = idApplication;
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

	public Set<Lien> getLien() {
		return lien;
	}

	public void setLien(Set<Lien> lien) {
		this.lien = lien;
	}

}
