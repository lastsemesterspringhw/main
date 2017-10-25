package com.example.finish.controller;


import com.example.finish.model.Administrator;
import com.example.finish.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/signin")
    public String renderSignIn(Model model){
        model.addAttribute("administrator", new Administrator());
        return "signin";
    }

    @PostMapping("/admin/signin")
    public String authenticate(@ModelAttribute("administrator")Administrator administrator){
        String name = administrator.getName();
        String password = administrator.getPassword();

        boolean suchUserExists = adminService.suchUserExistsOrNot(name, password);
        if (suchUserExists){
            return "loggedin";
        }
        return "deleted";
    }


}
