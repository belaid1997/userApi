package com.example.UserApi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
@Table(	name = "user", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "user_name"),
			@UniqueConstraint(columnNames = "email") })
public class User {
	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long userId;
 
    @Column(name = "User_Name", nullable = false)
    private String username;
    
    @Column(name = "email", nullable = false)
    private String email;
 
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "telephone")
    private int telephone;
    
    
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "user_role",joinColumns = { @JoinColumn(name = "id_user") },
            inverseJoinColumns = { @JoinColumn(name = "id_role") })
    private Set<Role> role = new HashSet<>();
    
    
    
    
    
    
    
    
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	public User(String userName, String email, String password, String nom, String prenom, int telephone,
			Set<Role> role) {
		super();
		this.username = userName;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.role = role;
	}
	public User(String userName, String email, String password, String nom, String prenom, int telephone) {
		super();
		
		this.username = userName;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}
	public User(User u) {
		super();
		this.userId = u.userId;
		this.username = u.username;
		this.email = u.email;
		this.password = u.password;
		this.nom = u.nom;
		this.prenom = u.prenom;
		this.telephone = u.telephone;
	}
	
	
	
	
	
	public User() {
		super();
	}
	public User(String userName, String email, String password) {
		super();
		this.username = userName;
		this.email = email;
		this.password = password;
	}





	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
    
    
    
    
	
	

}
