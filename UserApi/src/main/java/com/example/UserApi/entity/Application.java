package com.example.UserApi.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(	name = "application", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "nom_application") })
public class Application {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_application")
	private Long idApplication;
	
	@Column(name = "nom_application", nullable = false)
	private String applicationName;
	
	@Column(name = "date_d'ajoute")
	private Date dateAjoute;

}
