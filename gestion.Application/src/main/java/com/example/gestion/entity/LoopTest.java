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

@Entity
@Table(	name = "loop_test")
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
	
	
	
	
	
	

}
