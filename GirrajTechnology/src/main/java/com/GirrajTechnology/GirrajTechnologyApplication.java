package com.GirrajTechnology;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.GirrajTechnology.model.mongodb.Song;
import com.GirrajTechnology.repository.SongRepository;

@SpringBootApplication(scanBasePackages = "com.GirrajTechnology")
public class GirrajTechnologyApplication {

	public static void main(String[] args) {
		
	   
				    
		
		SpringApplication.run(GirrajTechnologyApplication.class, args);
		
		
	}

}
