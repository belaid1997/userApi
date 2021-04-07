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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(	name = "roles", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "role_name") })
public class Role {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role")
    private Long roleId;
 
    @Column(name = "role_name", nullable = false)
    private String roleName;
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "role")
    private Set<User> user = new HashSet<>();
    

    
    
    
    
    
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
    
    


}
