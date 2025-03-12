package com.GirrajTechnology.config.security;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
            http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()
                        .requestMatchers("/index").permitAll()
                        .requestMatchers("/api/**").hasRole("ADMIN")  // Allow only ADMIN role to access `/admin/**`
                        .requestMatchers("/user/**").hasRole("USER")   // Allow only USER role to access `/user/**`
                        .requestMatchers("/**").permitAll() // Allow all other requests (e.g., public pages) without restriction
            ).formLogin(
                form -> form
                    
                    .loginProcessingUrl("/login")
                    .permitAll()  // No redirection after login
            ).logout(
                logout -> logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .permitAll()
            );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public OllamaApi ollamaApi() {
        return new OllamaApi("https://ollama-production-c6ff.up.railway.app/"); // Ensure Ollama is running here
    }

    @Bean
    public OllamaChatClient ollamaChatClient(OllamaApi ollamaApi) {
        return new OllamaChatClient(ollamaApi);
    }
}
