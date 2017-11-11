package com.example.finish.controller;


import com.example.finish.model.*;
import com.example.finish.repo.DepartmentRepository;
import com.example.finish.service.DepartmentService;
import com.example.finish.service.SectionService;
import com.example.finish.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private StudentService studentService;


    @GetMapping("/departments/view")
    public String showAllDepartments(Model model){

        List<Department> departmentList = departmentService.getAllDepartments();
        model.addAttribute("departments", departmentList);

        model.addAttribute("department", new Department());

        return "departments/view";
    }

    @PostMapping("/department/add")
    public String saveDepartment(@ModelAttribute("department") Department department){
        departmentService.add(department);
        return "redirect:/departments/view";
    }

    @GetMapping("/department/{id}/set_sections")
    public String setSections(@PathVariable("id") int id, Model model){
        model.addAttribute("department", departmentService.getDepartmentById(id));


        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);

        List<Section> sections = sectionService.getAllSections();
        model.addAttribute("sections", sections);

        model.addAttribute("SectionList", new SectionList());
        model.addAttribute("studentList", new StudentList());

        return "departments/set_sections_and_students";
    }

    @PostMapping("/department/{id}/set_sections")
    public String finalizeSettingSections(@PathVariable("id") int id, @ModelAttribute("SectionList") SectionList sectionList){
        Department department = departmentService.getDepartmentById(id);


        for(int secId: sectionList.getSectionIds()){
            sectionService.getSectionById(secId).setDepartment(department);
            sectionService.save(sectionService.getSectionById(secId));
        }

        return "departments/set_success";
    }

    @GetMapping("/department/{id}/delete")
    public String deleteDepartment(@PathVariable("id") int id){
        departmentService.deleteDepartmentById(id);
        return "redirect:/departments/view";
    }

    @GetMapping("/department/{id}/edit")
    public String editDepartment(@PathVariable("id") int id, Model model){
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("department", department);
        return "departments/department_edit";
    }

    @PostMapping("/department/{id}/set_students")
    public String setStudents(@ModelAttribute("studentList") StudentList studentList, @PathVariable("id") int id){

        Department department = departmentService.getDepartmentById(id);

        for(int studentId: studentList.getStudentIds()){
            studentService.findStudentById(studentId).setDepartment(department);
            studentService.save(studentService.findStudentById(studentId));
        }


        return "departments/set_success";
    }


}
