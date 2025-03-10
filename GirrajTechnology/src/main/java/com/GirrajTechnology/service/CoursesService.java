package com.GirrajTechnology.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.GirrajTechnology.model.Courses;

public interface CoursesService {

List<Courses> getAllCoursesInfo();

void saveCourse(Courses courses);

Set<String> getAllCoursesName();

Courses getCourseById(Long id);

}
