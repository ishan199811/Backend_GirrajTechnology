package com.GirrajTechnology.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.GirrajTechnology.repository.SubTopicRepository;
import com.GirrajTechnology.service.SubTopicService;


@Service
public class SubTopicServiceImpl implements SubTopicService {
	
	@Autowired
	SubTopicRepository subTopicRepository;

	@Override
	public ResponseEntity<?> getSubTopicByTpoicName(String name) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(subTopicRepository.findByTopicName(name));
	}

}
