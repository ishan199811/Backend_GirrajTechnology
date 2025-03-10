package com.GirrajTechnology.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.GirrajTechnology.model.Courses;
import com.GirrajTechnology.model.Topic;
import com.GirrajTechnology.repository.CoursesRepository;
import com.GirrajTechnology.repository.SubTopicRepository;
import com.GirrajTechnology.repository.TopicRepository;
import com.GirrajTechnology.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService{
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	CoursesRepository coursesRepository;
	
	@Autowired
	SubTopicRepository subTopicRepository;
	
	@Override
	public
	List<Topic> getTopicByCourseName(String name){
		
		List<Topic> topicList=topicRepository.findByCourseName(name);
		
		return topicList;
		
	}

	@Override
	public List<Topic> getAllTopic() {
		// TODO Auto-generated method stub
		return topicRepository.findAll();
	}

	@Override
	public ResponseEntity<?> saveTopic(Topic topic) {
		
		// First, find or create a Courses entity
	    Courses course = coursesRepository.findByCourseName(topic.getCourseName()); // Assuming Name = 1 exists
	    
	    if (course == null) {
	        // Create and save a new course if it does not exist
	       return ResponseEntity.ok("Course data cannot null");
	    }
	    topic.setCoursesId(course);
	    if (topic.getCoursesId() == null) {
	        throw new IllegalArgumentException("Courses must be set before saving Topic!");
	    }
	//	Courses courses=coursesRepository.getById(course.getId());
		System.out.println("------Service---------"+ course.getCourseName());
		
		System.out.println("------Service---------"+ topic.getCoursesId());
	topicRepository.save(topic);
	
	
		
		
		return ResponseEntity.ok(course);
	}

	@Override
	public ResponseEntity<?> getTopicNameByCourseName(String name) {
		// TODO Auto-generated method stub
		Set<String> nameList=new HashSet<>();
	List<Topic> listTopic=topicRepository.findByCourseName(name);
	listTopic.forEach(e -> nameList.add(e.getTopicName()) );
		return ResponseEntity.ok(nameList);
	}

	@Override
	public ResponseEntity<?> getTopicByTopicName(String name) {
		// TODO Auto-generated method stub
		
		Topic topic=topicRepository.findByTopicName(name);
		return ResponseEntity.ok(topic);
	}

	@Override
	public Object getTopicByCourse(String name) {
		Courses course=coursesRepository.findByCourseName(name);
		List<Topic> listtopic=new ArrayList<>();
		listtopic.addAll(course.getTopic());
		return ResponseEntity.ok(listtopic);
	}

	@Override
	public Topic getTopicById(Long id) {
		// TODO Auto-generated method stub
		
		Optional<Topic> topic=topicRepository.findById(id);
		
		
		return topic.orElseThrow(() -> new RuntimeException("Course not found for ID: " + id));
	}

}
