package com.example.finish.service;

import com.example.finish.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    void deleteCourseById(int id);

    void saveNewCourse(Course course);

    Course getCourseById(int id);
}
