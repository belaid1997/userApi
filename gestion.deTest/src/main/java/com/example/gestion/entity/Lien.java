package com.example.gestion.entity;

import java.net.URL;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(	name = "lien", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "url") })

public class Lien {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lien")
	private Long id;
	
	@Column(name = "url")
	private String url;
	
	 @ManyToOne
	 @JoinColumn(name="id_application")
	 private Applications application;
	 
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name="test_type")
	 private TestType testType;
	 
	 @OneToMany(mappedBy="lien", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private Set<TestRapport> test;
	 
	 @OneToOne(mappedBy="lien", fetch = FetchType.LAZY)
	    private AuthantificationTest authantificationTest;
	 
	 
	 @OneToOne(mappedBy="lien", fetch = FetchType.LAZY)
	    private LoopTest loopTest;
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 ////////////Constructor

	public Lien() {
		super();
	}

	public Lien( String url, Applications application, TestType testType, Set<TestRapport> test,
			AuthantificationTest authantificationTest) {
		super();
		
		this.url = url;
		this.application = application;
		this.testType = testType;
		this.test = test;
		this.authantificationTest = authantificationTest;
	}

	
	///////////////Getter & setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	public Long getApplication() {
		return application.getIdApplication();
	}

	public void setApplication(Applications application) {
		this.application = application;
	}

	public String getTestType() {
		return testType.getType();
	}
	public Long getTestTypeid() {
		return testType.getId();
	}

	public void setTestType(TestType testType) {
		this.testType = testType;
	}

	public Set<TestRapport> getTest() {
		return test;
	}

	public void setTest(Set<TestRapport> test) {
		this.test = test;
	}

	public AuthantificationTest getAuthantificationTest() {
		return authantificationTest;
	}

	public void setAuthantificationTest(AuthantificationTest authantificationTest) {
		this.authantificationTest = authantificationTest;
	}

	public LoopTest getLoopTest() {
		return loopTest;
	}

	public void setLoopTest(LoopTest loopTest) {
		this.loopTest = loopTest;
	}

	 
	

	 
	 
	 
	 
	
	

}
