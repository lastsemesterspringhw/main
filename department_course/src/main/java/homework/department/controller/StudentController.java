package homework.department.controller;

import homework.department.model.Student;
import homework.department.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student/add",method = RequestMethod.GET)
    public String renderNewStudent(Model model){
        model.addAttribute("student", new Student());
        return "view/add-student";
    }

    @PostMapping("/student/add/new")
    public String addNewStudent(@ModelAttribute("student") Student student){
        studentService.addNewStudent(student);
        return "redirect:/student/list";
    }

    @RequestMapping("/student/list")
    public String studentList(Model model){
        List<Student> studentList = studentService.findAllStudents();
        model.addAttribute("students",studentList);
        return "view/list-student";
    }

    @RequestMapping(value = "/student/edit/{id}")
    public String editStudent(@PathVariable("id") Long id,Model model){
        Student student = studentService.findStudentById(id);
        model.addAttribute("student",student);
        return "view/add-student";
    }

    @RequestMapping(value = "/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);
        return "redirect:/student/list";
    }
}
