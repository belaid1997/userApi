package com.example.UserApi.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RoleServiceImp implements RoleService   {
	
	@Autowired
	private RoleService roleservice;
	private EntityManager entityManager;
	
	

	


	private ResultSet executeQuery(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}
