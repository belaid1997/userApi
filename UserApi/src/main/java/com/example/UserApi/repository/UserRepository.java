package com.example.UserApi.repository;



import java.util.Optional;

import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.example.UserApi.entity.User;




@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
	Optional<User> findByUsername(String username)throws UsernameNotFoundException;
	
	public boolean existsByUsername(String userName);
	Boolean existsByEmail(String email);



	
	
	

	

	

}
