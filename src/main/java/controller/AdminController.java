package controller;

import model.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import services.AdminService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/salam/dunya")
    public String hello(){
        return "salam dunya";
    }

    @GetMapping("/admin/render")
    public String renderAdminPage(Model model){
//
//        model.addAttribute("administrator", new Administrator());
//        List<Administrator> adminsList = adminService.getAllAdmins();
//        model.addAttribute("admins", adminsList);

        return "m";
    }

    @GetMapping("/")
    public String nothing(){
        return "default method";
    }

    @PostMapping("/admin/add")
    public String addAdmin(@ModelAttribute("admin") Administrator administrator){
        adminService.save(administrator);

        return "redirect:/admin/render";
    }

}
