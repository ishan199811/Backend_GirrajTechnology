package com.GirrajTechnology.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.GirrajTechnology.model.User;

public interface UserRepository extends JpaRepository<User , Long>{

	 User findByEmail(String email);

}
