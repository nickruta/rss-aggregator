package com.nickruta.ra.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nickruta.ra.entity.Blog;
import com.nickruta.ra.entity.Role;
import com.nickruta.ra.entity.User;
import com.nickruta.ra.repository.BlogRepository;
import com.nickruta.ra.repository.ItemRepository;
import com.nickruta.ra.repository.RoleRepository;
import com.nickruta.ra.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

		@Autowired
		private RoleRepository roleRepository;
		
		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private ItemRepository itemRepository;
		
		@Autowired
		private BlogRepository blogRepository;
		
		@PostConstruct
		public void init() {
			if(roleRepository.findByName("ROLE_ADMIN")== null) {
				
			Role roleUser = new Role();
			roleUser.setName("ROLE_USER");
			roleRepository.save(roleUser);
			
			Role roleAdmin = new Role();
			roleAdmin.setName("ROLE_ADMIN");
			roleRepository.save(roleAdmin);
			
			User userAdmin = new User();
			userAdmin.setEnabled(true);
			userAdmin.setName("admin");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			userAdmin.setPassword(encoder.encode("admin"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleAdmin);
			roles.add(roleUser);
			userAdmin.setRoles(roles);
			userRepository.save(userAdmin);
			
			Blog blogJavavids = new Blog();
			blogJavavids.setName("JavaVids");
			blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
			blogJavavids.setUser(userAdmin);
			blogRepository.save(blogJavavids);

			// two test items
//			Item item1 = new Item();
//			item1.setBlog(blogJavavids);
//			item1.setTitle("first");
//			item1.setLink("http://www.javavids.com");
//			item1.setPublishedDate(new Date());
//			itemRepository.save(item1);
//			
//			Item item2 = new Item();
//			item2.setBlog(blogJavavids);
//			item2.setTitle("second");
//			item2.setLink("http://www.javavids.com");
//			item2.setPublishedDate(new Date());	
//			itemRepository.save(item2);
			}
		}			
}
