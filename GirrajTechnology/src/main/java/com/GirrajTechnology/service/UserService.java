package com.GirrajTechnology.service;

import org.springframework.http.ResponseEntity;

import com.GirrajTechnology.model.User;
import com.GirrajTechnology.model.dto.UserDto;

public interface UserService {



ResponseEntity<?>  saveUser(UserDto userDto);

ResponseEntity<?>  findUserByEmail(String email);

ResponseEntity<?> findAllUsers();

boolean loginUser(String email, String password);

}
