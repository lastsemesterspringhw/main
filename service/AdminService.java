package com.example.finish.service;

import com.example.finish.model.Administrator;

import java.util.List;

public interface AdminService {
    boolean suchUserExistsOrNot(String name, String password);

    List<Administrator> getAllAdmins();
}
