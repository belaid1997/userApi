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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(	name = "lien", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "url") })
public class Lien {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lien")
	private Long id;
	
	@Column(name = "url", nullable = false)
	private String url;
	
	 @ManyToOne
	 @JoinColumn(name="id_application", nullable=false)
	 private Applications application;
	 
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name="test_type", nullable=false)
	 private TestType testType;
	 
	 @OneToMany(mappedBy="lien", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private Set<Test> test;
	 
	 @OneToMany(mappedBy="lien", fetch = FetchType.LAZY)
	    private Set<AuthantificationTest> authantificationTest;
	 
	 
	 @OneToMany(mappedBy="lien", fetch = FetchType.LAZY)
	    private Set<LoopTest> loopTest;
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 ////////////Constructor

	public Lien() {
		super();
	}

	public Lien( String url, Applications application, TestType testType, Set<Test> test,
			Set<AuthantificationTest> authantificationTest) {
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

	public void setTestType(TestType testType) {
		this.testType = testType;
	}

	public Set<Test> getTest() {
		return test;
	}

	public void setTest(Set<Test> test) {
		this.test = test;
	}

	public Set<AuthantificationTest> getAuthantificationTest() {
		return authantificationTest;
	}

	public void setAuthantificationTest(Set<AuthantificationTest> authantificationTest) {
		this.authantificationTest = authantificationTest;
	}

	public Set<LoopTest> getLoopTest() {
		return loopTest;
	}

	public void setLoopTest(Set<LoopTest> loopTest) {
		this.loopTest = loopTest;
	}

	 
	

	 
	 
	 
	 
	
	

}
