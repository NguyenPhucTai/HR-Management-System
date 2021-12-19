package com.phuctai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phuctai.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findRoleByName(String name);
	Role findByName(String name);

}
