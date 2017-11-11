package com.example.finish.controller;

import com.example.finish.model.Administrator;
import com.example.finish.model.Course;
import com.example.finish.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course/view")
    public String viewCourses(Model model){

        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @RequestMapping("/course/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id){
        courseService.deleteCourseById(id);
        return "deleted";
    }

    @RequestMapping("/course/edit/{id}")
    public String editCourse(@PathVariable("id") int id, Model model){
        Course editCourse = courseService.getCourseById(id);
        model.addAttribute("course", editCourse);
        return "edit_course";
    }

    @RequestMapping("/course/save")
    public String saveCourse(@ModelAttribute Course course){
         courseService.saveNewCourse(course);
         return "redirect:/course/view";
    }



}
