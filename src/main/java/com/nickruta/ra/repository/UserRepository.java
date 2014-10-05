package com.nickruta.ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nickruta.ra.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
