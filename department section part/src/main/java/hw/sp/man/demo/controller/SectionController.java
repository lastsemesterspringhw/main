package hw.sp.man.demo.controller;

import hw.sp.man.demo.Services.SectionServices;
import hw.sp.man.demo.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SectionController {


    @Autowired
    private SectionServices sectionServices;


    @GetMapping("/section/add")
    public String rederAddSectionPage(Model model) {
        model.addAttribute("student ", new Section());

        return "add-section";


    }
        @GetMapping("/section/add")
        public String addSection(@ModelAttribute("section")Section section){

        sectionServices.save(section);
        return "redirect:/section/add";
    }
    @RequestMapping(value = {"/section/list","/"},method = RequestMethod.GET)
    public String listStudent(Model model){
        List<Section> sections = sectionServices.findAllSection();
        model.addAttribute("sections",sections);
        return "section-list";
    }

    @RequestMapping(value = "section/edit/{id}")
    public String editeSection(@PathVariable("id ")long id,Model model){
    Section section =  sectionServices.findAllSectionById(id);
        model.addAttribute("section",section);

        return "add-section";

    }

    @RequestMapping(value = "/section/delet/{id}")
    public String deletSection(@PathVariable("id")long id){
        sectionServices.deleteSection(id);
        return "redirect:/student/list";

    }
}
