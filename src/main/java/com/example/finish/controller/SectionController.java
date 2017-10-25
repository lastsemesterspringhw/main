package com.example.finish.controller;


import com.example.finish.model.Course;
import com.example.finish.model.Section;
import com.example.finish.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping("/sections/view")
    public String viewSections(Model model){
        List<Section> sections = sectionService.getAllSections();
        model.addAttribute("sections", sections);
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
        return "redirect:/sections/view";
    }


}
