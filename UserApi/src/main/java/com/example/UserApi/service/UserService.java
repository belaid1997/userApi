package com.example.UserApi.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.UserApi.entity.Role;
import com.example.UserApi.entity.User;





public interface UserService {
	
	
	
    
	public User saveUser(User u);
	public List<User> listUser() ;
	Optional<User> findbyId(Long id);
	public User updatAccount(User c) ;
	public void deleteAccount(Long id);
	
	public Optional<User> findUserAccount(String userName) throws SQLException, ClassNotFoundException;
	
	
	
	
	
	
	
	//User findUsersAccount(String userName) throws SQLException, ClassNotFoundException;
	//User loadUserByUsername(String username) throws UsernameNotFoundException;
	Set<Role> findRolebyId(Long id);
	
	
	
	
}
