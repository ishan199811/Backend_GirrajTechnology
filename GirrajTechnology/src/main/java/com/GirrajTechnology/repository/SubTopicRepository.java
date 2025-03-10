package com.GirrajTechnology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GirrajTechnology.model.SubTopic;

public interface SubTopicRepository extends JpaRepository< SubTopic , Long>{

	List<SubTopic> findByTopicName(String name);

}
