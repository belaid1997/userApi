package com.example.UserApi.service;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserApi.entity.Role;
import com.example.UserApi.entity.User;
import com.example.UserApi.repository.UserRepository;
import com.example.UserApi.security.service.UserDetailsImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



@Service
public class UserServiceImp implements UserService,UserDetailsService {
	
	
	@Autowired
    private UserRepository userRepository;
	
	
	@Override
	public User saveUser(User u) {
		return userRepository.save(u);
		
	}


	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	@Override
	public Optional<User> findbyId(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}


	@Override
	public User updatAccount(User c) {
		// TODO Auto-generated method stub
		return userRepository.save(c);
	}


	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
		
	}


	
	@Override
	public Optional<User> findUserAccount(String userName)throws UsernameNotFoundException {
		   return userRepository.findByUsername(userName);
	    }
	
	
	@Override
	public Set<Role> findRolebyId(Long id) {
		// TODO Auto-generated method stub
		Optional<User> User= this.userRepository.findById(id);
		User rm= User.get();
		return rm.getRole();
	}


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}


	
	
	/*
	@Override
	public User findUsersAccount(String userName) throws SQLException, ClassNotFoundException {
		   try {
			   // create a mysql database connection
			      String myDriver = "org.gjt.mm.mysql.Driver";
			      String myUrl = "jdbc:mysql://localhost/test";
			      Class.forName(myDriver);
			      Connection conn = DriverManager.getConnection(myUrl, "root", "");
			      
			      Statement st = conn.createStatement();
			      String query = "SELECT * from";

	        } catch (NoResultException e) {
	            return null;
	        }*/
	    
	
	
	

}
