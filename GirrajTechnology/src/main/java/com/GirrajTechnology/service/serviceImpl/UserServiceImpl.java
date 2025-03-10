package com.GirrajTechnology.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.GirrajTechnology.model.Role;
import com.GirrajTechnology.model.User;
import com.GirrajTechnology.model.dto.UserDto;
import com.GirrajTechnology.repository.RoleRepository;
import com.GirrajTechnology.repository.UserRepository;
import com.GirrajTechnology.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	 private UserRepository userRepository;
	    private RoleRepository roleRepository;
	    private PasswordEncoder passwordEncoder;

	    @Autowired
	    CustomUserDetailsService coustomUserDetailService;
	    
	    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
	     
			this.userRepository = userRepository;
	        this.roleRepository = roleRepository;
	        this.passwordEncoder = passwordEncoder;
	    }

	    @Override
	    public ResponseEntity<?> saveUser(UserDto userDto) {
	        User user = new User();
	        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
	        user.setEmail(userDto.getEmail());
	        //encrypt the password using spring security
	        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

	        Role role = roleRepository.findByName("ROLE_ADMIN");
	        if (role == null) {
	            role = checkRoleExist();
	        }
	        user.setRoles(List.of(role));
	        userRepository.save(user);
			return null;
	    }

	    private Role checkRoleExist() {
	        Role role = new Role();
	        role.setName("ROLE_ADMIN");
	        return roleRepository.save(role);
	    }

	    @Override
	    public ResponseEntity<?> findUserByEmail(String email) {
	        return ResponseEntity.ok(userRepository.findByEmail(email));
	    }

	    @Override
	    public ResponseEntity<?> findAllUsers() {
	        List<User> users = userRepository.findAll();
	        return ResponseEntity.ok(users.stream().map((user) -> convertEntityToDto(user))
	                .collect(Collectors.toList()));
	    }

	    private UserDto convertEntityToDto(User user) {
	        UserDto userDto = new UserDto();
	        String[] name = user.getName().split(" ");
	        userDto.setFirstName(name[0]);
	        userDto.setLastName(name[1]);
	        userDto.setEmail(user.getEmail());
	        return userDto;
	    }

	    @Override
	    public boolean loginUser(String username, String password) {
	        User user = userRepository.findByEmail(username);
	        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
	            return true;
	        }
	        return false;
	    }
	  	}
