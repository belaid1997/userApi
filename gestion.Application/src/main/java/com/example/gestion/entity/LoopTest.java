package com.example.gestion.entity;

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
@Table(	name = "loop_test",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "id_element") })
public class LoopTest {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_loop")
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_element", referencedColumnName = "id_element")
    private Elements element;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_lien", nullable=false)
     private Lien lien;

	
	
	
	
	public LoopTest() {
		super();
	}





	public LoopTest(Elements element) {
		super();
		this.element = element;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public Elements getElement() {
		return element;
	}





	public void setElement(Elements element) {
		this.element = element;
	}





	public Long getLien() {
		return lien.getId();
	}





	public void setLien(Lien lien) {
		this.lien = lien;
	}
	
	
	
	
	
	
	

}
