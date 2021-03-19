package com.example.UserApi.repository;



import java.util.Optional;

import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserApi.entity.User;





public interface UserRepository extends JpaRepository<User, Long>{

	
	Optional<User> findByUserName(String username);



	
	
	

	

	

}
