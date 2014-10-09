package com.nickruta.ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nickruta.ra.entity.Blog;
import com.nickruta.ra.entity.User;
import com.nickruta.ra.repository.BlogRepository;
import com.nickruta.ra.repository.UserRepository;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;

	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		
	}
	
	

}
