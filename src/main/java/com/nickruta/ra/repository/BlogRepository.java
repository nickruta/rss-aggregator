package com.nickruta.ra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nickruta.ra.entity.Blog;
import com.nickruta.ra.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	
	List<Blog>findByUser(User user); 

}
