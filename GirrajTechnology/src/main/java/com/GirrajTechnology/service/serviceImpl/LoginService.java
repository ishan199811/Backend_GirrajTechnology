package com.GirrajTechnology.service.serviceImpl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public boolean loginUser(String username, String password) {
        try {
            // Create authentication token
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            // Check if authentication was successful
            if (authentication.isAuthenticated()) {
                // Extract roles (authorities) from the authenticated user
                for (GrantedAuthority authority : authentication.getAuthorities()) {
                    // Check if the user has the required role (e.g., "ROLE_ADMIN")
                    if ("ROLE_ADMIN".equals(authority.getAuthority())) {
                        return true;  // User is authenticated and has the required role
                    }
                }
            }
        } catch (Exception e) {
            // Handle authentication failure (e.g., invalid credentials)
            e.printStackTrace();
        }
        return false;  // Failed login or insufficient role
    }
}
