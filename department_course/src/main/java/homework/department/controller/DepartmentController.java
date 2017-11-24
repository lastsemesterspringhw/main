package homework.department.controller;

import homework.department.model.Department;
import homework.department.model.DepartmentStudent;
import homework.department.model.Student;
import homework.department.service.DepartmentService;
import homework.department.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/department/add",method = RequestMethod.GET)
    public String renderNewDepartment(Model model){

        model.addAttribute("department", new Department());
        return "view/add-department";
    }

    @PostMapping("/department/add/new")
    public String newDepartment(@ModelAttribute("department") Department department){

        departmentService.saveDepartment(department);
        return "redirect:/department/list";
    }

    @RequestMapping("/department/list")
    public String departmentList(Model model){

        List<Department> departments = departmentService.findAllDepartments();
        model.addAttribute("departments",departments);

        return "view/list-department";
    }

    @RequestMapping(value = "/department/edit/{id}")
    public String editDepartment(@PathVariable("id") Long id,Model model){

        Department department = departmentService.findDepartmentById(id);
        model.addAttribute("department",department);

        return "view/add-department";
    }

    @RequestMapping(value = "/department/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Long id){
        departmentService.deleteDepartmentById(id);
        return "redirect:/department/list";
    }

    @GetMapping("/department/{id}/actions")
    public String departmentActions(@PathVariable("id") Long departmentId,Model model){
        Department department = departmentService.findDepartmentById(departmentId);
        model.addAttribute("department",department);
        model.addAttribute("students",department.getStudents());
        return "view/actions-department";
    }

    @GetMapping("/department/{id}/show_student_list")
    public String showStudentList(@PathVariable("id") Long departmentId,Model model){

        model.addAttribute("departmentId",departmentId);
        model.addAttribute("students",studentService.findAllStudents());
        model.addAttribute("departmentStudent",new DepartmentStudent());

        return "view/show-department-list";
    }
    @PostMapping("/department/{id}/set_students_to_department")
    public String setStudentsToDepartment(
            @PathVariable("id") Long departmentId, @ModelAttribute("DepartmentStudent")DepartmentStudent departmentStudent){

        Set<Student> students = new HashSet<>();

        for (Long studentId: departmentStudent.getStudentIds() ) {
            students.add(studentService.findStudentById(studentId));
        }

        Department department = departmentService.findDepartmentById(departmentId);
        department.setStudents(students);
        departmentService.saveDepartment(department);

        return "redirect:/department/"+departmentId+"/actions";
    }
}
