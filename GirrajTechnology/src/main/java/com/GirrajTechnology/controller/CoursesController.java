package com.GirrajTechnology.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.GirrajTechnology.model.Courses;
import com.GirrajTechnology.service.CoursesService;

@CrossOrigin(origins = "http://www.girrajtechnology.com")
@RestController
@RequestMapping("/api")
public class CoursesController {
	
	@Autowired
	CoursesService courseService;
	
	@GetMapping("/getAllCourses")
	public ResponseEntity<?> getCoursesDetail(){
	List<Courses> coursesList=courseService.getAllCoursesInfo();
		return ResponseEntity.ok(coursesList);
		
	}
	
	@GetMapping("/getAllCoursesName")
	public ResponseEntity<?> getCoursesName(){
	Set<String> coursesList=courseService.getAllCoursesName();
		return ResponseEntity.ok(coursesList);
		
	}
	
	
	
	@PostMapping("/saveCourses")
	public ResponseEntity<?> saveCoursesDetail(@RequestBody Courses courses){
	
		courseService.saveCourse(courses);
		
		return ResponseEntity.ok("Course detail save successfully");
		
	}
	
	@PutMapping("/editCourses")
	public ResponseEntity<?> editCourse(@RequestBody Courses updatedCourse) {
	    try {
	        Courses existingCourse = courseService.getCourseById(updatedCourse.getId());
	        if (existingCourse != null) {
	            // Update only the fields provided in updatedCourse
	            if (updatedCourse.getCourseName() != null) {
	                existingCourse.setCourseName(updatedCourse.getCourseName());
	            }
	            if (updatedCourse.getCourseDetail() != null) {
	                existingCourse.setCourseDetail(updatedCourse.getCourseDetail());
	            }
	            if (updatedCourse.getDuration() != null) {
	                existingCourse.setDuration(updatedCourse.getDuration());
	            }
	            // Add more fields to update as required

	            courseService.saveCourse(existingCourse); // Save updated course
	            return ResponseEntity.ok("Course updated successfully");
	        } else {
	            return ResponseEntity.badRequest().body("Course not found");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(500).body("Error updating course: " + e.getMessage());
	    }
	}

}
