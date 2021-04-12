package com.example.gestion.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(	name = "element")
public class Elements {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_element")
	private Long id;
	
	@Column(name = "id_locator")
	private String idlocator;
	
	@Column(name = "name_locator")
	private String namelocator;
	
	@Column(name = "tagename_locator")
	private String tagenamelocator;
	
	@Column(name = "css_selectore")
	private String cssSelector;
	
	@Column(name = "xpath")
	private String xpath;
	
	@Column(name = "value")
	private String value;
	
	 @OneToOne(mappedBy = "username")
	    private AuthantificationTest authantificationusername;
	 
	 @OneToOne(mappedBy = "password")
	    private AuthantificationTest authantificationpassword;
	 
	 @OneToOne(mappedBy = "botton")
	    private AuthantificationTest authantificationbotton;
	 
	 @OneToOne(mappedBy = "element")
	    private LoopTest loop;

	 
	 
	 
	 
	 
	 
	 
	public Elements() {
		super();
	}

	public Elements(String idlocator, String namelocator, String tagenamelocator, String cssSelector, String xpath,
			String value, AuthantificationTest authantificationusername, AuthantificationTest authantificationpassword,
			AuthantificationTest authantificationbotton, LoopTest loop) {
		super();
		this.idlocator = idlocator;
		this.namelocator = namelocator;
		this.tagenamelocator = tagenamelocator;
		this.cssSelector = cssSelector;
		this.xpath = xpath;
		this.value = value;
		this.authantificationusername = authantificationusername;
		this.authantificationpassword = authantificationpassword;
		this.authantificationbotton = authantificationbotton;
		this.loop = loop;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdlocator() {
		return idlocator;
	}

	public void setIdlocator(String idlocator) {
		this.idlocator = idlocator;
	}

	public String getNamelocator() {
		return namelocator;
	}

	public void setNamelocator(String namelocator) {
		this.namelocator = namelocator;
	}

	public String getTagenamelocator() {
		return tagenamelocator;
	}

	public void setTagenamelocator(String tagenamelocator) {
		this.tagenamelocator = tagenamelocator;
	}

	public String getCssSelector() {
		return cssSelector;
	}

	public void setCssSelector(String cssSelector) {
		this.cssSelector = cssSelector;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

	public void setAuthantificationusername(AuthantificationTest authantificationusername) {
		this.authantificationusername = authantificationusername;
	}

	

	public void setAuthantificationpassword(AuthantificationTest authantificationpassword) {
		this.authantificationpassword = authantificationpassword;
	}

	

	public void setAuthantificationbotton(AuthantificationTest authantificationbotton) {
		this.authantificationbotton = authantificationbotton;
	}

	

	public void setLoop(LoopTest loop) {
		this.loop = loop;
	}
	

	
	
	
	/*
	@OneToOne(mappedBy="username", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<AuthantificationTest> authantificationusername;
	
	@OneToOne(mappedBy="password", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<AuthantificationTest> authantificationpassword;
	
	@OneToOne(mappedBy="button", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<AuthantificationTest> authantificationbotton;
	
	*/
	 
	 
	

}
