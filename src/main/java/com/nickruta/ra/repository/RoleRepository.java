package com.nickruta.ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nickruta.ra.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);

}
