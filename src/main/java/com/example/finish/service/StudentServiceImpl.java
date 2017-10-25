package com.example.finish.service;

import com.example.finish.model.Student;
import com.example.finish.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.delete(id);
    }

    @Override
    public Student findStudentById(long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }
}
