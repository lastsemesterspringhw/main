package com.example.finish.service;


import com.example.finish.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    List<Department> getAllDepartments();

    void add(Department department);

    void deleteDepartmentById(int id);

    Department getDepartmentById(int id);

    void saveDepartment(Department department);
}
