package com.GirrajTechnology.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GirrajTechnology.model.Courses;

public interface CoursesRepository extends JpaRepository<Courses ,Long>{

	

	Courses findByCourseName(String courseName);

	Courses getById(Long id);

}
