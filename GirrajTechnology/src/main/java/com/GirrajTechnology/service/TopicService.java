package com.GirrajTechnology.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.GirrajTechnology.model.Topic;

public interface TopicService {

	List<Topic> getTopicByCourseName(String name);
	List<Topic> getAllTopic();

     ResponseEntity<?> saveTopic(Topic topic);



	ResponseEntity<?> getTopicNameByCourseName(String name);

	ResponseEntity<?> getTopicByTopicName(String name);

	Object getTopicByCourse(String name);

	Topic getTopicById(Long id);
	

}
