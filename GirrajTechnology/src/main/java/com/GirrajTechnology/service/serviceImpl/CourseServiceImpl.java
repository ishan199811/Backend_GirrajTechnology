package com.GirrajTechnology.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GirrajTechnology.model.Courses;
import com.GirrajTechnology.repository.CoursesRepository;
import com.GirrajTechnology.service.CoursesService;


@Service
public class CourseServiceImpl implements CoursesService{
	
	@Autowired
	CoursesRepository coursesRepository;

	@Override
	public List<Courses> getAllCoursesInfo() {
		// TODO Auto-generated method stub
		List<Courses> coursesList=coursesRepository.findAll();
		
		return coursesList;
	}

	@Override
	public void saveCourse(Courses courses) {
		// TODO Auto-generated method stub
		coursesRepository.save(courses);
	}

	@Override
	public Set<String> getAllCoursesName() {
		// TODO Auto-generated method stub
		List<Courses> coursesList=coursesRepository.findAll();
		
		Set<String> coursesName=new HashSet<String>();
		
	coursesList.stream().forEach(c -> {
		coursesName.add(c.getCourseName());
	});
		
		return coursesName;
	}

	@Override
	public Courses getCourseById(Long id) {
	    Optional<Courses> courses = coursesRepository.findById(id);

	    // Return the course if present, otherwise throw an exception
	    return courses.orElseThrow(() -> new RuntimeException("Course not found for ID: " + id));
	}
	
	
	

}
