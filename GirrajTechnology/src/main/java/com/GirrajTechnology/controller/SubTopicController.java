package com.GirrajTechnology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GirrajTechnology.service.SubTopicService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class SubTopicController {
	
	@Autowired
	SubTopicService subTopicService;
	
	
	@GetMapping("/getSubtopicByTopicName")
	ResponseEntity<?> getSubTopicByTopicName(@RequestParam("name") String name){
		return ResponseEntity.ok(subTopicService.getSubTopicByTpoicName(name));
		
		
	}

}
