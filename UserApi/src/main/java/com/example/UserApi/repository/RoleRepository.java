package com.example.UserApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserApi.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{

	

	
}
