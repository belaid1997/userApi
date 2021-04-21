package com.example.gestion.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(	name = "test_type", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "test_type") })
public class TestType {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private Long id;
	
	@Column(name = "test_type", nullable = false)
	private String type;
	
	
	
	
	@OneToMany(mappedBy="testType")
    private Set<Lien> lien;



	
	

	public TestType() {
		super();
	}






	public TestType( String type, Set<Lien> lien) {
		super();
		
		this.type = type;
		this.lien = lien;
	}






	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public String getType() {
		return type;
	}






	public void setType(String type) {
		this.type = type;
	}






	public Set<Lien> getLien() {
		return lien;
	}






	public void setLien(Set<Lien> lien) {
		this.lien = lien;
	}
	
	
	
	
	

}
