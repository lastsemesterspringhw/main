package com.example.finish.service;

import com.example.finish.model.Course;
import com.example.finish.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourseById(int id) {
        courseRepository.delete(id);
    }

    @Override
    public void saveNewCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findOne(id);
    }
}
