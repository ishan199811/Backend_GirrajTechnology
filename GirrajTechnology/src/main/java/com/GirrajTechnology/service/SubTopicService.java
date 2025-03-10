package com.GirrajTechnology.service;

import org.springframework.http.ResponseEntity;

public interface SubTopicService {

	ResponseEntity<?> getSubTopicByTpoicName(String name);

}
