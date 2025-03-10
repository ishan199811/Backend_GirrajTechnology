package com.GirrajTechnology.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;




@Entity
public class Courses {
	
	 private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;
	
	String courseName;
	
	String courseDetail;
	
	String duration;
	
	
@OneToMany(fetch = FetchType.LAZY, mappedBy = "coursesId", cascade = CascadeType.ALL)
private List<Topic> topic = new ArrayList<Topic>();

	public List<Topic> getTopic() {
	return topic;
}

public void setTopic(List<Topic> topic) {
	this.topic = topic;
}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDetail() {
		return courseDetail;
	}

	public void setCourseDetail(String courseDetail) {
		this.courseDetail = courseDetail;
	}

}
