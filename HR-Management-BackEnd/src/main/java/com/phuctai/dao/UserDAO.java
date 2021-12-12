package com.phuctai.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phuctai.entity.Account;

@Repository
public interface UserDAO extends JpaRepository<Account, Long>{

	Optional<Account> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
	@Query("FROM Account WHERE username = ?1 and password = ?2")
    List<Account> getByUsernameAndPassword(String username, String password);
}
