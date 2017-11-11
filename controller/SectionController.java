package com.example.finish.controller;


import com.example.finish.model.Course;
import com.example.finish.model.Department;
import com.example.finish.model.Section;
import com.example.finish.service.DepartmentService;
import com.example.finish.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/sections/view")
    public String viewSections(Model model){
        List<Section> sections = sectionService.getAllSections();
        model.addAttribute("sections", sections);
        model.addAttribute("department", new Department());

        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        model.addAttribute("section", new Section());

        return "section/sections";
    }

    @GetMapping("/section/delete/{id}")
    public String deleteSection(@PathVariable int id){
        try{
            sectionService.deleteSection(id);
        }catch (Exception e){
            return "error";
        }
        return "deleted";
    }

    @RequestMapping("/section/edit/{id}")
    public String editSection(@PathVariable int id, Model model){
        Section section = sectionService.getSectionById(id);
        model.addAttribute("section", section);
        return "section/edit_section";
    }

    @RequestMapping("/section/save")
    public String saveSection(@ModelAttribute("section") Section section){
        sectionService.addSection(section);
        System.out.println(section.getDepartment()+" is department");
        System.out.println(section+" is section");
        return "redirect:/sections/view";
    }



}
