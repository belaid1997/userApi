package com.example.UserApi.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserApi.entity.Role;
import com.example.UserApi.entity.User;
import com.example.UserApi.repository.RoleRepository;
import com.example.UserApi.service.UserService;



@RestController
@ResponseBody
public class UserController {
	
	@Autowired
	private UserService userRepository;
	private EntityManager entityManager;
	private RoleRepository roleRepository;
	
	
	
	@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/user",method = RequestMethod.POST)
	public User saveUser(@RequestBody User c) {
		return userRepository.saveUser(c);
	}
    
    
   // @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
   	public List<User> listUser() {
   		return userRepository.listUser();
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
	public Optional<User> findbyId(@PathVariable("id") Long id ) {
		Optional<User> User= this.userRepository.findbyId(id);
		return User; 
	}
    @RequestMapping(value = "/user/{id}", produces = "application/json",method = RequestMethod.PUT)
	public User updatUser(@RequestBody User c,@PathVariable("id") Long id) {
    	c.setUserId(id);
		return userRepository.updatAccount(c);
	}
    
    
    
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody void deleteUser(@PathVariable Long id ) {
		this.userRepository.deleteAccount(id);
		 
	}
    
    @RequestMapping(value = "/user/account/{userName}",method = RequestMethod.GET)
    public Optional<User> findUserAccount(@PathVariable("userName") String userName ) throws ClassNotFoundException, SQLException {
		Optional<User> User= this.userRepository.findUserAccount(userName);
		return User; }
		
	/*@RequestMapping(value = "/user/role/{id}",method = RequestMethod.GET)
	public List<String> getRoleNames(@PathVariable("id")Long id) {
		List<String> role=entityManager.getRoleNames(id);
		return role;
	
	}*/	
   
    @RequestMapping(value = "/user/role/{id}",method = RequestMethod.GET)
	public Set<Role> findRolebyId(@PathVariable("id") Long id ) {
		/*Optional<User> User= this.userRepository.findbyId(id);
		User rm= User.get(); */
		return userRepository.findRolebyId(id);
	}
}
