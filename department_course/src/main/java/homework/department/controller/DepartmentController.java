package homework.department.controller;

import homework.department.model.Department;
import homework.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/department/add",method = RequestMethod.GET)
    public String renderNewDepartment(Model model){

        model.addAttribute("department", new Department());
        return "view/add-department";
    }

    @PostMapping("/department/add/new")
    public String newDepartment(@ModelAttribute("department") Department department){

        departmentService.addNewDepartment(department);
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
}
