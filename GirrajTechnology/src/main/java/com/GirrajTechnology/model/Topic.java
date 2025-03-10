package com.GirrajTechnology.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Topic {

	 private static final long serialVersionUID = 1L;
	
	public List<SubTopic> getTopic() {
		return topic;
	}

	public void setTopic(List<SubTopic> topic) {
		this.topic = topic;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTpoicDetail() {
		return tpoicDetail;
	}

	public void setTpoicDetail(String tpoicDetail) {
		this.tpoicDetail = tpoicDetail;
	}

	public String getSubTopic() {
		return subTopic;
	}

	public void setSubTopic(String subTopic) {
		this.subTopic = subTopic;
	}

	public String getSubTopicDetail() {
		return subTopicDetail;
	}

	public void setSubTopicDetail(String subTopicDetail) {
		this.subTopicDetail = subTopicDetail;
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
      Long id;
	
	String topicName;
	String tpoicDetail;
	String subTopic;

	String subTopicDetail;
	String courseName;
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "courses_id", nullable = false) 
	Courses coursesId;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topicId", cascade = CascadeType.ALL)
	private List<SubTopic> topic = new ArrayList<SubTopic>();

	public Courses getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(Courses coursesId) {
		this.coursesId = coursesId;
	}
	
}


