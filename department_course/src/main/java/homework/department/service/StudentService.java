package homework.department.service;

import homework.department.model.Student;

import java.util.List;

public interface StudentService {
    void addNewStudent(Student student);

    List<Student> findAllStudents();

    Student findStudentById(Long id);

    void deleteStudentById(Long id);
}
