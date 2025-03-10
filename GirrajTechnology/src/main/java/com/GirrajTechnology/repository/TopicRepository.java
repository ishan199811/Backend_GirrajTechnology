package com.GirrajTechnology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.GirrajTechnology.model.Topic;

public interface TopicRepository extends JpaRepository<Topic,Long > ,PagingAndSortingRepository<Topic, Long>{

	List<Topic> findByCourseName(String courseName);

	

	Topic findByTopicName(String name);

}
