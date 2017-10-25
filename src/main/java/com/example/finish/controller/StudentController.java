package com.example.finish.controller;


import com.example.finish.model.Student;
import com.example.finish.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/students/view")
    public String viewAllStudents(Model model){
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("students", studentList);

        return "student/view_students";
    }

    @RequestMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        studentService.deleteStudentById(id);
        return "deleted";
    }


    @RequestMapping("/student/edit/{id}")
    public String editStudent(@PathVariable long id, Model model){
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "student/edit_student";
    }


    @RequestMapping("/student/save")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/students/view";
    }
}
