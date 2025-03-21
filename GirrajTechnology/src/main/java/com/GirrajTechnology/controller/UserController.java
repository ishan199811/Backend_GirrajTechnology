package com.GirrajTechnology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GirrajTechnology.model.dto.UserDto;
import com.GirrajTechnology.service.UserService;
import com.GirrajTechnology.service.serviceImpl.LoginService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "https://girrajtechnology.com")  // Apply CORS to this controller

@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserService userService;
	private  LoginService loginService;
	
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

   

    @Autowired
    public UserController(LoginService loginService) {
        this.loginService = loginService;
    }


    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public ResponseEntity<?> registration(@Valid @RequestBody UserDto userDto) {
    	ResponseEntity.ok(userService.findUserByEmail(userDto.getEmail()));
          return ResponseEntity.ok(userService.saveUser(userDto));
    }

    // handler method to handle list of users
    @GetMapping("/users")
    public ResponseEntity<?> users(Model model) {
      return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = loginService.loginUser(username, password);

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}