package com.example.finish.service;

import com.example.finish.model.Department;
import com.example.finish.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void add(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(int id) {
        departmentRepository.delete(id);
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }
}
