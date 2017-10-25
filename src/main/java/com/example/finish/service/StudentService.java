package com.example.finish.service;

import com.example.finish.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void deleteStudentById(long id);

    Student findStudentById(long id);

    void addStudent(Student student);
}
