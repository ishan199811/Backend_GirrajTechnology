package com.GirrajTechnology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GirrajTechnology.model.Courses;
import com.GirrajTechnology.model.Topic;
import com.GirrajTechnology.service.TopicService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@GetMapping("/getTopicById")
	ResponseEntity<?> getTopicById(@RequestParam("id") String name ){
		
		return ResponseEntity.ok(topicService.getTopicByCourseName(name));
		
	}
	
	@GetMapping("/getAllTopic")
	ResponseEntity<?> getAllTopic(){
		
		return ResponseEntity.ok(topicService.getAllTopic());
		
	}

	
	@GetMapping("/getTopicByCourseName")
	ResponseEntity<?> getTopicByCourseName(@RequestParam("name") String name){
		
		return ResponseEntity.ok(topicService.getTopicByCourseName(name));
		
	}
	
	@GetMapping("/getTopicNameByCourseName")
	ResponseEntity<?> getTopicNameByCourseName(@RequestParam("name") String name){
		
		return ResponseEntity.ok(topicService.getTopicNameByCourseName(name));
		
	}
	@GetMapping("/getTopicByCourse")
	ResponseEntity<?> getTopicByCourse(@RequestParam("name") String name){
		
		return ResponseEntity.ok(topicService.getTopicByCourse(name));
		
	}
	
	@GetMapping("/getTopicByTopicName")
	ResponseEntity<?> getTopicByTopicName(@RequestParam("name") String name){
		
		return ResponseEntity.ok(topicService.getTopicByTopicName(name));
		
	}
	
	@PostMapping("/saveTopic")
	ResponseEntity<?> saveTopic(@RequestBody Topic topic){
		System.out.println("-------Controller--------"+ topic.getCourseName());
		return ResponseEntity.ok(topicService.saveTopic(topic));
		
	}
	
	@PutMapping("/editTopic")
	public ResponseEntity<?> editTopic(@RequestBody Topic updatedTopic) {
		Topic existingTopic = topicService.getTopicById(updatedTopic.getId());
		 if (existingTopic != null) {
	            // Update only the fields provided in updatedCourse
	            if (updatedTopic.getCourseName() != null) {
	                existingTopic.setTopicName(updatedTopic.getTopicName());
	            }
	            if (updatedTopic.getCourseName() != null) {
	                existingTopic.setCourseName(updatedTopic.getCourseName());
	            }
	            if (updatedTopic.getSubTopic() != null) {
	                existingTopic.setSubTopic(updatedTopic.getSubTopic());
	            }
	            // Add more fields to update as required

	            topicService.saveTopic(existingTopic); // Save updated topic
	            return ResponseEntity.ok("Topic updated successfully");
	        } else {
	            return ResponseEntity.badRequest().body("Course not found");
	        }
		
	  //  System.out.println("-------Controller--------" + updatedTopic.getCourseName());
	   
	    
	}

	
}
