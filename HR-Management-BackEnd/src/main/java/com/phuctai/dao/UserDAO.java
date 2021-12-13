package com.phuctai.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phuctai.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);

	@Query("FROM User WHERE username = ?1 and password = ?2")
	List<User> getByUsernameAndPassword(String username, String password);
}
